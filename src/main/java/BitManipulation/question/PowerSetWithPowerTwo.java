package BitManipulation.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerSetWithPowerTwo {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=215&sectionId=1&moduleId=2&topicId=9&subtopicId=121&homeworkId=30

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        int count = 0;
        for (int i=0; i<n; i++){
            if ((arr[i]&(arr[i]-1)) == 0){
                count++;
            }
        }

         long ans = 1, m = (long) (1e9+7);
        for (int i=0; i<count; i++){
            ans = ((ans % m) * (2 % m))%m;
        }
        System.out.println(ans-1);
    }
}
