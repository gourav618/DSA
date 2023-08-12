package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PairWithADifference {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=173&sectionId=1&moduleId=2&topicId=8&subtopicId=108&assignmentId=26

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), k = Integer.parseInt(s[1]);
        long[] arr = new long[n];
        String[] s1 = br.readLine().split(" ");
        for (int i=0; i<n; i++){
            arr[i] = Long.parseLong(s1[i]);
        }

        Arrays.sort(arr);
        boolean b = ifPairWithDifferenceExists(arr, n, k);
        System.out.println(b ? "Yes" : "No");
    }

    private static boolean ifPairWithDifferenceExists(long[] arr, int n, int diff) {
        int i=0, j=1;
        while (j<n){
            long curr = diff<0 ? arr[i]-arr[j] : arr[j]-arr[i];
            if (curr < diff) {
                if (diff < 0)
                    i++;
                else
                    j++;
            } else if (curr > diff) {
                if (diff < 0)
                    j++;
                else
                    i++;
                if (i == j) j++;
            }else {
                return true;
            }
        }
        return false;
    }
}
