package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MinimumSwapsToBringTogether {
    public static void main(String [] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=9&sectionId=1&moduleId=1&topicId=1&subtopicId=11&assignmentId=2

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        s.nextLine();

        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        //count no of legal elements -> that would be the size of window
        int legalElem = 0;
        for (int e : arr){
            if (e <= k){
                legalElem++;
            }
        }

        //count legal elem in 1st window
        int count = 0;
        for (int i=0; i<legalElem; i++){
            if (arr.get(i) <= k){
                count++;
            }
        }

        //count legal elem in each window and update the max_count
        int max_count = Integer.MIN_VALUE;
        for (int i= legalElem; i<n; i++){
            max_count = Math.max(max_count, count);
            if (arr.get(i) <= k){
                count++;
            }
            if (arr.get(i-legalElem) <= k){
                count--;
            }
        }

        max_count = Math.max(max_count, count);

        System.out.println(legalElem-max_count);

    }
}
