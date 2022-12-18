package Mathematics.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HardestProblemEver {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=28&sectionId=1&moduleId=1&topicId=2&subtopicId=19&homeworkId=4

        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        s.nextLine();

        for (int i=0; i<T; i++){
            int N = s.nextInt();
            s.nextLine();
            List<Long> arr = Arrays.stream(s.nextLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());
            long l = gcdOfWholeArray(arr);
            if (l == 1){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }
    }

    private static long gcdOfWholeArray(List<Long> arr) {
        long gcd = getGcd(arr.get(0), arr.get(1));
        for (int i=2; i< arr.size(); i++){
            gcd = getGcd(gcd, arr.get(i));
        }
        return gcd;
    }

    private static long getGcd(Long a, Long b) {
        long min = Math.min(a, b);
        long max = Math.max(a, b);

        if (min == 0){
            return min;
        }

        while (max%min != 0){
            long temp = max;
            max = min;
            min = temp%min;
        }
        return min;
    }
}
