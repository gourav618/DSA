package Mathematics.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindGcdAndLcm {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=27&sectionId=1&moduleId=1&topicId=2&subtopicId=19&assignmentId=4

        Scanner s = new Scanner(System.in);
        List<Long> aB = Arrays.stream(s.nextLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());

        long gcd = getGcd(aB.get(0), aB.get(1));
        long lcm = getLcm(aB.get(0), aB.get(1));

        System.out.println(gcd+" "+lcm);
    }

    private static long getLcm(Long a, Long b) {
        return (a*b)/getGcd(a, b);
    }

    private static long getGcd(Long a, Long b) {
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
