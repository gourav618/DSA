package Sorting.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ManhattanDistance {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/practice/question?questionId=135&sectionId=1&moduleId=2&topicId=7&subtopicId=90&assignmentId=20

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(r.readLine());

        long[] x = new long[(int) n];
        long[] y = new long[(int) n];

        long total_x_sum=0, total_y_sum=0;
        for (int i=0; i<n; i++){
            Long[] s = Arrays.stream(r.readLine().split(" ")).map(Long::parseLong).toArray(Long[]::new);
            x[i] = s[0];
            y[i] = s[1];
            total_x_sum += s[0];
            total_y_sum += s[1];
        }

        Arrays.sort(x);
        Arrays.sort(y);

        long xDiff=findDiffWithEachPointAsReference(x, total_x_sum, n);
        long yDiff = findDiffWithEachPointAsReference(y, total_y_sum, n);

        System.out.println((xDiff+yDiff)%1000000007);
    }

    private static long findDiffWithEachPointAsReference(long[] x, long total_sum, long n) {
        long diff = 0;
        for (int i=0; i<n; i++){
            total_sum -= x[i];
            diff += total_sum - ((n-1-i)*x[i]);
        }
        return diff;
    }
}
