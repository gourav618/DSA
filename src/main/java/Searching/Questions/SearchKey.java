package Searching.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchKey {
    public static void main(String[] args) {
        //https://dashboard.programmingpathshala.com/practice/question?questionId=94&sectionId=1&moduleId=2&topicId=6&subtopicId=68&assignmentId=14

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int T = s.nextInt();

        while (T-- > 0) {
            int key = s.nextInt();
            int index = binarySearch(arr, 0, N - 1, key);
            System.out.println(index);
        }
    }

    private static int binarySearch(List<Integer> arr, int l, int h, int key) {
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr.get(mid) == key) {
                return mid;
            } else if (arr.get(mid) < key) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }
}
