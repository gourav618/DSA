package Mathematics.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreePrime {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/practice/question?questionId=40&sectionId=1&moduleId=1&topicId=2&subtopicId=25&homeworkId=5

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 100001;
        int []prime = new int[max+1];
        prime[1] = 1;
        for (int i=2;i<=Math.sqrt(max); i++){
            if (prime[i] == 0){
                for (int j=i; i*j<=max; j++){
                    prime[i*j] = 1;
                }
            }
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            long res = 0;
            for (String j : arr){
                int i = Integer.parseInt(j);
                int sqrt = (int) Math.sqrt(i);
                if (sqrt*sqrt == i && prime[sqrt] == 0){
                    res += i;
                }
            }
            System.out.println(res);
        }
    }
}
