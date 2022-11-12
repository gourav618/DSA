package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RotateArray {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=4&sectionId=1&moduleId=1&topicId=1&subtopicId=6&assignmentId=1

        Scanner s = new Scanner(System.in);
        List<Integer> nK = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Long> arr = Arrays.stream(s.nextLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());

        //if k>N then only n%k rotation required
        int requiredRotation = nK.get(1) % nK.get(0);
        //reverse right part
        reverseArrayInRange(arr, nK.get(0) - requiredRotation, nK.get(0)-1);
        //reverse left part
        reverseArrayInRange(arr, 0, nK.get(0) - requiredRotation - 1);
        //reverse whole array
        reverseArrayInRange(arr, 0, nK.get(0)-1);

        arr.forEach(i -> System.out.print(i+" "));
    }

    private static void reverseArrayInRange(List<Long> arr, int i, int j) {

        for (int p=i; p<j; p++, j--){
            long temp = arr.get(p);
            arr.set(p, arr.get(j));
            arr.set(j, temp);
        }
    }
}
