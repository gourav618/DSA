package Searching.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class KWeakestRows {
    static class Pair {
        int index;
        int count;
        Pair(int i, int c){
            this.index = i;
            this.count = c;
        }
    }
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/practice/question?questionId=111&sectionId=1&moduleId=2&topicId=6&subtopicId=68&homeworkId=14

        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> dim = Arrays.stream(s.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int [][] mat = new int[dim.get(0)][dim.get(1)];
        for (int i=0; i < dim.get(0); i++){
            List<Integer> row = Arrays.stream(s.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            for (int j=0; j < dim.get(1); j++){
                mat[i][j] = row.get(j);
            }
        }
        List<Pair> weakness = new ArrayList<>();
        for (int i=0; i< dim.get(0); i++){
            int [] row = mat[i];
            int lastOccurrence = findWeaknessCount(0, row.length - 1, row);
            weakness.add(new Pair(i, lastOccurrence+1));
        }

        weakness.sort((p1, p2) -> {
            if (p1.count == p2.count){
                return p1.index > p2.index ? 1 : -1;
            }
            return p1.count > p2.count ? 1 : -1;
        });

        for (Pair p : weakness){
            System.out.print(p.index + " ");
        }
    }

    private static int findWeaknessCount(int l, int h, int[] arr) {
        while (l<=h){
            int mid = (l+h)/2;
            if (arr[mid] > 1){
                l = mid+1;
            } else if (arr[mid] < 1) {
                h = mid-1;
            }else {
                if (mid == arr.length-1){
                    return mid;
                } else if (arr[mid + 1] != 1) {
                    return mid;
                }else {
                    l = mid+1;
                }
            }
        }
        return -1;
    }
}
