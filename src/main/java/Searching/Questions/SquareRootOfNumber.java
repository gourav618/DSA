package Searching.Questions;

import java.util.Scanner;

public class SquareRootOfNumber {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=102&sectionId=1&moduleId=2&topicId=6&subtopicId=77&assignmentId=16
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while (T-- > 0){
            long N = s.nextLong();
            System.out.println(findSqrt(N));
        }
    }

    private static long findSqrt(long n) {
        long l=0, h=n;
        while (l<=h){
            long mid = l + (h-l)/2;
            if (mid*mid > n){
                h = mid-1;
            }else {
                if ((mid+1)*(mid+1) > n){
                    return mid;
                }else {
                    l = mid+1;
                }
            }
        }
        return -1;
    }
}
