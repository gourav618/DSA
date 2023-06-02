package Searching.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthSmallestInMatrix {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/practice/question?questionId=104&sectionId=1&moduleId=2&topicId=6&subtopicId=77&assignmentId=16

        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(s.readLine());
        int[][] mat = new int[N][N];
        for (int i=0; i<N; i++){
            String[] s1 = s.readLine().split(" ");
            for (int j=0; j<N; j++){
                mat[i][j] = Integer.parseInt(s1[j]);
            }
        }
        int K = Integer.parseInt(s.readLine());
        int l = mat[0][0], h = mat[N-1][N-1];
        int ans = -1;
        while (l<=h){
            int mid = (l+h)/2;
            int count = countFunc(mat, mid, N);
            if (count < K){
                l = mid+1;
            }else {
                int count1 = countFunc(mat, mid - 1, N);
                if (count1 < K){
                    ans = mid;
                    break;
                }else {
                    h = mid-1;
                }
            }
        }
        System.out.println(ans);
    }

    private static int countFunc(int[][] mat, int x, int n) {
        int count = 0;
        for (int i=0; i<n; i++){
            count += search(mat[i], x, n);
        }
        return count;
    }

    private static int search(int[] arr, int x, int n) {
        int l=0, h= n-1;
        while (l<=h){
            int mid = (l+h)/2;
            if (arr[mid] <= x){
                l = mid+1;
            }else {
                if (mid == 0){
                    return mid;
                }
                else if (arr[mid-1] < x){
                    return mid;
                }else {
                    h = mid-1;
                }
            }
        }
        return l;
    }
}
