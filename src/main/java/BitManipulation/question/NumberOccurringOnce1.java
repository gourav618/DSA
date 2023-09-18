package BitManipulation.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOccurringOnce1 {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=198&sectionId=1&moduleId=2&topicId=9&subtopicId=124&assignmentId=31

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        long[] arr = new long[n];
        long ans = 0;
        for (int i=0; i<n; i++){
            arr[i] = Long.parseLong(s[i]);
            ans = (ans ^ arr[i]);
        }

        System.out.println(ans);
    }
}
