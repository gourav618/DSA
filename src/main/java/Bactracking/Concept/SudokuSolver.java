package Bactracking.Concept;

import java.util.Vector;

public class SudokuSolver {
    public static void main(String[] args){
        int[][] board = {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };

        sudokuSolver(board);
    }

    private static void sudokuSolver(int[][] board) {
        boolean ansFound = false; // terminate if at least 1 ans found

        Vector<int[]> rf = new Vector<>();
        Vector<int[]> cf = new Vector<>();
        Vector<int[]> mf = new Vector<>();

        //init row freq
        for (int i=0;i<9;i++){
            int[] vec = new int[9];
            for (int j=0; j<9; j++){
                if (board[i][j] != 0){
                    vec[board[i][j]-1]++;
                }
            }
            rf.add(vec);
        }

        //init column freq
        for (int j=0; j<9; j++){
            int[] vec = new int[9];
            for (int i=0; i<9; i++){
                if (board[i][j] != 0){
                    vec[board[i][j]-1]++;
                }
            }
            cf.add(vec);
        }

        //init matrix freq
        for (int i=0; i<9; i+=3){
            for (int j=0; j<9; j+=3){
                int[] vec = new int[9];
                for (int i1=i; i1<i+3; i1++){
                    for (int j1=j; j1<j+3; j1++){
                        if (board[i1][j1] != 0){
                            vec[board[i1][j1]-1]++;
                        }
                    }
                }
                mf.add(vec);
            }
        }

        //answer config
        int [][] ans = new int[9][9];

        ss(board, 0, 0, ansFound, rf, cf, mf, ans);

        //copy ans to board
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                board[i][j] = ans[i][j];
            }
        }

        //print board
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
               System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static void ss(int[][] board, int i, int j, boolean ansFound, Vector<int[]> rf, Vector<int[]> cf, Vector<int[]> mf, int[][] ans) {
        if (ansFound){// if 1 possible config found
            return;
        }

        // termination
        if (i == 9){
            ansFound = true;
            //copy board to ans
            for (int q=0; q<9; q++){
                for (int r=0; r<9; r++){
                    ans[q][r] = board[q][r];
                }
            }
            return;
        }

        //if index already filled
        if (board[i][j] != 0){
            if (j<8){ // not last column
                ss(board, i, j+1, ansFound, rf, cf, mf, ans);
            }else {// last column : move to next row
                ss(board, i+1, 0, ansFound, rf, cf, mf, ans);
            }
            return;
        }

        int mat_num = getMatrixNumber(i, j);

        for (int val=1; val<=9; val++){
            if (rf.get(i)[val-1] == 0 && cf.get(j)[val-1] == 0 && mf.get(mat_num)[val-1] == 0){
                board[i][j] = val;
                rf.get(i)[val-1] = 1;
                cf.get(j)[val-1] = 1;
                mf.get(mat_num)[val-1] = 1;

                if (j<8){ // not last column
                    ss(board, i, j+1, ansFound, rf, cf, mf, ans);
                }else {// last column : move to next row
                    ss(board, i+1, 0, ansFound, rf, cf, mf, ans);
                }

                board[i][j] = 0;
                rf.get(i)[val-1] = 0;
                cf.get(j)[val-1] = 0;
                mf.get(mat_num)[val-1] = 0;
            }
        }
    }

    private static int getMatrixNumber(int i, int j) {
        if(i<3 && j<3){
            return 0;
        }
        if(i < 3 && j < 6){
            return 1;
        }
        if(i < 3 && j < 9){
            return 2;
        }
        if(i<6 && i>2 && j<3){
            return 3;
        }
        if(i < 6 && i > 2 && j < 6){
            return 4;
        }
        if(i < 6 && i > 2 && j < 9){
            return 5;
        }
        if(i<9 && i>5 && j<3){
            return 6;
        }
        if(i < 9 && i > 5 && j < 6){
            return 7;
        }
        else{
            return 8;
        }

    }
}
