package Searching.Questions;

import java.io.IOException;
import java.util.Scanner;

public class IndexOfExtraElement {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/practice/question?questionId=112&sectionId=1&moduleId=2&topicId=6&subtopicId=72&homeworkId=15

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] arr1 = new int[N];
        int[] arr2 = new int[N-1];

        for (int i=0; i<N; i++){
            arr1[i] = s.nextInt();
        }
        for (int i=0; i<N-1; i++){
            arr2[i] = s.nextInt();
        }

        int l=0, h=N-1, ans = -1;
        while (l<=h){
            int mid = (l+h)/2;

            if (mid == N-1){
                ans = mid;
                break;
            }
            else if (mid == 0 && arr1[mid] != arr2[mid]) {
                ans = mid;
                break;
            } else if (arr1[mid] != arr2[mid] && arr1[mid - 1] == arr2[mid-1]) {
                ans = mid;
                break;
            }
            else if (arr1[mid] == arr2[mid]){
                l = mid+1;
            }
            else {
                h = mid-1;
            }
        }
        System.out.println(ans);
    }
}
