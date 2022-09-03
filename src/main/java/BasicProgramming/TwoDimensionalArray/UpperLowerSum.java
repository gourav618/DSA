package BasicProgramming.TwoDimensionalArray;

import java.util.Scanner;

public class UpperLowerSum {
    public static void main(String [] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=615&sectionId=1&moduleId=0&topicId=43&subtopicId=602&assignmentId=94

        Scanner s = new Scanner(System.in);
        int m = s.nextInt(), n = s.nextInt();
        s.nextLine();
        int [][]mat = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                mat[i][j] = s.nextInt();
            }
            s.nextLine();
        }

        int upTriangleSum = 0, lowerTriangleSum = 0;
        for (int i=0; i<m; i++){
            for (int j=i; j<n; j++){
                upTriangleSum += mat[i][j];
                lowerTriangleSum += mat[j][i];
            }
        }
        System.out.println(upTriangleSum);
        System.out.println(lowerTriangleSum);
    }
}
