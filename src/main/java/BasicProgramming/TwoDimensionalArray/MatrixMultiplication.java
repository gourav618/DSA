package BasicProgramming.TwoDimensionalArray;

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=611&sectionId=1&moduleId=0&topicId=43&subtopicId=602&assignmentId=94

//        2 2
//        1 2 3 4
//        2 2
//        1 1 1 1

        Scanner s = new Scanner(System.in);
        int m = s.nextInt(), n = s.nextInt();
        s.nextLine();
        int [][] A = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                A[i][j] = s.nextInt();
            }
        }
        s.nextLine();

        int p = s.nextInt(), q = s.nextInt();
        s.nextLine();
        int [][] B = new int[p][q];
        for (int i=0; i<p; i++){
            for (int j=0; j<q; j++){
                B[i][j] = s.nextInt();
            }
        }

        if (n != p){
            System.out.println("IMPOSSIBLE");
        }else {
            int [][]res = new int[m][q];
            for (int i=0; i<m; i++){
                for (int j=0; j<q; j++){
                    for (int k=0; k<n; k++){ // k can even be k<p since n==p
                        res[i][j] += A[i][k] * B[k][j];
                    }
                }
            }

            //print matrix
            for (int i=0; i<m; i++){
                for (int j=0; j<q; j++){
                    System.out.print(res[i][j]+" ");
                }
            }
        }
    }
}
