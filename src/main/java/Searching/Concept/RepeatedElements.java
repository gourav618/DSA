package Searching.Concept;

public class RepeatedElements {
    public static void main(String[] args){
//        Repeated Element
//        We have been given a sorted integer array Arr[N] containing elements from 1 to N-1 with one element occurring
//        twice in the array. Find out that element, given that N>=2.
//
//        Input: Arr[8] = {1, 2, 3, 4, 5, 5, 6, 7}
//        Output: 5
//
//        Approach:
//
//        On observing the elements before and after the repeated element we will find that they have
//        distinct identification characteristics.
//
//        From the above illustration, it is clear that our key will be the last element of the subarray
//        defined by Arr[i]=i+1. Thus, we can use binary search to find the repeated element such that Arr[mid] = Arr[mid+1].
//        Time complexity: O(log2N)
//        Space complexity: O(1)

        int[] arr = {1,2,3,4,5,5,6,7};

        //using linear search
        findRepeatedElementsUsingLinearSearch(arr);

        //using binary search
        int repeatedElements = findRepeatedElements(arr);
        System.out.println(repeatedElements !=-1 ? repeatedElements : "no repeated elem!");
    }

    private static void findRepeatedElementsUsingLinearSearch(int[] arr) {
        for (int i=0; i<arr.length; i++){
            if (arr[i] == arr[i+1]){
                System.out.println(arr[i]);
                break;
            }
        }
    }


    private static int findRepeatedElements(int[] arr) {
        int l=0, h= arr.length-1;

        while (l<=h){
            int m = (l+h)/2;
            if (arr[m] == m) {// we are in 2nd part
                h = m-1;
            }else {// go to 1st part
                if (arr[m+1] == arr[m]){ // exactly at 1st occurance of repeated elem
                    return arr[m];
                }else {
                    l = m+1;
                }
            }
        }
        return -1;
    }
}
