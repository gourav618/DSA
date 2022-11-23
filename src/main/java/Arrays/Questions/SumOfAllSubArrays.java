package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumOfAllSubArrays {
    public static void main(String [] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=10&sectionId=1&moduleId=1&topicId=1&subtopicId=11&assignmentId=2

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long [] arr = new long[n];
        for (int i=0; i<n; i++){
            arr[i] = s.nextLong();
        }

        //instead of traversing all sub array i.e o(n^2)
        //find the no of time the element will appear if we consider all sub array and calculate sum
        long m = 1000000007;
        long sum = 0L;
        for (int i=0; i< n; i++){
            sum = ((sum % m) + (((i + 1) % m * (n-i) % m) % m * arr[i] % m) % m) % m;
        }
        System.out.println(sum);
    }
}
