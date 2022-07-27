package Searching.Concept;

public class KthSmallestElementInMatrix {

    /* Class Pair is used to return two values from getMinMax() */
    static class Pair {

        int min;
        int max;
    }

    public static void main(String[] args){
//        K-th Smallest in Matrix
//        We have been given a 2D matrix of dimension NxN where each row is sorted. We have to find the kth smallest
//        element in the matrix.
//                Input: Arr = [{1 3 5}, {1 2 9}, {4 5 6}], k=6
//                Output: 5    ∵ [1 1 2 3 4 5 5 6 9]
//        Approach:
//
//        Copy the original array to a temporary array temp[N2]. Sort it and return Arr[k-1].
//                Time complexity: O(N2logN)
//        Space complexity: O(N^2)
//        We can also try the approach followed in the previous lecture. We can run a binary search on the answer and
//        find the count of elements less than or equal to the mid.
//        Time complexity: O(N2log(max-min))
//        Space complexity: O(1)
//
//        But we can achieve this time complexity even when the rows are unsorted. Can we do better than this?
//                We can use the above fact to count Cnt using binary search in each row.
//        Cntmid = Cntrow=1 + Cntrow2 + ... + Cntrow = N
//        Time complexity: O(Nlog(N)log(max-min))
//        Space complexity: O(1)
//        Note: You can also use the upper_bound & lower_bound functions for the third approach. They are internally
//        implemented using binary search only.

        int[][] arr = {{1,3,5}, {1,2,9}, {4,5,6}};
        int kthSmallestElementInMatrix = findKthSmallestElementInMatrix(arr, 6);
        System.out.println(kthSmallestElementInMatrix);
    }

    private static int findKthSmallestElementInMatrix(int[][] arr, int k) {
        Pair minMax = getMinMax(arr, arr.length);
        int l = minMax.min , h = minMax.max;

        while (l<=h){
            int m = (l+h)/2;
            int count = countFunc(arr, m);

            if (count<k){
                l = m+1;
            }else {
                int count1 = countFunc(arr, m - 1);
                if (count1 < k){
                    return m;
                }else {
                    h = m-1;
                }
            }
        }
        return -1;
    }

    private static int countFunc(int[][] arr, int m) {
//        int count = binarySearchToFindUpperBound(arr[0], m);
        int count = 0;
        for (int i=0; i<arr.length; i++){
            count += binarySearchToFindUpperBound(arr[i], m);
        }
        return count;
    }

    private static int binarySearchToFindUpperBound(int[] arr, int m) {
        int l=0, h= arr.length-1;
        while (l<=h){
            int mid = (l+h)/2;

            if (arr[mid] <= m){
                l = mid+1;
            }else {
                if (arr[mid-1] > m){
                    h = mid-1;
                }else {
                    return mid;
                }
            }
        }
        return l;
    }

    private static Pair getMinMax(int[][] arr, int length) {
        Pair minMax = new Pair();

        minMax.min = arr[0][0];
        // find min
        for (int i=1; i< length-1; i++){
            if (arr[i][0] < minMax.min){
                minMax.min = arr[i][0];
            }
        }

        minMax.max = arr[0][length-1];
        // find max
        for (int i=1; i< length-1; i++){
            if (arr[i][length-1] > minMax.max){
                minMax.max = arr[i][length-1];
            }
        }
        return minMax;
    }
}
