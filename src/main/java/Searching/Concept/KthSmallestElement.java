package Searching.Concept;

import java.util.Arrays;

public class KthSmallestElement {
    public static void main(String[] args){
//        K-th Smallest in Array-1
//        We have been given an unsorted array Arr[N] and we have to find the kth smallest element.
//                Input: Arr[8] = {40, 10, 10, 30, 40, 20, 50, 70, 50}, k=6
//        Output: 40
//
//        Approach:
//
//        We can sort the array and return Arr[k-1] as the answer.
//                Input: Arr = [40, 10, 10, 30, 40, 20, 50, 70, 50], k=6
//        After sorting: Arr = [10, 10, 20, 30, 40, 40, 50, 50, 70]
//
//        Time complexity: O(NlogN)
//        Space complexity: O(1)

        int[] arr = {40, 10, 10, 30, 40, 20, 50, 70, 50};
        findSmallestKthElemByModifyingArray(arr.clone(), 6);
//
//        But what will we do in the case when we are not allowed to tamper with the original array?
//                We can copy the array to a temporary array and sort it to return Arr[k-1] as the answer.
//                Input: Arr = [40, 10, 10, 30, 40, 20, 50, 70, 50], k=6
//        temp = [40, 10, 10, 30, 40, 20, 50, 70, 50]
//        Sorted array temp = [10, 10, 20, 30, 40, 40, 50, 50, 70]
//
//        Time complexity: O(NlogN)
//        Space complexity: O(N)

        findSmallestKthElemWhenTemparingArrayNotAllowed(arr.clone(), 6);

//        Hint: Think of some property related to the answer.
//        Place the cows_binary search
//        Arr[i] will be the required answer only when CntArr[i]>=k and Cnt’Arr[i]<k.
//                Where, CntArr[i] = Count of elements less than or equal to Arr[i]
//        Cnt’Arr[i] = Count of elements exactly less than Arr[i]
//        Thus we can use brute force to calculate the above two values for each array element to find the answer.
//                Time complexity: O(N^2)
//        Space complexity: O(1)
        //if extra space not allowed??
        findSmallestKthElemWithoutExtraSpaceAndTamperingArray(arr, 6);
    }

    private static void findSmallestKthElemWithoutExtraSpaceAndTamperingArray(int[] arr, int k) {
        //select all the elem 1 by 1 from 0th index i.e x
        for (int i=0; i< arr.length; i++){
            int smaller=0, equal=0;
            //count elem smaller and equal to selected elem x which is arr[i]
            for (int j=0; j<arr.length; j++){
                if (arr[j] < arr[i]){
                    smaller++;
                }else if (arr[j] == arr[i]){
                    equal++;
                }
            }
            int total = smaller+equal;
            if (total >= k && smaller < k){
                System.out.println(arr[i]);
                return;
            }
        }
    }

    private static void findSmallestKthElemWhenTemparingArrayNotAllowed(int[] arr, int k) {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        System.out.println(temp[k-1]);
    }

    private static void findSmallestKthElemByModifyingArray(int[] arr, int k) {
        Arrays.sort(arr);
        System.out.println(arr[k-1]);
    }
}
