package Arrays.Questions;

import java.util.Scanner;

public class SumOfAllSubMatrices {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=11&sectionId=1&moduleId=1&topicId=1&subtopicId=11&assignmentId=2

        Scanner s = new Scanner(System.in);
        long n = s.nextLong(), m = s.nextLong();
        s.nextLine();

        long[][] arr = new long[Math.toIntExact(n)][Math.toIntExact(m)];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                arr[i][j] = s.nextLong();
            }
        }

        long mod = 1000000007;
        long sum = 0L;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                long topLeft = ((i+1) % mod * (j+1) % mod) % mod;
                long bottomRight = ((m-j) % mod * (n-i) % mod) % mod;
                sum = ((sum % mod) + ((arr[i][j] % mod * topLeft % mod) % mod * bottomRight % mod) % mod) % mod;
            }
        }

        System.out.println(sum);
    }
}
