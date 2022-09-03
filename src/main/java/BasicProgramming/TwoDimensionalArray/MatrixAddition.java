package BasicProgramming.TwoDimensionalArray;

import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=614&sectionId=1&moduleId=0&topicId=43&subtopicId=602&assignmentId=94

        Scanner s = new Scanner(System.in);
        int nA = s.nextInt(), mA = s.nextInt();
        s.nextLine();
        int [][]A = new int[nA][mA];
        for (int i=0; i<nA; i++){
            for (int j=0; j<mA; j++){
                A[i][j] = s.nextInt();
            }
            s.nextLine();
        }

        int nB = s.nextInt(), mB = s.nextInt();
        s.nextLine();
        int [][]B = new int[nB][mB];
        for (int i=0; i<nB; i++){
            for (int j=0; j<mB; j++){
                B[i][j] = s.nextInt();
            }
            s.nextLine();
        }

        //addition of 2 matrices
        int [][]C = new int[nA][mA];
        for (int i=0; i<nB; i++){
            for (int j=0; j<mB; j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        for (int i=0; i<nB; i++){
            for (int j=0; j<mB; j++){
                System.out.print(C[i][j]+" ");
            }
            System.out.println();
        }
    }
}
