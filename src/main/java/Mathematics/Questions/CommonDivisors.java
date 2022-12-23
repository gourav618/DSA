package Mathematics.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CommonDivisors {
    //https://dashboard.programmingpathshala.com/practice/question?questionId=41&sectionId=1&moduleId=1&topicId=2&subtopicId=25&homeworkId=5

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        s.nextLine();
        while (t-- > 0){
            List<Long> num = Arrays.stream(s.nextLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());

            long gcd = getGcd(num.get(0), num.get(1));

            int count = 0;
            for (int i=1; i<=Math.sqrt(gcd); i++){
                if (gcd%i == 0){
                    if (i*i == gcd){
                        count++;
                    }else {
                        count += 2;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static long getGcd(Long a, Long b) {
        long min = Math.min(a, b);
        long max = Math.max(a,b);
        //Note: if both no is 0 then we cannot identify gcd since 0%0 is infinity
        // if any 1 no is 0 then gcd of something with 0 will be a non-zero element
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
