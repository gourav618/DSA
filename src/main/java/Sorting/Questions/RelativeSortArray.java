package Sorting.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RelativeSortArray {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=151&sectionId=1&moduleId=2&topicId=7&subtopicId=85&homeworkId=18
        //https://leetcode.com/problems/relative-sort-array/
        Scanner s = new Scanner(System.in);
        Integer[] nM = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] arr1 = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] arr2 = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        int[] rank = new int[1001];
        Arrays.fill(rank, Integer.MAX_VALUE);
        for (int i=0; i<nM[1]; i++){
            rank[arr2[i]] = i+1;
        }

        List<Pair> arr1WithRank = new ArrayList<>();
        for (int i=0; i<nM[0]; i++){
            Pair p = new Pair();
            p.elem = arr1[i];
            p.rank = rank[arr1[i]];
            arr1WithRank.add(p);
        }

        arr1WithRank.sort((e1, e2) -> {
            if (e1.rank == e2.rank){
                return Integer.compare(e1.elem, e2.elem);
            }else {
                return Integer.compare(e1.rank, e2.rank);
            }
        });

        for (Pair p : arr1WithRank){
            System.out.print(p.elem+" ");
        }
        System.out.println();
    }

    static class Pair{
        int elem;
        int rank;
    }
}
