package Sorting.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QualifyingContest {
    public static void main(String[] args){
        //https://codeforces.com/contest/659/problem/B


        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        s.nextLine();
        List<Triplet> participants = new ArrayList<>();
        int[] studentsPerRegion = new int[m];
        for (int i=0; i<n; i++){
            Triplet t = new Triplet();
            String[] s1 = Arrays.stream(s.nextLine().split(" ")).toArray(String[]::new);
            t.name = s1[0];
            t.region = Integer.parseInt(s1[1]);
            t.score = Integer.parseInt(s1[2]);
            studentsPerRegion[t.region-1]++;
            participants.add(t);
        }

        participants.sort((t1, t2) -> {
            if (t1.region == t2.region){
                return Integer.compare(t2.score, t1.score);
            }else {
                return Integer.compare(t1.region, t2.region);
            }
        });

        int numberOfStudentsInPrevRegion = 0;
        for (int i=0; i<m; i++){
            int totalStudentInRegion = studentsPerRegion[i];
            if (i==0){
                if (totalStudentInRegion > 2 && participants.get(1).score == participants.get(2).score){
                    System.out.println("?");
                }else {
                    if (totalStudentInRegion >= 2) {
                        System.out.println(participants.get(0).name + " " + participants.get(1).name);
                    }else {
                        System.out.println("?");
                    }
                }
            }else {
                if (totalStudentInRegion > 2 && participants.get(numberOfStudentsInPrevRegion+1).score
                        == participants.get(numberOfStudentsInPrevRegion+2).score) {
                    System.out.println("?");
                }else {
                    if (totalStudentInRegion >= 2) {
                        System.out.println(participants.get(numberOfStudentsInPrevRegion).name + " " + participants.get(numberOfStudentsInPrevRegion+1).name);
                    }else {
                        System.out.println("?");
                    }
                }
            }
            numberOfStudentsInPrevRegion += totalStudentInRegion;
        }


        //(n*m) time complexity
        //printQualifyingTeams(n, m, participants);
    }

    private static void printQualifyingTeams(int n, int m, List<Triplet> participants) {
        List<List<String>> teams = new ArrayList<>();
        for (int i = 0; i< m; i++){
            int count = 0, prev = -1;
            List<String> t = new ArrayList<>();
            for (int j = 0; j< n; j++){
                if (count < 2 && prev != participants.get(j).score && participants.get(j).region == i+1){
                    t.add(participants.get(j).name);
                    prev = participants.get(j).score;
                    count++;
                }else {
                    if (prev == participants.get(j).score){
                        count++;
                    }
                }
            }
            if (t.size() == 2 || count < 2){
                teams.add(t);
            }else {
                teams.add(List.of("?"));
            }
        }

        for (List<String> i : teams){
            for (int j=0; j<i.size(); j++){
                if (j != i.size()-1) {
                    System.out.print(i.get(j)+" ");
                }else {
                    System.out.print(i.get(j));
                }
            }
            System.out.println();
        }
    }

    static class Triplet {
        String name;
        int region;
        int score;
    }
}
