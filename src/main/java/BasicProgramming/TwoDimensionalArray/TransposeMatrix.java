package BasicProgramming.TwoDimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class TransposeMatrix {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/topics/lecture?module=0&topic=43&subtopic=600

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

        transposeUsingExtraMatrix(mat, m, n);

        transposeWithoutUsingExtraSpace(mat.clone(), m, n);

        transposeWhenNotASquareMatrix(mat, m, n);
    }

    private static void transposeWhenNotASquareMatrix(int[][] mat, int m, int n) {
        int [][]mat2 = new int[n][m];

        //traverse upper right traingle
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                //mat2[i][j] = mat[j][i];
                mat2[j][i] = mat[i][j];
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                System.out.print(mat2[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void transposeWithoutUsingExtraSpace(int[][] mat, int m, int n) {
        //traverse upper right traingle
        for (int i=0; i<m; i++){
            for (int j=i; j<n; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
               System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void transposeUsingExtraMatrix(int[][] mat, int m, int n) {
        int [][]mat2 = new int[n][m];

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                mat2[j][i] = mat[i][j];
            }
        }

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                System.out.print(mat2[i][j]+" ");
            }
            System.out.println();
        }
    }
}
