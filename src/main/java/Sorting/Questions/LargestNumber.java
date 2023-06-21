package Sorting.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/practice/question?questionId=149&sectionId=1&moduleId=2&topicId=7&subtopicId=85&homeworkId=18
        //https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/

        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(s.readLine().trim());
        while (t-- > 0){
            int n = Integer.parseInt(s.readLine().trim());
            Long[] arr = Arrays.stream(s.readLine().split(" ")).map(Long::parseLong).toArray(Long[]::new);
            printLargestNumberFormed(arr, n);
        }
    }

    private static void printLargestNumberFormed(Long[] arr, int n) {
        Arrays.sort(arr, (e1, e2) -> {
            long xy = Long.parseLong(e1.toString() + e2.toString());
            long yx = Long.parseLong(e2.toString() + e1.toString());
            return Long.compare(yx, xy);
        });
        int countOfZero = 0;
        StringBuilder s = new StringBuilder();
        for (Long e : arr){
            if (e == 0){
                countOfZero++;
            }
            s.append(e);
        }
        System.out.println(countOfZero == n ? 0 : s);
    }
}
