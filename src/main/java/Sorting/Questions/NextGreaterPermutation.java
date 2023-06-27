package Sorting.Questions;

import java.util.Arrays;
import java.util.Scanner;

public class NextGreaterPermutation {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=137&sectionId=1&moduleId=2&topicId=7&subtopicId=90&assignmentId=20

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while (t-- > 0){
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i=0; i<n; i++){
                arr[i] = s.nextInt();
            }
            findNextGreaterPermutation(arr, n);

            for (int i : arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    private static void findNextGreaterPermutation(int[] arr, int n) {

        int x = n-1;
        while (x > 0 && arr[x] <= arr[x-1]){
            x--;
        }

        if (x-1 >= 0){
            for (int y=n-1; y >= x; y--){
                if (arr[y] > arr[x-1]){
                    swap(arr, y, x-1);
                    break;
                }
            }
            int i=x, j=n-1;
            while (i<j){
                swap(arr, j, i);
                i++;j--;
            }
        }else {
            Arrays.sort(arr);
        }
    }

    private static void swap(int[] arr, int y, int x) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
