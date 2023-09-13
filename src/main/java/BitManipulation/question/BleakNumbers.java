package BitManipulation.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BleakNumbers {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=216&sectionId=1&moduleId=2&topicId=9&subtopicId=121&homeworkId=30

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int isBleakNumber=1;
        for (int i=1; i<=n; i++){
            int countOfSetBits = countOfSetBits(i);
            if (i+countOfSetBits == n){
                isBleakNumber=0;
                break;
            }
        }
        System.out.println(isBleakNumber);
    }
    private static int countOfSetBits(int n) {
        int count=0;
        while (n!=0){
            n = (n&(n-1));
            count++;
        }
        return count;
    }
}
