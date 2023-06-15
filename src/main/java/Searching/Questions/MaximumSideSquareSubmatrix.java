package Searching.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumSideSquareSubmatrix {
    public static void main(String [] args) throws IOException {
        //https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
        //https://dashboard.programmingpathshala.com/practice/question?questionId=123&sectionId=1&moduleId=2&topicId=6&subtopicId=82&homeworkId=17
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        Integer[] dimensions = Arrays.stream(s.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int m = dimensions[0], n = dimensions[1];
        long[][] arr = new long[m][n];
        for (int i=0; i<m; i++){
            arr[i] = Arrays.stream(s.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }
        //prefix sum row wise
        for (int i=0; i<m; i++){
            for (int j=1; j<n; j++){
                arr[i][j] += arr[i][j-1];
            }
        }
        //prefix sum column wise
        for (int i=1;i<m; i++){
            for (int j=0; j<n; j++){
                arr[i][j] += arr[i-1][j];
            }
        }
        int T = Integer.parseInt(s.readLine());
        while (T-- > 0){
            long threshold = Long.parseLong(s.readLine());
            System.out.println(findMaximumSideSquareSubMatrix(arr, m, n, threshold));
        }
    }

    private static int findMaximumSideSquareSubMatrix(long[][] arr, int m, int n, long threshold) {
        int l=1, h = Math.min(m, n);
        while (l<=h){
            int mid = (l+h)/2;
            boolean r = checkIfSideSquarePossible(arr, m, n, threshold, mid);
            if (!r){
                h = mid-1;
            }else {
                boolean r1 = checkIfSideSquarePossible(arr, m, n, threshold, mid + 1);
                if (!r1){
                    return mid;
                }else {
                    l = mid+1;
                }
            }
        }
        return 0;
    }

    private static boolean checkIfSideSquarePossible(long[][] arr, int m, int n, long threshold, int mid) {
        long sum=0;
        for (int i=mid-1; i<m; i++){
            for (int j=mid-1; j<n; j++){
                sum = arr[i][j] + ((i-mid>=0 && j-mid>=0)?arr[i-mid][j-mid]:0) - ((j-mid>=0)?arr[i][j-mid]:0) - ((i-mid>=0)?arr[i-mid][j]:0);
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
