package Mathematics.Questions;

import java.util.Arrays;
import java.util.Scanner;

public class DivisorSummation {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=39&sectionId=1&moduleId=1&topicId=2&subtopicId=25&homeworkId=5

        Scanner s = new Scanner(System.in);

        int T = Integer.parseInt(s.nextLine());

        while(T-- > 0){
            int n = Integer.parseInt(s.nextLine());
            long sum = 0;
            if (n == 1){
                System.out.println(0);
            }else{
                for (int i=2; i<=Math.sqrt(n); i++){
                    if (n%i == 0){
                        if (i*i == n){
                            sum += i;
                        }else {
                            sum += i+n/i;
                        }
                    }
                }
                System.out.println(sum+1);
            }
        }
    }
}
