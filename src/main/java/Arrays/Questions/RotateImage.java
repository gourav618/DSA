package Arrays.Questions;

import java.util.Arrays;
import java.util.Scanner;

public class RotateImage {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=8&sectionId=1&moduleId=1&topicId=1&subtopicId=6&homeworkId=1

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();

        int[][] mat = new int[N][N];
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                mat[i][j] = s.nextInt();
            }
            s.nextLine();
        }

        //transpose of matrix
        for (int i=0; i<N; i++){
            for (int j=i; j<N; j++){
                if (!(i==j)) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
        }

        //reverse each row in matrix
        for (int i=0; i<N; i++){
            for (int j=0; j<N/2; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][N-j-1];
                mat[i][N-j-1] = temp;
            }
            Arrays.stream(mat[i]).forEach(e -> System.out.print(e+" "));
            System.out.println();
        }
    }
}
