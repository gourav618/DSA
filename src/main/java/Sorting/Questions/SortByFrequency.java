package Sorting.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortByFrequency {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=128&sectionId=1&moduleId=2&topicId=7&subtopicId=85&assignmentId=18
        //https://www.geeksforgeeks.org/sort-elements-by-frequency/

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0){
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i=0; i<n; i++){
                arr[i] = s.nextInt();
            }
            sortByFrequency(arr, n);
        }
    }

    static class Pair{
        int val;
        int freq;
    }

    private static void sortByFrequency(int[] arr, int n) {
        int[] freq = new int[61];
        for (int i=0; i<n; i++){
            freq[arr[i]]++;
        }

        List<Pair> elem = new ArrayList<>();
        for (int i=0; i<n; i++){
            Pair p = new Pair();
            p.val = arr[i];
            p.freq = freq[arr[i]];
            elem.add(p);
        }

        elem.sort((o1, o2) -> {
            if (o1.freq != o2.freq){
                return Integer.compare(o2.freq, o1.freq);
            }
            else {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for (Pair p : elem){
            System.out.print(p.val+" ");
        }
        System.out.println();
    }
}
