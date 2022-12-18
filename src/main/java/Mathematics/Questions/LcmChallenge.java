package Mathematics.Questions;

import java.util.Scanner;

public class LcmChallenge {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=36&sectionId=1&moduleId=1&topicId=2&subtopicId=19&homeworkId=4

        //Since the task is to maximize the LCM, so if all three numbers don’t have any common
        // factor then the LCM will be the product of those three numbers and that will be maximum.

        //If n is odd then the answer will be n, n-1, n-2.
        //If n is even,
            //If gcd of n and n-3 is 1 then answer will be n, n-1, n-3.
            //Otherwise, n-1, n-2, n-3 will be required answer.

        Scanner s = new Scanner(System.in);
        long N = s.nextLong();

        long maxLcm = 0;
        if (N%2 != 0){
            maxLcm = N *(N-1)*(N-2);
        }else {
            long gcd = getGcd(N, N - 3);
            if (gcd == 1)
                maxLcm = N *(N-1)*(N-3);
            else
                maxLcm = (N-1)*(N-2)*(N-3);
        }
        System.out.println(maxLcm);
    }

    private static long getGcd(long a, long b) {
        long max = Math.max(a, b);
        long min = Math.min(a, b);

        if (min == 0){
            return max;
        }

        while (max%min != 0){
            long temp = max;
            max = min;
            min = temp%min;
        }
        return min;
    }
}
