package Bactracking.Concept;

import javafx.util.Pair;

public class Path2 {
    public static void main(String[] args){
//        Paths - 2
//        Here, we have been given a 2D maze of dimension NxN containing 4 digits: 0(safe to travel), 1(source), 2(destination),
//        -1(unsafe to travel). We have to print the count of distinct paths from the source to the destination considering that at a
//        time we can move only one unit in any of the four directions.
//
//        Approach:
//        If we know the number of distinct valid paths originating from all the first moves i.e. top(x), down(y), left(z) and right(w) from
//        the source then the answer will be x+y+z+w.
//                In the previous question, each of our moves were progressive & it was impossible to go back. But here a step against
//                the destination can also be taken. This can lead to a problem as we can revisit the same cell multiple times leading to an infinite loop.
//
//
//        Therefore, we need to keep track of all the cells that have been visited. For this, we can use a boolean 2D array and mark the cells once they are visited.
//                Can it lead to any problem?
//                Hence, we have to use backtracking
//        Do: Visit a cell and mark visited
//        Move one unit in all four directions & recurse
//        Note: Keep a check on the boundary conditions while recursing in different directions
//        Undo: Unmark the cell once the recursion call is complete
        int a[][] = {{0,1,0},{0,0,0},{0,2,-1}};
        Pair<Integer, Integer> source = null;
        Pair<Integer, Integer> destination = null;

        //pre compute source and destination
        for (int i=0; i< a.length; i++){
            for (int j=0; j< a[0].length; j++){
                if (a[i][j] == 1){
                    source = new Pair<>(i, j);
                }
                if (a[i][j] == 2){
                    destination = new Pair<>(i, j);
                }
            }
        }
        int[][] visited = new int[a.length][a[0].length];
        int count = countOfDistinctPath(source.getKey(), source.getValue(), visited, a);
        System.out.println(count);
    }

    private static int countOfDistinctPath(Integer i, Integer j, int[][] visited, int[][] a) {
        //if reached destination
        if (a[i][j] == 2){
            return 1;
        }
        //mark
        visited[i][j] = 1;
        int sum = 0;

        //right move
        if (isSafe(i, j+1, a) && visited[i][j+1] == 0){
            sum += countOfDistinctPath(i, j+1, visited, a);
        }
        //left move
        if (isSafe(i, j-1, a) && visited[i][j-1] == 0){
            sum += countOfDistinctPath(i, j-1, visited, a);
        }
        //bottom
        if (isSafe(i+1, j, a) && visited[i+1][j] == 0){
            sum += countOfDistinctPath(i+1, j, visited, a);
        }
        //top
        if (isSafe(i-1, j, a) && visited[i-1][j] == 0){
            sum += countOfDistinctPath(i-1, j, visited, a);
        }
        //un mark
        visited[i][j] = 0;
        return sum;
    }

    private static boolean isSafe(Integer i, int j, int[][] a) {
        return !(i >= a.length) && !(j >= a[0].length) && j >= 0 && i >= 0 && a[i][j] >= 0;
    }
}
