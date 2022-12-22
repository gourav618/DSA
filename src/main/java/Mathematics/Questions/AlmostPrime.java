package Mathematics.Questions;

import java.util.Scanner;

public class AlmostPrime {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=37&sectionId=1&moduleId=1&topicId=2&subtopicId=25&homeworkId=5

        Scanner s = new Scanner(System.in);

        int max = 1000000;
        int[] prime = new int[max+1];

        for (int i=2; i<=max; i++){
            if(prime[i] == 0){
                for (long j=1; j*i<=max; j++){
                    prime[(int)j*i]++;
                }
            }
        }

        int []count = new int[max+1];
        for (int i=1; i<=max; i++){
            count[i] = count[i-1]+ (prime[i] == 2 ? 1 : 0);
        }

        int T = s.nextInt();
        s.nextLine();
        while (T-- > 0){
            int N = Integer.parseInt(s.nextLine());
            System.out.println(count[N]);
        }
    }
}
