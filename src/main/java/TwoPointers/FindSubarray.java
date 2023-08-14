package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindSubarray {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=175&sectionId=1&moduleId=2&topicId=8&subtopicId=112&assignmentId=27

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0){
            String[] l1 = br.readLine().split(" ");
            int n = Integer.parseInt(l1[0]);
            long s = Long.parseLong(l1[1]);
            long[] arr = new long[n];
            String[] l2 = br.readLine().split(" ");
            for (int i=0; i<n; i++){
                arr[i] = Long.parseLong(l2[i]);
            }
            System.out.println(findSubArrayWithSum(arr, n, s));
        }
    }

    private static String findSubArrayWithSum(long[] arr, int n, long s) {
        int i=0, j=0;
        long curr = arr[0];
        while (j<n) {
            if (curr < s){
                j++;
                if (j<n)
                    curr += arr[j];
            } else if (curr > s) {
                curr -= arr[i];
                i++;
                if (i > j){
                    j++;
                    if (j < n)
                        curr += arr[j];
                }
            } else {
                return (i+1)+" "+(j+1);
            }
        }
        return "-1";
    }
}
