package Sorting.Concept;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
//        Bubble Sort
//        Bubble sort is a simple sorting algorithm where the adjacent array elements are repeatedly swapped if they are
//        in the wrong order until the array becomes sorted. We assume the array elements to be a bubble of different sizes
//        (larger the element, larger the bubble) and perform multiple iterations and in each iteration, we get the largest
//        element of the remaining array at its appropriate position.
//
//        Time complexity: O(N^2)
//        Worst case scenario: When the array is in descending order

//        Trouble sort: Bubble sort can also be explained by considering subarrays of size 2 which are reversed in each
//        iteration if their order is incorrect.
//
//        Similarly, can we consider subarrays of size 3 in each iteration and revert them if the first and the third
//        element are not in order to get a sorted array?
//
//        No, it will not give us a sorted array in each case.
//
//        Eg. Arr = [10, 11, 1, 7] -> [1, 7, 10, 11] (sorted output)
//
//        Arr = [4, 3, 2, 1] -> [2, 1, 4, 3] (unsorted output)
//
//        Can you predict the result of trouble sorting without actually implementing it?
//
//        On carefully observing, we note that the elements at even indices and at odd indices get sorted separately.
//        Thus, we can create two temporary arrays to store the elements at even and odd indices. We can sort them separately
//        with the help of the merge sort or inbuilt sort function and merge them to get the desired output.
//
//        Time complexity: O(Nlog2N)
//        Space complexity: O(N)

        int []arr = {9,7,3,1,2};
        boolean done = false;
        while (!done){
            done = true;
            int i=0;
            while (i< arr.length-1){ //0 to n-1 for each sub-array of size 2
                if (arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                    done = false; //if swap done in array i.e array not sorted
                }
                i++;
            }
        }
        Arrays.stream(arr).forEach(i -> System.out.print(i+" "));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
    }

}
