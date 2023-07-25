package Sorting.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class MaximizeIndexDifference {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=138&sectionId=1&moduleId=2&topicId=7&subtopicId=94&assignmentId=21

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long[][] arrayWithIndex = new long[n][2];
        for (int i = 0; i < n; i++) {
            arrayWithIndex[i][0] = arr[i];
            arrayWithIndex[i][1] = i;
        }

        Arrays.sort(arrayWithIndex, Comparator.comparingLong(a -> a[0]));

        long ans = 0L;
        long suffixMax = arrayWithIndex[n - 1][1];
        for (int i = n - 2; i >= 0; i--) {
            ans = Math.max(ans, suffixMax - arrayWithIndex[i][1]);
            suffixMax = Math.max(suffixMax, arrayWithIndex[i][1]);
        }
        System.out.println(ans);
    }
}
