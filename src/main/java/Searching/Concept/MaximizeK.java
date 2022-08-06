package Searching.Concept;

public class MaximizeK {
    public static void main(String[] args){

//        Maximize K
//        We have been given an unsorted array Arr[N] containing only positive elements and an integer ‘x’ such that x>=0.
//        We have to find the maximum possible ‘k’ such that none of the subarrays of size ‘k’ has a sum>x.
//        Approach:
//
//        Brute Force: We can calculate the sum of all the subarrays of size 1 to N by using the sliding window technique and find the maximum value of ‘k’ following the given criteria.
//        Time complexity: O(N^2)
//        Space complexity: O(1)

        int[] arr = {1,2,3,4};

        //brute force i.e using sliding window technique
        int maxSizeOfSubArray = findMaximumKthValueOfSubArrayUsingSlidingWindowTechnique(arr, 8);
        System.out.println(maxSizeOfSubArray);

//        Binary Search on Answer: Since we know that ‘k’ can vary from 1 to N and beyond a certain value of ‘k’,
//        the subarrays will have sum>x (since the array contains only positive elements). We can find this pivot with the help of binary search and the given condition. Here, low = 1 and high = N.
//        Time complexity: O(NlogN)
//        Space complexity: O(1)
//        Note:
//        - Sliding window technique can be used to effectively calculate the sum of subarrays.
//        - Handle array indices with care
        int maxKthValueUsingBinarySearch = findMaxKthValueUsingBinarySearch(arr, 8);
        System.out.println(maxKthValueUsingBinarySearch);


    }

    private static int findMaxKthValueUsingBinarySearch(int[] arr, int x) {
        int l=0, h=arr.length;
        while (l<=h){
            int m = (l+h)/2;
            boolean r = isPossible(arr, m, x);
            if (!r){
                h = m-1;
            }else {
                boolean r1 = isPossible(arr, m + 1, x);
                if (!r1){
                    return m;
                }else {
                    l = m+1;
                }
            }
        }
        return -1;
    }

    private static boolean isPossible(int[] arr, int m, int x) {
        if (m == arr.length+1){
            return false;
        }
        int sum=0;
        for (int i=0; i<m; i++){//sum of 1st window
            sum += arr[i];
        }
        if (sum > x){
            return false;
        }
        //check sum of other windows
        int s=0, e=m-1;
        while (e < arr.length-1){
            sum -= arr[s];
            s++;
            e++;
            sum += arr[e];
            if (sum > x){
                return false;
            }
        }
        return true;
    }

    private static int findMaximumKthValueOfSubArrayUsingSlidingWindowTechnique(int[] arr, int x) {
        int k=0;
        for (k=1; k<arr.length; k++){
            int sum = 0;
            //get sum for 1st window
            for (int i=0; i<k; i++){
                sum += arr[i];
            }
            if (sum > x){
                break; //sum of 1st window itself is greater than x
            }else {
                //find sum for other windows
                for (int j=k; j< arr.length; j++){
                    sum += arr[j];
                    sum -= arr[j-k];

                    if (sum > x){
                        break;
                    }
                }
            }
        }
        return Math.max(k - 2, 0);
    }
}
