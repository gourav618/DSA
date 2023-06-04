package Searching.Questions;

import java.util.Scanner;

public class KthSmallestNumberInMultiplicationTable {
    //https://dashboard.programmingpathshala.com/practice/question?questionId=118&sectionId=1&moduleId=2&topicId=6&subtopicId=77&homeworkId=16
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while (T-- > 0){
            int m = s.nextInt();
            int n = s.nextInt();
            int k = s.nextInt();
            System.out.println(getKthSmallestNumber(m, n, k));
        }
    }

    private static int getKthSmallestNumber(int m, int n, int k) {
        int l=1, h = m*n;
        while (l<=h){
            int mid = (l+h)/2;
            if (countDivisor(mid, m, n) < k){
                l = mid+1;
            }else {
                if (countDivisor(mid-1, m, n) < k){
                    return mid;
                }else {
                    h = mid-1;
                }
            }
        }
        return 0;
    }

    private static int countDivisor(int x, int m, int n) {
        int ans = 0;
        for (int i=1; i<= Math.min(m,n); i++){
            ans += Math.min(x/i, Math.max(m,n));
        }
        return ans;
    }
}
