package Searching.Questions;

import java.util.Arrays;
import java.util.Scanner;

public class SmallestDivisorWithSumLessThanThreshold {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=124&sectionId=1&moduleId=2&topicId=6&subtopicId=82&homeworkId=17
        //https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
        Scanner s= new Scanner(System.in);
        long n = s.nextLong();
        s.nextLine();
        long[] arr = Arrays.stream(s.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long threshold = s.nextLong();
        System.out.println(getSmallestDivisor(n, arr, threshold));
    }

    private static long getSmallestDivisor(long n, long[] arr, long threshold) {
        long l=0, h= (long) 10e8;
        while (l<=h){
            long mid = l + (h-l)/2;
            boolean r = isSumOfDivisorLessThanThreshold(arr, n, threshold, mid);
            if (!r){
                l = mid+1;
            }else {
                boolean r1 = isSumOfDivisorLessThanThreshold(arr, n, threshold, mid - 1);
                if (!r1){
                    return mid;
                }else {
                    h = mid-1;
                }
            }
        }
        return -1;
    }

    private static boolean isSumOfDivisorLessThanThreshold(long[] arr, long n, long threshold, long mid) {
        long sum = 0;
        for (int i=0; i<n; i++){
            sum += Math.ceil((arr[i]*1.0)/mid);
        }
        return sum <= threshold;
    }
}
