package Searching.Concept;

import java.util.Arrays;

public class KthSmallestElement {
    /* Class Pair is used to return two values from getMinMax() */
    static class Pair {

        int min;
        int max;
    }

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


//        K-th Smallest in Array-2
//
//        In this lecture, we will continue with the previous problem and learn how to use the concept of monotonicity
//        to apply binary search on the answer.
//
//        We have been given an unsorted array Arr[N] and we have to find the kth smallest element.
//        Input: Arr[9] = {40, 10, 10, 30, 40, 20, 50, 90, 50}, k=6
//        Output: 40
//        Approach:
//
//        As discussed in the previous lecture, f(x) is a monotonically increasing function where x = Arr[i] and
//        f(x) = Count of elements less than or equal to Arr[i].
//        The answer can vary in the range of minimum and the maximum element of the array. Therefore we can run a
//        binary search on the answer - [min, max] and shift the mid according to the monotonic rule f(x).
//        If Cntmid<k, it means that it is not the answer and we can shift our low to mid+1.
//        If Cntmid>=k, then it may be the answer, therefore we check the value of count for (mid-1).
//        If we get Cnt>=k then we shift high=mid-1, otherwise if Cnt<k, then mid is the answer.
//        Time complexity: O(Nlog(max-min))
//        Space complexity: O(1)
        int []arr1 = {40, 10, 10, 30, 40, 20, 50, 90, 50};
        int kthSmallestElementUsingBinarySearch = findKthSmallestElementUsingBinarySearch(arr1, 6);
        System.out.println(kthSmallestElementUsingBinarySearch);

    }

    private static int findKthSmallestElementUsingBinarySearch(int[] arr, int k) {
        Pair minMax = getMinMax(arr, arr.length);
        int l = minMax.min, h = minMax.max;

        while (l<=h){
            int m = (l+h)/2;
            int cnt = countFunc(arr, m);

            if (cnt < k){
                l = m+1;
            }else {
                int cnt1 = countFunc(arr, m - 1);
                if (cnt1 < k){
                    return m;
                }else {
                    h = m-1;
                }
            }
        }
        return -1;
    }

    private static Pair getMinMax(int[] arr, int n) {
        Pair minMax = new Pair();

        /*If there is only one element then return it as min and max both*/
        if (n == 1) {
            minMax.max = arr[0];
            minMax.min = arr[0];
            return minMax;
        }

        /* If there are more than one elements, then initialize min
    and max*/
        if (arr[0] > arr[1]) {
            minMax.max = arr[0];
            minMax.min = arr[1];
        } else {
            minMax.max = arr[1];
            minMax.min = arr[0];
        }

        for (int i = 2; i < n; i++) {
            if (arr[i] > minMax.max) {
                minMax.max = arr[i];
            } else if (arr[i] < minMax.min) {
                minMax.min = arr[i];
            }
        }

        return minMax;
    }

    //count of elem<=x in array --> monotonic function
    static int countFunc(int[] arr, int x){
        int count = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i] <= x){
                count++;
            }
        }
        return count;
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
