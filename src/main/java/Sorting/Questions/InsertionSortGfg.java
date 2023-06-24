package Sorting.Questions;

import java.util.Arrays;

public class InsertionSortGfg {
    public static void main(String[] args){
        //https://practice.geeksforgeeks.org/problems/insertion-sort/1

        int[] arr = {4,1,3,9,7};
        insertionSort(arr, arr.length);
        Arrays.stream(arr).forEach(i -> System.out.print(i+" "));
    }

    private static void insertionSort(int[] arr, int n) {

        for (int i=1; i<n; i++){
            int j=i;
            while (j > 0 && arr[j] < arr[j-1]){
                insert(arr, j);
                j--;
            }
        }
    }

    private static void insert(int[] arr, int i) {
        int temp = arr[i-1];
        arr[i-1] = arr[i];
        arr[i] = temp;
    }
}
