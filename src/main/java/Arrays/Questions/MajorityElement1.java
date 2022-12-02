package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MajorityElement1 {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=23&sectionId=1&moduleId=1&topicId=1&subtopicId=14&homeworkId=3

        //https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/

        Scanner s = new Scanner(System.in);
        int N= s.nextInt();
        s.nextLine();
        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int count = 0, majority = -1;
        for (int i=0; i<N; i++){
            if (count == 0){
                majority = arr.get(i);
            }
            count += (arr.get(i) == majority) ? 1 : -1;
        }
        System.out.println(majority);
    }
}
