package Sorting.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SpecialElectionMinionsAndVoting {
    public static void main(String[] args) throws IOException {
        //https://www.codechef.com/MARCH18B/problems/MINVOTE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            Long[] influences = Arrays.stream(br.readLine().split(" ")).map(Long::parseLong).toArray(Long[]::new);
            long[] votesForEachMinions = getVotesForEachMinions(influences, n);
            for (int i=0; i<n; i++){
                System.out.print(votesForEachMinions[i]+" ");
            }
            System.out.println();
        }
    }

    private static long[] getVotesForEachMinions(Long[] arr, int n) {
        long[] votes = new long[n];
        //prefix sum for right half
        Long[] ps = new Long[n];
        ps[0] = arr[0];
        for (int i=1; i<n; i++){
            ps[i] = ps[i-1] + arr[i];
        }
        //suffix sum for left half
        Long[] ss = new Long[n];
        ss[n-1] = arr[n-1];
        for (int i=n-2; i>=0; i--){
            ss[i] = ss[i+1] + arr[i];
        }

        //for each i we find the number of votes he can do -> fix i
        for (int i=0; i<n; i++){
            //check right for last index i can vote
            int j = binarySearchOnRight(i+1, n-1, arr, ps, i);
            votes[i] -= 1;
            votes[j] += 1;

            //check left for last kith index i can vote
            int k = binarySearchOnLeft(0, i - 1, arr, ss, i);
            if (i != 0){
                votes[i-1] += 1;
            }
            if (k != 0){
                votes[k-1] -= 1;
            }
        }
        //suffix sum votes array to get the final state
        for (int i=n-2; i>=0; i--){
            votes[i] += votes[i+1];
        }
        return votes;
    }

    private static int binarySearchOnRight(int l, int h, Long[] arr, Long[] ps, int i) {
        while (l<=h){
            long mid = l + (h-l)/2;
            long midSum = ps[(int) (mid-1)] - ps[i];
            if (midSum <= arr[i] && ps[(int) mid] - ps[i] > arr[i]){
                return (int) mid;
            }else if (midSum <= arr[i]){
                l = (int) (mid+1);
            }else {
                h = (int) (mid-1);
            }
        }
        return arr.length-1;
    }

    private static int binarySearchOnLeft(int l, int h, Long[] arr, Long[] ss, int i) {
        while (l<=h){
            long mid = l + (h-l)/2;
            long midSum = ss[(int) (mid+1)] - ss[i];
            if (midSum <= arr[i] && ss[(int) mid] - ss[i] > arr[i]){
                return (int) mid;
            }else if (midSum <= arr[i]){
                h = (int) (mid-1);
            }else {
                l = (int) (mid+1);
            }
        }
        return 0;
    }
}
