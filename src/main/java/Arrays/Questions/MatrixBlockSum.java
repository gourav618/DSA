package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MatrixBlockSum {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=16&sectionId=1&moduleId=1&topicId=1&subtopicId=11&homeworkId=2

        Scanner s = new Scanner(System.in);

        List<Integer> dim = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int m = dim.get(0), n = dim.get(1), k = dim.get(2);

        int [][]mat = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                mat[i][j] = s.nextInt();
            }
        }

        //calculate prefix sum for 2d array
        //sum row wise
        for (int i=0; i<m; i++){
            for (int j=1; j<n; j++){
                mat[i][j] = mat[i][j-1] + mat[i][j];
            }
        }
        //sum column wise
        for (int i=1; i<m; i++){
            for (int j=0; j<n; j++){
                mat[i][j] += mat[i-1][j];
            }
        }

        int [][]ans = new int[m][n];

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                int i1 = Math.max(i - k, 0);
                int j1 = Math.max(j-k, 0);
                int i2 = Math.min(i+k, m-1);
                int j2 = Math.min(j+k, n-1);

                if (i1 == 0 && j1==0) {
                    ans[i][j] = mat[i2][j2];
                }
                else if (i1 == 0) {
                    ans[i][j] = mat[i2][j2] - mat[i2][j1-1];
                }
                else if (j1 == 0) {
                    ans[i][j] = mat[i2][j2] - mat[i1-1][j2];
                }
                else {
                    ans[i][j] = mat[i2][j2] - mat[i2][j1-1] - mat[i1-1][j2] + mat[i1-1][j1-1];
                }
            }
        }

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
