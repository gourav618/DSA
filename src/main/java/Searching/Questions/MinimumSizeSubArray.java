package Searching.Questions;

import java.util.Scanner;

public class MinimumSizeSubArray {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=121&sectionId=1&moduleId=2&topicId=6&subtopicId=82&homeworkId=17

        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long[] arr = new long[(int) n];
        for (int i=0; i<n; i++){
            arr[i] = s.nextLong();
        }
        long T = s.nextLong();
        while (T-- > 0){
            long target = s.nextLong();
            System.out.println(findMinimumSizeSubArray(arr, n, target));
        }
    }

    private static long findMinimumSizeSubArray(long[] arr, long n, long target) {
        long l=0, h=n;
        while (l<=h){
            long mid = (l+h)/2;
            boolean r = isPossible(arr, n, target, mid);
            if (!r){
                l = mid+1;
            }else {
                boolean r1 = isPossible(arr, n, target, mid - 1);
                if (!r1){
                    return mid;
                }else {
                    h = mid-1;
                }
            }
        }
        return 0L;
    }

    private static boolean isPossible(long[] arr, long n, long target, long mid) {
        if (mid == n+1){
            return false;
        }
        int sum = 0;
        for (int i=0; i<mid; i++){
            sum += arr[i];
        }
        if (sum >= target) return true;
        int s=0, e= (int) (mid-1);
        while (e<n-1){
            sum -= arr[s];
            s++;
            e++;
            sum += arr[e];
            if (sum >= target) return true;
        }
        return false;
    }
}
