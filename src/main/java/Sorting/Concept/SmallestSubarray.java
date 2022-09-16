package Sorting.Concept;

public class SmallestSubarray {
    public static void main(String[] args){
//        Smallest Sub-array
//        We have been given an array Arr[N] containing only positive elements and an integer ‘k’.
//        We have to return the length of the smallest subarray with sum >= k.
//
//        Input: Arr [7] = {5 1 4 3 2 9}; k=10
//        Output: 2
//
//        Approach:
//        Brute Force - We can calculate the sum of the subarrays for all the starting indices and compare their lengths for sum >= k.
//                Time complexity: O(N^2)
//
        int []arr = {5,1,4,3,2,9};
        int k = 10;
        bruteForce(arr, k);

//        Optimal approach : We can calculate the prefix sum of the array and then apply binary search on the modified
//        array to find the minimum length subarray for each starting index with sum>=k and compare them to find the
//        minimum length of the subarray.
//                Time complexity: O(N*log2N)
        optimalApproach(arr, k);
    }

    private static void optimalApproach(int[] arr, int k) {
        //update array to prefix sum of its element
        for (int i=1; i< arr.length; i++){
            arr[i] += arr[i-1];
        }

        int ans = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++){
            int j = 0;
            int l = i, h = arr.length-1;
            while (l<=h){
                int m = (l+h)/2;

                int sum = 0;
                if (i == 0){
                    sum = arr[m];
                }else {
                    sum = arr[m] - arr[i-1];
                }

                if (sum < k){
                    l = m+1;
                }else {
                    int sum1 = 0;
                    if (i == 0){
                        sum1 = arr[m-1];
                    }else {
                        sum1 = arr[m-1] - arr[i-1];
                    }

                    if (sum1 < k){
                        j = m;
                        break;
                    }else {
                        h = m-1;
                    }
                }
            }
            if (! (j-i+1 < 0)) {
                ans = Math.min(ans, j - i + 1);
            }
        }
        System.out.println(ans);
    }

    private static void bruteForce(int[] arr, int k) {
        int sum, ans = Integer.MAX_VALUE;

        //consider all sub array
        for (int i=0; i<arr.length; i++){ // fix i from 0 to N-1
            sum = 0;
            for (int j=i; j<arr.length; j++){ // j also to i to N-1 and calculate sum and update ans
                sum += arr[j];
                if (sum >= k){
                    ans = Math.min(ans, j-i+1);
                }
            }
        }
        System.out.println(ans);
    }
}
