package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UniquePairsWithGivenDifference {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=174&sectionId=1&moduleId=2&topicId=8&subtopicId=108&assignmentId=26

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), k = Integer.parseInt(s[1]);
        long[] arr = new long[n];
        String[] s1 = br.readLine().split(" ");
        for (int i=0; i<n; i++){
            arr[i] = Long.parseLong(s1[i]);
        }
        Arrays.sort(arr);
        System.out.println(countPairWithDifference(arr, n, k));
    }

    private static long countPairWithDifference(long[] arr, int n, int diff) {
        int i=0, j=1;
        long count = 0;
        while (j<n){
            long curr = arr[j]-arr[i];
            if (curr < diff){
                j++;
            } else if (curr > diff) {
                i++;
                if (i == j) j++;
            }else {
                long c1=0, p=arr[i], q=arr[j];
                if (diff == 0){
                    while (arr[i] == p) {
                        c1++; i++; j++;
                    }
                    count += (c1*(c1-1))/2;
                }
                else {
                    while (i < n && arr[i] == p){
                        i++;
                    }
                    while (j < n && arr[j] == q){
                        j++;
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
