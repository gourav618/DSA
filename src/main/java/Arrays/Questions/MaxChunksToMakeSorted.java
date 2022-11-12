package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaxChunksToMakeSorted {
    public static void main(String [] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=3&sectionId=1&moduleId=1&topicId=1&subtopicId=6&assignmentId=1

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int curr_max = Integer.MIN_VALUE, ans = 0;
        for (int i=0; i<n; i++){
            curr_max = Math.max(curr_max, arr.get(i));

            if (i == curr_max){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
