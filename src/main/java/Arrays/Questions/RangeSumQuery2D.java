package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RangeSumQuery2D {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=12&sectionId=1&moduleId=1&topicId=1&subtopicId=11&assignmentId=2

        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt();
        s.nextLine();
        int [][] arr = new int[n][m];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                arr[i][j] = s.nextInt();
            }
        }

        int [][]ps = new int[n][m];
        //do row wise prefix sum
        for (int i=0; i<n; i++){
            ps[i][0] = arr[i][0];
            for (int j=1; j<m; j++){
                ps[i][j] = ps[i][j-1] + arr[i][j];
            }
        }
        //do column wise prefix sum
        for (int i=0; i<m; i++){
            for (int j=1; j<n; j++){
                ps[j][i] = ps[j-1][i] + ps[j][i];
            }
        }

        s.nextLine();
        int q = s.nextInt();
        s.nextLine();
        for (int i=0; i<q; i++){
            List<Integer> queries = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            System.out.println(findSumUsingPrefixMax(ps, queries.get(0), queries.get(1), queries.get(2), queries.get(3)));
        }
    }

    private static int findSumUsingPrefixMax(int[][] ps, Integer i1, Integer j1, Integer i2, Integer j2) {
        int sum = ps[i2][j2];

        if (j1-1 >= 0){
            sum -= ps[i2][j1-1];
        }
        if (i1-1 >=0){
            sum -= ps[i1-1][j2];
        }
        if (i1-1 >=0 && j1-1 >= 0){
            sum += ps[i1-1][j1-1];
        }
        return sum;
    }
}
