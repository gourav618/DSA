package Sorting.Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SortElementInArrayByFrequency {
    public static void main(String[] args){
        //https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency/0

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0){
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i=0; i<n; i++){
                arr[i] = s.nextInt();
            }
            sortArrayByFrequency(arr, n);
        }
    }

    static class Pair {
        int elem;
        int freq;
    }

    private static void sortArrayByFrequency(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++){
            if (map.containsKey(arr[i])){
                map.replace(arr[i], map.get(arr[i])+1);
            }else {
                map.put(arr[i], 1);
            }
        }
        List<Pair> pairs = new ArrayList<>();
        for (int i=0; i<n; i++){
            Pair p = new Pair();
            p.elem = arr[i];
            p.freq = map.get(arr[i]);
            pairs.add(p);
        }

        pairs.sort((p1, p2) -> {
            if (p1.freq == p2.freq){
                return Integer.compare(p1.elem, p2.elem);
            }else {
                return Integer.compare(p2.freq, p1.freq);
            }
        });

        for (Pair p : pairs){
            System.out.print(p.elem+" ");
        }
        System.out.println();
    }
}
