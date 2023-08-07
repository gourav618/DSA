package TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class PairWithASum {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=171&sectionId=1&moduleId=2&topicId=8&subtopicId=108&assignmentId=26

        Scanner s = new Scanner(System.in);
        String[] s1 = s.nextLine().split(" ");
        //n->size of array, k->determine if there is a pair whose sum is exactly k
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        Integer[] arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        Arrays.sort(arr);

        boolean ifPairWithSumKExists = checkIfPairWithSumKExists(arr, n, k);
        if (ifPairWithSumKExists){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }

    private static boolean checkIfPairWithSumKExists(Integer[] arr, int n, int k) {
        int i=0, j=n-1;
        while (i<j){
            int currSum = arr[i]+arr[j];
            if (currSum > k){
                j--;
            } else if (currSum < k) {
                i++;
            }else {
                return true;
            }
        }
        return false;
    }
}
