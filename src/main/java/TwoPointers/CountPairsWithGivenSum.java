package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class CountPairsWithGivenSum {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=172&sectionId=1&moduleId=2&topicId=8&subtopicId=108&assignmentId=26

        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = s.readLine().split(" ");
        //n->size of array, k->determine if there is a pair whose sum is exactly k
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        String[] str = s.readLine().trim().split(" ");
        long[] arr = new long[n];

        for(int i=0; i<n; i++){

            arr[i] = Integer.parseInt(str[i]);

        }
        //sort the array required for 2ptr logic
        Arrays.sort(arr);

        System.out.println(countPairsWithGivenSum(arr, k, n));
    }

    private static long countPairsWithGivenSum(long[] arr, int k, int n) {
        int i=0, j=n-1; long count=0;
        while (i<j){
            long currSum = arr[i]+arr[j];
            if (currSum < k){
                i++;
            } else if (currSum > k) {
                j--;
            }else {
                if (arr[i] == arr[j]){//if both end element equal that means we update count by lC2 = l(l-1)/2, where l is frequency of that number
                   long l = j-i+1;
                   count += (l*(l-1))/2;
                   break;
                }else {
                    //count occurrence(c1&c2) of both p&q and a/c to rule of product possible pairs = c1*c2
                    long c1 = 0, c2 = 0, p = arr[i], q = arr[j];
                    while (arr[i] == p) {
                        i++;
                        c1++;
                    }
                    while (arr[j] == q) {
                        j--;
                        c2++;
                    }
                    count += c1 * c2;
                }
            }
        }
        return count;
    }
}
