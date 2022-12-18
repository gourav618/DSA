package Mathematics.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FourDivisors {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=35&sectionId=1&moduleId=1&topicId=2&subtopicId=19&homeworkId=4
//        1. checking only for non perfect sq
//        2. counting the factors of non perfect sq
//        3. if it exceed more move to next iteration
//        4.if count exactly 4  then sum of factors

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();

        for (int i=0; i<T; i++){
            int N = s.nextInt();
            s.nextLine();
            List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            System.out.println(getSumOfDivisorWith4Divisors(arr, N));
        }
    }

    private static long getSumOfDivisorWith4Divisors(List<Integer> arr, int n) {
        long sum = 0;
        for (int i=0; i<n; i++){
            Integer num = arr.get(i);
            int sqrt = (int) Math.sqrt(num);

            if (sqrt*sqrt != num){
                int count = 0;
                long subSum = 0;
                for (int j=1; j<=sqrt && count<=4; j++){
                    if (num%j == 0){
                        if (j*j == num) {
                            subSum += j;
                            count++;
                        }
                        else {
                            subSum += j;
                            subSum += num/j;
                            count += 2;
                        }
                    }
                }
                if (count == 4)
                    sum += subSum;
            }
        }
        return sum;
    }
}
