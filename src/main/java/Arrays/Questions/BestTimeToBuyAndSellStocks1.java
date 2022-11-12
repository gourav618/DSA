package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BestTimeToBuyAndSellStocks1 {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=5&sectionId=1&moduleId=1&topicId=1&subtopicId=6&homeworkId=1

        Scanner s  = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        //suffix max
        int[] sm = new int[n];
        sm[n-1] = arr.get(n-1);
        for (int i=n-2; i>=0; i--){
            sm[i] = Math.max(sm[i+1], arr.get(i));
        }

        int profit = Integer.MIN_VALUE;
        for (int i=0; i<n-1; i++){
            profit = Math.max(profit, sm[i+1] - arr.get(i));
        }

        System.out.println(Math.max(profit, 0));
    }
}
