package Mathematics.Concept;

import java.util.Arrays;
import java.util.stream.LongStream;

public class CountingTriplets {
    public static void main(String[] args){
//        We have been given an integer array 'Arr[N]' and an integer ‘m’. We have to find the count of triplets (i, j, k)
//        such that (Arr[i]+Arr[j]+Arr[k]) is divisible by ‘m’ where Arr[i]>=0.
//        Note: All permutations of the triplet (i, j, k) have been considered as the same
//        Approach:
//        Brute Force - Consider all the triplets of Arr[N] & count ones whose sum is divisible by ‘k’.
//        Time complexity: O(N^3)
//        Space complexity: O(1)
        int arr[] = {1,2,3,4,5,6,7};
        getCountOfTripletsByBruteForce(arr, 8);

//        Using the property of modulus - The remainder of the sum is equal to the sum of remainders.
//        (ai+aj+ak)%m = ((ai+aj)%m+ak%m)%m = ((ai%m+aj%m)%m+ak%m)%m
//        If ai%m=ri, aj%m=rj & ak%m=rk
//        i.e. ((ri+rj)%m+rk)%m where, 0<=ri,rj,rk<=k-1
//
//        The above equation will be zero when:
//        If (ri+rj)%m = 0 then rk = 0
//        If (ri+rj)%m = x then rk = k - x
//
//        So we can iterate for the first two remainders which will automatically fix the third one. And by using the rule of
//        combinatorics & the rule of products we can easily calculate the answer.
//        Time complexity: O(N+m^2)
//        Space complexity: O(m)
//
//        Note: The second approach is better than the first approach only when N>M. Eg. N=100 & m = 100. If it is the opposite,
//        then using the first approach is a better idea.
        getCountOfTripletsByModularArithmetic(arr, 8);
    }

    private static void getCountOfTripletsByModularArithmetic(int[] arr, int m) {
        //store remainder of arr in count arr
        int count[] = new int[m];
        Arrays.fill(count, 0);
        //update count array
        for (int i=0; i< arr.length; i++){
            count[arr[i]%m]++;
        }

        //get the count of triplet
        int ans = 0;
        for (int i=0; i<m; i++){
            for (int j=i; j<m; j++) { // fix 2 point i and j and calculate k
                int k;
                if ((i + j) % m == 0) {
                    k = 0;
                }
                else {
                    k = m - ((i + j) % m);
                }
                //permutation of i,j,k already considered
                if (k<j) {
                    continue;
                }
                //now we have i,j,k where i<=j<=k update ans
                if (i==j && j==k){ // all 3 item picked from single bucket
                    ans += (count[i]*(count[i]-1)*(count[i]-2))/6;
                }
                // 2 item picket from single bucket
                else if (i==j){
                    ans += ((count[i] * (count[i]-1))/2) * count[k];
                }
                else if (i==k){
                    ans += ((count[i] * (count[i]-1))/2) * count[j];
                }
                else if (j==k){
                    ans += ((count[j] * (count[j]-1))/2) * count[i];
                }
                else {// all item picket from diff bucket
                    ans += count[i]*count[j]*count[k];
                }
            }
        }
        System.out.println(ans);
    }


    private static void getCountOfTripletsByBruteForce(int[] arr, int m) {
        int count=0;
        for (int i=0; i< arr.length; i++){
            for (int j=i+1; j< arr.length; j++){
                for (int k=j+1; k< arr.length; k++){
                    if ((arr[i]+arr[j]+arr[k]) % m == 0){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
