package Sorting.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class UnsortedSubarray {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=139&sectionId=1&moduleId=2&topicId=7&subtopicId=94&assignmentId=21

        //1st approach
//        1. Make vector of pairs {value, index}
//        2. Sort this vector
//        3. Run loop from start and find first occurrence where p[i].second != i. This will be s
//        4. Run loop from end and do the same to get e.

        //above approach not linear its O(NlogN),below is linear approach O(N)
        //Iterate from the beginning of the array and find the last element which is smaller than the last seen max
        // from its left side and mark it as the end
        //Similarly, iterate from the end of array find the last element which is bigger than the last seen min
        // from its right side and mark it as begin

        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(s.readLine());

        while (t-- > 0){
            int n = Integer.parseInt(s.readLine());
            Integer[] arr = Arrays.stream(s.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            int[] subArray = getUnsortedSubArray(arr, n);
            System.out.println(subArray[0]+" "+subArray[1]);
        }
    }

    private static int[] getUnsortedSubArray(Integer[] arr, int n) {
        int lastMax = Integer.MIN_VALUE, minThanLastMax = -1;
        for (int i=0; i<n; i++){
            if (arr[i] < lastMax){
                minThanLastMax = i;
            }
            lastMax = Math.max(lastMax, arr[i]);
        }
        int lastMin = Integer.MAX_VALUE, maxThanLastMin = -1;
        for (int i=n-1; i>=0; i--){
            if (arr[i] > lastMin){
                maxThanLastMin = i;
            }
            lastMin = Math.min(lastMin, arr[i]);
        }
        int[] range = new int[2];
        range[0] = maxThanLastMin == -1 ? 0 : maxThanLastMin;
        range[1] = minThanLastMax == -1 ? 0 : minThanLastMax;
        return range;
    }
}
