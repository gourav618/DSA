package Mathematics.Questions;

import java.util.Scanner;

public class CountValidParenthesis {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=53&sectionId=1&moduleId=1&topicId=2&subtopicId=36&assignmentId=7

        Scanner s = new Scanner(System.in);

        //pre processing to get catalan number up to 1000 sine N <= 1000
        int max = 500;
        int m=1000000007;
        long []count = new long[max+1];
        count[0] = 1;
        count[1] = 1;
        for (int i=2; i<=max; i++){
            count[i] = 0;
            for (int j=0; j<=i-1; j++){
                count[i] += (count[j]%m * count[i-1-j]%m)%m;
            }
            count[i] %= m;
        }

        int T = s.nextInt();s.nextLine();
        while (T-- > 0){
            int N = s.nextInt();
            if (N%2 == 0){// i.e brackets in pairs
                System.out.println(count[N/2]);
            }else {
                System.out.println(-1);
            }
        }

    }
}
