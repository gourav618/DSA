package Sorting.Concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextGreaterPermutation {
    public static void main(String [] args){
//        Next Greater Permutation
//        We have been given an integer array Arr[N] and we have to find out the lexicographically next greater permutation of Arr[ ].
//
//        Input: Arr[7] = {5, 7, 6, 3, 6, 4, 2}
//        Output: {5, 7, 6, 4, 2, 3, 6}
//
//        What do we mean by Lexicographically Greater?
//
//        S1 = 1, 7, 9, 17,...
//        S2 = 1, 7, 9, 10,...
//        S1 is a lexicographically greater permutation than S2
//
//        Approach:
//
//        Brute Force - We can use recursion to generate all the permutations and store them in a vector of vectors.
//        We can sort them to find the next greater permutation.
//        Time complexity: O(N!)
//        Space complexity: O(N!)
        int []arr = {5,10,6,4,9};
        nextGreaterPermutationBruteForce(arr);// original array should be sorted

//        We can analyse the array from the end to find the element (say ‘x’) that is breaking the increasing sequence
//        towards left. E.g. The element ‘2’ in the below illustration is not in its right place.
//
//        After finding the element ‘x’, we need to revisit the sub-array on the right place ‘x’ at its correct location, here ‘4’.
//
//        Now we need to reverse the array to get the next greater permutation.
//        Note:
//        Edge case: If the given array is already sorted in descending order then it is the greatest permutation and
//        hence no next greater permutation exists.

        nextGreaterPermutationOptimalApproach(arr.clone());

//        Using this approach we can find all the permutations by starting with the smallest permutation.
        printAllPermutationUsingOptimalApproach(arr);
    }

    private static void printAllPermutationUsingOptimalApproach(int[] arr) {
        int []arr1 = arr.clone();
        Arrays.sort(arr1);

        System.out.println("***********************");
        System.out.println(Arrays.toString(arr1));
        while (!isDescending(arr1)){
            nextGreaterPermutationOptimalApproach(arr1);
        }
    }

    private static boolean isDescending(int[] arr) {
        for (int i=0; i< arr.length-1; i++){
            if (arr[i] < arr[i+1]){
                return false;
            }
        }
        return true;
    }

    private static void nextGreaterPermutationOptimalApproach(int[] arr) {
        int x = arr.length-1; //size of array

        //figure out index where the descending trend breaks
        while (x>0 && arr[x] <= arr[x-1]){
            x--;
        }
        //replace the elem where descending trend broke with elem just greater from suffix part
        if (x-1 >= 0){ //since if x broke in 0th index then the array is descending sorted and no greater permutation available
            for (int y= arr.length-1; y>=x; y--){
                if (arr[y] > arr[x-1]){
                    swap(x-1, y, arr);
                    break;
                }
            }
            //sort the suffix in ascending order
            int i=x, j= arr.length-1;
            while (i<j){
                swap(i, j, arr);
                i++;
                j--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int a, int b, int [] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void nextGreaterPermutationBruteForce(int[] arr) {
        //sort array for permutation to be in lexicographic order
        int [] arr1 = arr.clone();
        Arrays.sort(arr1);

        List<int[]> allPermutation = new ArrayList<>();
        //get all permutation in lexicographic order
        getAllPermutation(arr1, 0, allPermutation);
//        allPermutation.forEach(i -> {
//            for (int k=0; k<i.length; k++){
//                System.out.print(i[k]+" ");
//            }
//            System.out.println();
//        });

        int i;
        //traverse all permutation find the arr in that and return next permutation in list
        for (i=0; i<allPermutation.size(); i++){
            if (Arrays.equals(allPermutation.get(i), arr)){
                break;
            }
        }

        int[] nextGreaterPermutation = allPermutation.get(i + 1);
        System.out.println(Arrays.toString(nextGreaterPermutation));
    }

    private static void getAllPermutation(int[] arr, int i, List<int[]> allPermutation) {
        if (i == arr.length-1){
            allPermutation.add(arr.clone());
            return;
        }

        for (int j=i; j< arr.length; j++){
            rightRotate(i, j, arr);
            getAllPermutation(arr, i+1, allPermutation);
            leftRotate(i, j, arr);
        }
    }

    private static void leftRotate(int i, int j, int[] arr) {
        int temp = arr[i];
        for (int k=i; k<j; k++){
            arr[k] = arr[k+1];
        }
        arr[j] = temp;
    }

    private static void rightRotate(int i, int j, int[] arr) {
        int temp = arr[j];
        for (int k=j; k>i; k--){
            arr[k] = arr[k-1];
        }
        arr[i] = temp;
    }
}
