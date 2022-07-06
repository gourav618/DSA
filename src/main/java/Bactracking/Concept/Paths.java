package Bactracking.Concept;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class Paths {
    public static void main(String[] args){
//        Paths - 1
//        We have been given a 2D matrix of dimension NxN with source(0,0) and destination(N-1, N-1). The matrix is filled with 0s & 1s, where ‘0’ indicates the cells that can be used for traversal while ‘1’ represents the cells that are not safe to travel. We have to print all the possible paths to reach from the source to the destination given that the steps are restricted to one unit rightwards or downwards at a time.
//
//                Grid
//        Approach:
//
//        How do we print a path? We can print the sequence of cells (i, j) in a valid path by storing them in a vector of pairs <vector<pair<int, int>>>
//
//        Do: Push the cell in the vector if it is safe(‘0’) to travel
//        Recurse: Move right & recurse
//        Move left & recurse
//        Note: Ensure that the right or left move is possible - boundary conditions
//        Undo: Pop the cell from the vector
//        Termination Condition: if(i==N-1 and i==j){ print(path); return; }

        List<Pair<Integer, Integer>> paths = new ArrayList<>();
        int[][] matrix = {{0,0,1,1},{0,0,1,0},{1,0,1,1},{0,0,0,0}};
        printPathForNxN(paths, 0, 0, matrix);
    }

    private static void printPathForNxN(List<Pair<Integer, Integer>> paths, int i, int j, int[][] a) {
        if (a[i][j] == 1){
            return; // poison cell
        }
        if (i==j && j== a.length-1){ // reached destination
            printList(paths);
            System.out.println("("+ i +", "+ j+ ") ");
            return;
        }
        // do i.e push in list new parent
        paths.add(new Pair<>(i, j));

        if (i == a.length-1){ //if last row
            printPathForNxN(paths, i, j+1, a);
        }
        else if (j == a.length-1){//if last column
            printPathForNxN(paths, i+1, j, a);
        }
        else {//other cell
            printPathForNxN(paths, i, j+1, a);
            printPathForNxN(paths, i+1, j, a);
        }
        // undo i.e remove last elem in list
        paths.remove(paths.size()-1);
    }

    private static void printList(List<Pair<Integer, Integer>> paths) {
        for (Pair<Integer, Integer> pair: paths){
            System.out.print("("+ pair.getKey() +", "+ pair.getValue()+ "), ");
        }
    }
}
