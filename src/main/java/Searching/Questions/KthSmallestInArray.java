package Searching.Questions;

import java.util.Scanner;

public class KthSmallestInArray {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=103&sectionId=1&moduleId=2&topicId=6&subtopicId=77&assignmentId=16

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N; i++){
            arr[i] = s.nextInt();
        }
        int K = s.nextInt();
        Pair minMax = findMinMax(arr, N);
        int l=minMax.min, h=minMax.max;
        int ans = -1;
        while (l<=h){
            int mid = (l+h)/2;
            int count = countFunc(arr, mid);
            if (count < K){
                l = mid+1;
            }else {
                int count1 = countFunc(arr, mid - 1);
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

    private static int countFunc(int[] arr, int x) {
        int count =0;
        for (int i=0; i< arr.length; i++){
            if (arr[i] <= x){
                count++;
            }
        }
        return count;
    }

    private static Pair findMinMax(int[] arr, int n) {
        Pair p = new Pair();
        if (n == 1) {
            p.min = arr[0];
            p.max = arr[0];
            return p;
        }

        if (arr[0] > arr[1]){
            p.min = arr[1];
            p.max = arr[0];
        }else {
            p.min = arr[0];
            p.max = arr[1];
        }
        for (int i=2; i<n; i++){
            if (arr[i] > p.max){
                p.max = arr[i];
            } else if (arr[i] < p.min) {
                p.min = arr[i];
            }
        }
        return p;
    }

    static class Pair{
        int min, max;
    }
}
