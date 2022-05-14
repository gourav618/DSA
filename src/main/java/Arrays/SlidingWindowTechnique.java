package Arrays;

// given : int arr[N], int k
//output : print sum of every subarray of size k
//ex: [1 2 -1 0 4] k=3
// subarray of size 3 --> {1 2 -1} = 2 {2 -1 0} = 1 {-1 0 4} = 3 \\ o/p : 2 1 3
// find the no of subarray in the array
// consider array with index [0 1 2 3......N-k....N-1] the 1st subarray start from 0 to k-1 ,1 to k-1 and so on
// until there is a point N-K to N-1 since after this we wont have k element in subarray
// so total subarray is from 0 to N-k i.e (N-K+1) sub arrays
// ex in above case N=5 , k=3 (5-3+1) = 3 ,i.e the same no of subarray we have above

// In brute force we find all this subarray and sum each of this array individually i.e  o((N-k+1) * k) no of subarray * sum of elem in subarray
// for k = N/2 -> o(N/2 * N/2) ~ o(N^2) using brute force

public class SlidingWindowTechnique {
    // in sliding window technique
    //ex : a0 a1 a2 a3 a4 a5 a6 ... and k=3 the first window is a0 a1 a2 and 2nd window is a1 a2 a3
    // if you notice the diff btw 1st and 2nd window is 1 elem from 1st window is taken out i.e first and new elem added in 2nd window at last
    // ans if sum of 1st window is s then for 2nd window its s - a0 + a3 ...and so on
    // and this can be done for all the remaining window i.e N-k since total window is N-k+1
    //only for 1st window we take o(k) and for remaining windows(N-k) we take only o(1) each i.e o(N-k) i.e o(k) + o(N-K) = o(N) time
    public static void main(String [] args){
        int arr[] = {1,2,-1,0,4}, k=3;

        // o(N^2) time
        printSumOfSubarrayByBruteForce(arr, k);

        // o(N) time and o(1) space
        printSumOfSubArrayUsingSlidingTech(arr, k);

        // given: int Arr[N], int k -size of window, int x , print frequency(x) in every window size k
        //can be solve using sliding window technique in o(N) time
        int arr1[] = {2,2,1,2,4,6,2}, k1=4, x = 2;
        printFrequencyOfXUsingSlidingWindow(arr1, k1, x);
    }

    private static void printFrequencyOfXUsingSlidingWindow(int[] arr1, int k1, int x) {
        int freq = 0;
        //calculate freq in 1st window
        for (int i=0;i<k1;i++){
            if (arr1[i] == x) {
                freq++;
            }
        }

        //calculate freq for all others window
        for (int j = k1; j< arr1.length; j++){
            System.out.print(freq + " ");
            if (arr1[j] == x){
                freq++;
            }
            if (arr1[j-k1] == x){
                freq--;
            }
        }
        System.out.println(freq);
    }

    private static void printSumOfSubarrayByBruteForce(int[] arr, int k) {

        for (int i = 0; i<= arr.length-k; i++){
            int sum = 0;
            int count = 0;
            int j = i;
            while (count < 3) {
                sum += arr[j];
                j++;
                count++;
            }
            System.out.print(sum + " ");
        }
        System.out.println();
    }

    private static void printSumOfSubArrayUsingSlidingTech(int[] arr, int k) {
        int sum = 0;
        //calculate sum for 1st window
        for (int i=0; i < k; i++){
            sum += arr[i];
        }

        //calculate sum for all others window using sliding technique
        for (int j=k; j< arr.length; j++){
            System.out.print(sum + " ");
            sum += arr[j]; // add elem added to 2nd window
            sum -= arr[j-k]; // subtract elem from 1st window removed
        }
        //print for last subarray
        System.out.println(sum);
    }
}
