package Searching.Questions;

import java.util.Scanner;

public class MinimumSizeSubArray {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=121&sectionId=1&moduleId=2&topicId=6&subtopicId=82&homeworkId=17

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = s.nextInt();
        }
        int T = s.nextInt();
        while (T-- > 0){
            int target = s.nextInt();
            System.out.println(findMinimumSizeSubArray(arr, n, target));
        }
    }

    private static int findMinimumSizeSubArray(int[] arr, int n, int target) {
        int l=0, h=n;
        while (l<=h){
            int mid = (l+h)/2;
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
        return 0;
    }

    private static boolean isPossible(int[] arr, int n, int target, int mid) {
        if (mid == n+1){
            return false;
        }
        int sum = 0;
        for (int i=0; i<mid; i++){
            sum += arr[i];
        }
        if (sum >= target) return true;
        int s=0, e=mid-1;
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
