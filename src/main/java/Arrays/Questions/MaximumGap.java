package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaximumGap {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=19&sectionId=1&moduleId=1&topicId=1&subtopicId=14&assignmentId=3

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();
        for (int i=0; i<T; i++){
            int N = s.nextInt();
            s.nextLine();
            List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            System.out.println(findMaxConsecutiveDiff(arr, N));
        }
    }

    private static int findMaxConsecutiveDiff(List<Integer> arr, int n) {
        //if arr is having less than 2 elements
        if (n < 2){
            return 0;
        }

        //find max and min elem in arr
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            max = Math.max(max, arr.get(i));
            min = Math.min(min, arr.get(i));
        }

        //find gap: edge case when elem are equal and gap == 0
        if (min == max){
            return 0;
        }

        int gap = (int) Math.ceil((double)(max - min) / (n-1));

        int[] minArr = new int[n];
        int[] maxArr = new int[n];
        //init with min and max value
        for (int i=0; i<n; i++){
            minArr[i] = Integer.MAX_VALUE;
            maxArr[i] = Integer.MIN_VALUE;
        }

        //update min and max of that bucket
        for (int i=0; i<n; i++){
            //get bucket no for arr[i]
            int bkt = (arr.get(i) - min)/gap;
            minArr[bkt] = Math.min(minArr[bkt], arr.get(i));
            maxArr[bkt] = Math.max(maxArr[bkt], arr.get(i));
        }

        int ans = Integer.MIN_VALUE, prev = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            if (minArr[i] == Integer.MAX_VALUE){//if no elem in bucket
                continue;
            }
            if (prev == Integer.MIN_VALUE){ // first bucket found and update the prev to get max of current bucket
                prev = maxArr[i];
            }
            else {
                ans = Math.max(ans, minArr[i]- prev);
                prev = maxArr[i];
            }
        }
        return ans;
    }
}
