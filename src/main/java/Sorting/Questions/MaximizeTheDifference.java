package Sorting.Questions;

import java.util.Arrays;
import java.util.Scanner;

public class MaximizeTheDifference {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=134&sectionId=1&moduleId=2&topicId=7&subtopicId=90&assignmentId=20

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        s.nextLine();
        while (t-- > 0){
            int n = s.nextInt();
            int k = s.nextInt();
            k = Math.min(k, n-k);
            int [] arr = new int[n];
            int sum = 0;
            for (int i=0; i<n; i++){
                int item = s.nextInt();
                arr[i] = item;
                sum += item;
            }
            s.nextLine();
            Arrays.sort(arr);
            int weightForK = 0;
            for (int i=0; i<k; i++){
                weightForK += arr[i];
            }
            System.out.println(sum-(2*weightForK));
        }
    }
}
