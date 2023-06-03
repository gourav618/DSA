package Searching.Questions;

import java.util.Scanner;

public class NthMagicalNumber {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=116&sectionId=1&moduleId=2&topicId=6&subtopicId=77&homeworkId=16
        //refer - https://www.geeksforgeeks.org/n-th-multiple-sorted-list-multiples-two-numbers/

//        1) Get gcd (greatest common divisor) and lcm (least common multiple) of (A, B).
//        (a, b) = (A, B) while b > 0: (a, b) = (b, a % b)
//        then, gcd = a and lcm = A * B / a
//
//        2) How many magic numbers <= x ?
//                By inclusion exclusion principle, we have:
//        x / A + x / B - x / lcm
//
//        3) Set our binary search range
//        Lower bound is min(A, B), I just set left = 2.
//        Upper bound is N * min(A, B), I just set right = 10 ^ 14.
//
//        4) binary search, find the smallest x that x / A + x / B - x / lcm = N

//        The condition to be used here is finding how many magical numbers are less than mid, if the value of count < n,
//        move the left pointer, otherwise move the right pointer.
//
//        Now, the problem is how to find the number of magical numbers less than any number x: The value would be
//        na (numbers div by a and the value would be x/a) + nb (numbers div by b ane value would be x/b) also the numbers
//        div by both a and b are counted twice so, total = x/a + x/b - x/lcm(a, b)
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while (T-- > 0){
            long n = s.nextLong();
            long a = s.nextLong();
            long b = s.nextLong();
            System.out.println(getNthMagicalNUmber(n, a, b));
        }
    }

    private static long getNthMagicalNUmber(long n, long a, long b) {
        long mod = 1000000007;
        long l = Math.min(a, b);
        long h = n * l;
        while (l<=h){
            long mid = l + (h-l)/2;
            long magicalNumber = (mid / a) + (mid / b) - (mid / lcm(a, b));
            if (magicalNumber < n){
                l = mid+1;
            } else if (magicalNumber > n) {
                h = mid-1;
            }else {
                if (((mid-1) / a) + ((mid-1) / b) - ((mid-1) / lcm(a, b)) == n){
                    h = mid-1;
                }else {
                    return mid % mod;
                }
            }
        }
        return 0;
    }

    private static long lcm(long a, long b) {
        return (a*b)/gcd(a,b);
    }

    private static long gcd(long a, long b) {
        long max = Math.max(a, b);
        long min = Math.min(a, b);
        if (min == 0){
            return max;
        }
        while (max%min > 0){
            long temp = max;
            max = min;
            min = temp%min;
        }
        return min;
    }
}
