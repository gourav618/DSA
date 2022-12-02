package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayNesting {
    public static void main (String [] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=21&sectionId=1&moduleId=1&topicId=1&subtopicId=14&homeworkId=3

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        // store the prev elem added in set and to count the elem in set
        int prev = 0, count = 0;
        for (int i=0; i >= 0 && i < N;){
            Integer elem = arr.get(i); // getting the element
            //if elem equals to the index then there is no cycle there , therefore skip that
            if (elem == i){
                i += 1;
            }
            else if (elem >= 0){
                //here elem is not visited  since >=0 then i updated the count and prev and update the arr elem
                count++;
                prev = arr.get(i);
                arr.set(i, -(arr.get(i) + 1));
                i = prev;
            }else {
                break;
            }
        }
        //if count == 0 i.e all elem equals to index hence no cycle so only 1 elem can be added to set
        System.out.println(count == 0 ? 1 : count);
    }
}
