package Mathematics.Concept;

import java.util.Arrays;

public class CountingPairs {
    public static void main(String []args){
//        Here we have been given an integer array 'Arr[N]' and an integer ‘k’.
//        We have to find the total number of pairs (i, j) such that (Arr[i]+Arr[j]) is divisible by ‘k’
//        where i≠j, Arr[i]>=0.
//        Note: Both (i,j) and (j,i) are counted as the same

//        Brute Force - Consider all the possible pairs of the array & count ones whose sum is divisible by ‘k’.
//        Time complexity: O(N^2)
//        Space complexity: O(1)
          int arr[] = {2,2,1,7,5,3};
          getCountOfPairsByBruteForce(arr, 4);

//        Using the property of Modulus - The remainder of the sum is equal to the sum of remainders.
//        (ai+aj)%k = (ai%k+aj%k)%k
//        If ai%k = r1 & aj%k = r2
//        then, (ai+aj)%k = (r1+r2)%k where 0<=r1,r2<=k-1
//        The above equation will yield zero if,
//        r1 + r2 = 0
//        It is possible when: r1 = 0 & r2 = 0
//        r1 + r2 = k
//        It is possible when: r1 = i & r2 = k-i where 1<=i<=k-1
//        We can create an array cnt[k] to store the frequency of remainders from 0 to k-1.
//        By the rule of products and the rule of combinatorics, the answer will be given as -
        //if k is odd ans = cnt[0]C2 + i={1 to k/2-1} cnt[i]*cnt[k-i]
        //if k is even ans = cnt[0]C2 + i={1 to k/2-1} cnt[i]*cnt[k-i] + cnt[k/2]C2
        getCountOfPairsByModulusProperty(arr, 4);

    }

    private static void getCountOfPairsByModulusProperty(int[] arr, int k) {
        int count[] = new int[k];
        Arrays.fill(count, 0);

        //update count array with rem
        for (int i=0; i< arr.length; i++){
            count[arr[i]%k]++;
        }
        int ans = (count[0] * (count[0]-1))/2; // handle for bucket with rem =0
        for (int i=1; i<=(k/2-1); i++){ // handle for non zero
            ans += count[i] * count[k-i];
        }
        if (k%2 == 0){ // if k is even we have 1 mid bucket
            ans += (count[k/2] * (count[k/2]-1))/2;
        }else { // else we have 2
            ans += count[k/2]*count[k/2 + 1];
        }
        System.out.println(ans);
    }

    private static void getCountOfPairsByBruteForce(int[] arr, int k) {
        int count = 0;
        for (int i=0; i<arr.length; i++){
            for (int j=i+1; j< arr.length; j++){
                if ( (arr[i]+arr[j]) % k == 0 ){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
