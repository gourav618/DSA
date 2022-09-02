package BasicProgramming.TwoDimensionalArray;

import java.util.Scanner;

public class MatrixDiagonalSum {
    public static void main(String [] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=612&sectionId=1&moduleId=0&topicId=43&subtopicId=602&assignmentId=94

        Scanner s = new Scanner(System.in);
        int m = s.nextInt(), n = s.nextInt();
        s.nextLine();
        int [][] matrix = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                matrix[i][j] = s.nextInt();
            }
            s.nextLine();
        }

        int sum = 0;
        int i=0, j=0;
        //sum of primary diagonal
        while (i < n){
            sum += matrix[i][j];
            i++;
            j++;
        }
        //sum of secondary diagonal
        i=0; j=n-1;
        while (i < n){
            if (i != j){
                sum += matrix[i][j];
            }
            i++;
            j--;
        }
        System.out.println(sum);
    }
}
