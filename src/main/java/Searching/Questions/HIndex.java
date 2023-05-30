package Searching.Questions;

import java.util.Scanner;

public class HIndex {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=113&sectionId=1&moduleId=2&topicId=6&subtopicId=72&homeworkId=15

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] citations = new int[N];
        for (int i=0; i<N; i++){
            citations[i] = s.nextInt();
        }

        int ans = 0;
        if (N == 1){
            if (citations[0] == 1){
                ans = 1;
            }else {
                ans = 0;
            }
        }else {
            int l = 0, h = N - 1;
            while (l<=h){
                int mid = (l+h)/2;
                if (citations[mid] >= (N-mid)){
                    ans = Math.max(ans, N-mid);
                    h = mid-1;
                }else {
                    l = mid+1;
                }
            }
        }
        System.out.println(ans);
    }
}
