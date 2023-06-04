package Searching.Questions;

import java.util.Arrays;
import java.util.Scanner;

public class KthSmallestPairDistance {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=119&sectionId=1&moduleId=2&topicId=6&subtopicId=77&homeworkId=16

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N; i++){
            arr[i] = s.nextInt();
        }
        long k = s.nextLong();
        Arrays.sort(arr);

        int l=Integer.MAX_VALUE, h = arr[N-1] - arr[0];
        //find lowest
        for (int i=1; i<N; i += 2){
            l = Math.min(l, arr[i] - arr[i-1]);
        }
        while (l<h){
            int mid = (l+h)/2;
            long count = countPairsWithSum(arr, mid, N);
            if (count < k){
                l = mid+1;
            }else {
                h = mid;
            }
        }
        System.out.println(l);
    }

    private static long countPairsWithSum(int[] arr, int x, int n) {
        long count = 0;
        int lp=0;
        for (int hp=1; hp<n; hp++){
            while(arr[hp]-arr[lp] > x) lp++;
            count += hp-lp;
        }
        return count;
    }
}
