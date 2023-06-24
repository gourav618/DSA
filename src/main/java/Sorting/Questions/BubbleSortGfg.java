package Sorting.Questions;

import java.util.Arrays;

public class BubbleSortGfg {
    public static void main(String[] args){
        //https://practice.geeksforgeeks.org/problems/bubble-sort/1

        int[] arr = {4,1,3,9,7};
        bubbleSort(arr, arr.length);
        Arrays.stream(arr).forEach(i-> System.out.print(i+" "));
    }

    private static void bubbleSort(int[] arr, int n) {
        boolean done = false;
        while (!done){
            done = true;
            int i=0;
            while (i<n-1){
                if (arr[i] > arr[i+1]){
                    swap(arr, i);
                    done = false;
                }
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i) {
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
    }
}
