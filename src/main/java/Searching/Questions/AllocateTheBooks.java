package Searching.Questions;

import java.util.Scanner;

public class AllocateTheBooks {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=106&sectionId=1&moduleId=2&topicId=6&subtopicId=82&assignmentId=17
        //https://www.geeksforgeeks.org/allocate-minimum-number-pages/

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = s.nextInt();
        }
        int m = s.nextInt();

        int l = Integer.MIN_VALUE, h = 0;
        for (int i=0; i<n; i++){
            l = Math.max(arr[i], l);
            h += arr[i];
        }
        while (l<=h){
            int mid = l+(h-l)/2;
            boolean r = isAllocationPossible(arr, mid, m, n);
            if (!r){
                l = mid+1;
            }else {
                boolean r1 = isAllocationPossible(arr, mid - 1, m, n);
                if (!r1){
                    System.out.println(mid);
                    break;
                }else {
                    h = mid-1;
                }
            }
        }

    }

    private static boolean isAllocationPossible(int[] arr, int mid, int m, int n) {
        int count=1, sum=0;
        for (int i=0;i<n; i++){
            if(arr[i] > mid){
                return false;
            }
            else if (sum+arr[i] > mid){
                count++;
                sum = arr[i];
            }else {
                sum += arr[i];
            }
        }
        return count<=m;
    }
}
