package Mathematics.Questions;

import java.util.Scanner;

public class NthUglyNumber {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=117&sectionId=1&moduleId=2&topicId=6&subtopicId=77&homeworkId=16

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while (T-- > 0){
            long n = s.nextInt();
            long a = s.nextLong();
            long b = s.nextLong();
            long c = s.nextLong();
            System.out.println(getNthUglyNumber(n, a, b, c));
        }
    }

    private static long getNthUglyNumber(long n, long a, long b, long c) {
        long l = Math.min(Math.min(a, b), c);
        long h = n*l;
        while (l<=h){
            long mid = l + (h-l)/2;
            long uglyNumber = (mid/a) + (mid/b) + (mid/c) - (mid/lcm(a, b)) - (mid/lcm(a, c)) - (mid/lcm(b, c)) + (mid/lcm(a,b,c));
            if (uglyNumber < n){
                l = mid+1;
            } else if (uglyNumber > n) {
                h = mid-1;
            }else {
                if (((mid-1)/a) + ((mid-1)/b) + ((mid-1)/c) - ((mid-1)/lcm(a, b)) - ((mid-1)/lcm(a, c)) - ((mid-1)/lcm(b, c)) + ((mid-1)/lcm(a,b,c)) == n){
                    h = mid-1;
                }else {
                    return mid;
                }
            }
        }
        return 0;
    }

    private static long lcm(long a, long b){
        return (a * b) / gcd(a , b);
    }

    private static long lcm(long a, long b, long c) {
        long lcmAb = (a * b) / gcd(a, b);
        return (lcmAb * c) / gcd(lcmAb, c);
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
