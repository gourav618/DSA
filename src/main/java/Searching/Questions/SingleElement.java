package Searching.Questions;

import java.util.Scanner;

public class SingleElement {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=101&sectionId=1&moduleId=2&topicId=6&subtopicId=72&assignmentId=15

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N; i++){
            arr[i] = s.nextInt();
        }

        int l=0, h=N-1, ans = -1;
        if (l == h){
            ans = arr[0];
        }else {
            while (l <= h) {
                int mid = (l + h) / 2;
                if (mid == 0) {
                    if (arr[mid + 1] != arr[mid]) {
                        ans = arr[mid];
                        break;
                    } else {
                        l = mid + 1;
                    }
                } else if (mid == N - 1) {
                    if (arr[mid - 1] != arr[mid]) {
                        ans = arr[mid];
                        break;
                    } else {
                        h = mid - 1;
                    }
                } else if (arr[mid - 1] != arr[mid] && arr[mid + 1] != arr[mid]) {
                    ans = arr[mid];
                    break;
                } else {
                    int fo;
                    if (arr[mid] == arr[mid+1]){
                        fo = mid;
                    }else {
                        fo = mid-1;
                    }

                    if (fo % 2 == 0){
                        l = mid+1;
                    }else {
                        h = mid-1;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
