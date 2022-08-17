package BasicProgramming.loops.Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KitchenTimeTables {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=604&sectionId=1&moduleId=0&topicId=42&subtopicId=585&assignmentId=93

//        3
//        1 10 15
//        1 10 3
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        List<Integer> momentStudentFinishCooking = Arrays.stream(s.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> timeRequired = Arrays.stream(s.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int count = 0;
        for (int i=0; i<N; i++){
            int timeRemaining = momentStudentFinishCooking.get(i) - (i==0 ? 0 : momentStudentFinishCooking.get(i-1));
            if (timeRequired.get(i) <= timeRemaining){
                count++;
            }
        }
        System.out.println(count);
    }
}
