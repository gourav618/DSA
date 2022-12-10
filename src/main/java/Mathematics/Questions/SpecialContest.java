package Mathematics.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SpecialContest {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=29&sectionId=1&moduleId=1&topicId=2&subtopicId=19&assignmentId=4

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();

        for (int i=0; i<T; i++){
            List<Long> input = Arrays.stream(s.nextLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());

            System.out.println(findWinOrLose(input.get(0), input.get(1), input.get(2), input.get(3)) ? "Win" : "Lose");
        }
    }

    private static boolean findWinOrLose(Long N, Long A, Long B, Long K) {

        long l = (N / A) + (N / B) - 2*(N / getLcm(A, B));

        return l >= K;
    }

    private static Long getLcm(Long a, Long b) {
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
