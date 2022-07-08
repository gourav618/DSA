package Bactracking.Concept;

public class NQueens {
    public static void main(String[] args){
//        Lecture 6: N-Queens
//        Place ‘N’ Queens on an NxN chessboard such that no queen attacks other queens.
//
//        Approach:
//        For N=1
//        N=1

//        For N=2, Not possible
//                N=2
//
//        For N=3, Not possible
//                N=3
//
//        For N=4, 2 possibilities
//                N=4
//
//        We can use recursion and backtracking to place the queens row-wise in such a way that they do not attack each other.
//        If there are no possible configurations then we should return 0 otherwise add them in the count.
//        We can return the configuration of the queens by storing it in a 2D vector.
//                Do: Place a queen in a cell of a row
//        Recurse: Make a recursion call for that placement of the queen
//        Undo: Remove the queen from that cell
//        During recursion, there are multiple states where exploring each node can be a waste of time as the queen
//        placement may not be appropriate in the beginning only. Therefore we can prune off these unnecessary states by using an isSafe method.
//        bool isSafe(int i, int j){
//            intx = i-1;
//            while(x>=0){   //check in same column
//                if(arr[x][j]==1){
//                    return false;
//                }
//                x--;
//                x = i-1;
//                nt y = j-1;
//
//                while(x>=0 and y>=0){ //check in principal diagonal
//                    if(arr[x][y]==1){
//                        return false;
//                    }
//                    x--; y--;
//                }
//                x = i-1;
//                y = j+1;
//                while(x>=0 and y<n){  //check in secondary diagonal
//                    if(arr[x][j]==1){
//                        return;
//                    }
//                    x--; y++;
//                }
//                return true;
//            }
        int[][] arr = new int[4][4];

        printNQueens(0, arr);
    }

    private static void printNQueens(int r, int[][] arr) {
        //terminate
        if (r == arr.length){
            //print content of array
            for (int i=0; i< arr.length; i++){
                for (int j=0; j< arr[0].length; j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        // for each row place queen at each column
        for (int c=0; c< arr.length; c++){
            // do this if safe
            if (isSafe(r,c,arr)){
                arr[r][c] = 1; // do
                printNQueens(r+1, arr); //call
                arr[r][c] = 0; //undo
            }
        }
    }

    private static boolean isSafe(int i, int j, int[][] arr) {
        int x = i-1;
        while (x>=0){//check in same column
            if (arr[x][j] == 1){
                return false;
            }
            x--;
        }

        x = i-1;
        int y = j-1;
        while (x>=0 && y>=0){//check in principal diagonal
            if (arr[x][y] == 1){
                return false;
            }
            x--;y--;
        }

        x=i-1; y=j+1;
        while (x>=0 && y< arr.length){//check in secondary diagonal
            if (arr[x][y] == 1){
                return false;
            }
            x--;y++;
        }
        return true;
    }
}
