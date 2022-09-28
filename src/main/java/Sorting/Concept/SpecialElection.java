package Sorting.Concept;

import java.util.Arrays;

public class SpecialElection {
    public static void main(String[] args){
//        Special Election
//        In this lecture, we will discuss a problem based on the concepts that we learnt in the previous two lectures.
//        We are given the influence power(>=0) of N-candidates standing for an election and we have to find out the
//        number of votes each candidate will get based on the following rules:
        //        A person can vote multiple contestants
        //        A person can not vote themselves
        //        A person with influence S[ i ] can vote a person with influence S[ j ] only if -
        //                S[ i ] >= S[i+1] + S[i+2] + … + S[j-1]
        //                S[ i ] >= S[j+1] + S[j+2] + … + S[i-1]
//        Input: S[5] = {1, 2, 2, 3, 1}
//        Output: Ans[5] = {2, 3, 2, 3, 1}
//
//        Approach:
//
//        Brute Force - We can iterate across all the candidates to find how many votes each one of them is getting.
//        For this, we can check the influence power of the candidates at their left and at their right.
//                Time complexity: O(N^2).
        int []S = {1,2,2,3,1};

        bruteForce(5,S);

//        Optimal Approach : Instead of figuring out how many votes each candidate gets, we can try to find who all will
//        be voted by a respective voter.
//        The ability to vote a contestant depends on two factors - voter’s influence power and the sum of
//        influencer power of candidates between the voter and the contestant.
//        Once the sum exceeds a voter’s influence power, they will not be able to vote any contestant further.
//
//        We can observe a pattern in the above diagram and if you remember lecture-10 on the smallest subarray sum,
//        then we can use prefix sum and binary search to figure out the range of contestants a voter can vote.
//        Let this range be [i, j]. We can take the help of the concept learnt in lecture-11 on processing range queries
//        to fill the answer array Arr[ ]. We can then calculate the suffix sum to find out the total number of votes
//        received by each candidate.
//
//        Time complexity: O(Nlog2N)
//        Space complexity: O(N)

        optimalApproach(5, S);
    }

    private static void optimalApproach(int N, int[] s) {
        int [] votes = new int[N];
        //prefix sum
        int []ps = new int[N];
        ps[0] = s[0];
        for (int i=1; i<N; i++){
            ps[i] = ps[i-1] + s[i];
        }
        //suffix sum for left half
        int []ss = new int[N];
        ss[N-1] = s[N-1];
        for (int i=N-2; i>=0; i--){
            ss[i] = ss[i+1] + s[i];
        }

        for (int i=0; i<N; i++){//fix i
            //check right for last jth index i can vote
            int j = binarySearchOnRight(i+1, N-1, s, ps, i);
            votes[i] = votes[i] - 1;
            votes[j] = votes[j] + 1;

            //check left for last kith index i can vote
            int k = binarySearchOnLeft(0, i - 1, s, ss, i);
            if (i != 0){
                votes[i-1] = votes[i-1] + 1;
            }
            if (k != 0){
                votes[k-1] = votes[k-1] - 1;
            }
        }

        //suffix sum votes array to get the final state
        for (int i=N-2; i>=0; i--){
            votes[i] += votes[i+1];
        }

        System.out.println(Arrays.toString(votes));
    }

    private static int binarySearchOnLeft(int l, int h, int[] s, int[] ss, int i) {
        while (l<=h){
            int m = (l+h)/2;
            if (ss[m + 1] - ss[i] <= s[i] && ss[m] - ss[i] > s[i]) {
                return m;
            }else if (ss[m + 1] - s[i] <= s[i]) {
                h = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        return 0;
    }

    private static int binarySearchOnRight(int l, int h, int[] s, int[] ps, int i) {
        while (l<=h){
            int m = (l+h)/2;
            int midSum = ps[m-1] - ps[i];
            if (midSum <= s[i] && ps[m] - ps[i] > s[i]){
                return m;
            }else if (midSum <= s[i]){
                l = m+1;
            }else {
                h = m-1;
            }
        }
        return s.length-1; //last index
    }

    private static void bruteForce(int N, int[] s) {
        int [] votes = new int[N];

        for (int i=0; i< N; i++){ // fix i

            // check right how many can vote this i
            int sumR = 0;
            for (int j=i+1; j<N; j++){
                if (sumR <= s[j]){
                    votes[i]++;
                }
                sumR += s[j];
            }

            // check left how many can vote this i
            int sumL = 0;
            for (int j=i-1 ; j>=0; j--){
                if (sumL <= s[j]){
                    votes[i]++;
                }
                sumL += s[j];
            }
        }
        System.out.println(Arrays.toString(votes));
    }
}
