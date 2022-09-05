package Sorting.Concept;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String [] args){
        //Insertion Sort
//        Sorting algorithms are mainly of two types:
//        Comparison based sorting - In this type of algorithm, we need to compare the array elements with each other in
//        order to sort them. They are generally O(N2) or O(NlogN) algorithms. Eg. Insertion sort, Bubble sort etc.
//
//        Non-comparison based sorting - This type of sorting algorithm does not involve comparison between elements.
//
//        Insertion sort is a sorting algorithm where the array is virtually divided into two halves - sorted and unsorted.
//        The values from the unsorted array are picked one by one and placed at their correct position in the sorted array.
//        It is a stable algorithm as it maintains the order of duplicate elements.
//
//        The time complexity of Insertion sort depends on the degree of unsortedness of the
//        array. In the worst-case scenario, it is O(N^2).

         int [] arr = {4, 1, 4, 3, 2};

         for (int i=0; i< arr.length; i++){
             int j = i;
             while (j > 0 && arr[j] < arr[j-1]){
                 swap(arr, j);
                 j--;
             }
         }

        Arrays.stream(arr).forEach(i -> System.out.print(i+" "));
    }

    private static void swap(int[] arr, int j) {
        int tmp = arr[j-1];
        arr[j-1] = arr[j];
        arr[j] = tmp;
    }
}
