package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RearrangeArray {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=20&sectionId=1&moduleId=1&topicId=1&subtopicId=14&assignmentId=3

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        arrangeArrayUsingCycleMethod(arr, n);

        arr.forEach(i -> System.out.print(i+" "));
    }

    private static void arrangeArrayUsingCycleMethod(List<Integer> arr, int n) {
        for (int i=0; i<n; i++){
            //start cycle from non visited index
            if (arr.get(i) >= 0){
                int index = arr.get(i), val = i;
                //until arr[i] points to starting index of cycle
                while (index != i){
                    int temp = arr.get(index);
                    arr.set(index, -(val+1));
                    val = index;
                    index = temp;
                }
                arr.set(index, -(val+1));
            }
        }

        //convert the array value to original one
        for (int i=0; i<n; i++){
            arr.set(i, -1 * arr.get(i) -1);
        }
    }
}
