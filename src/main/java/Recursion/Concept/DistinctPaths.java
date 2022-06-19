package Recursion.Concept;

public class DistinctPaths {
    static int m=3, n=3;
    public static void main(String[] args){
//        We have been given a 2D matrix of dimension M x N. We have to find the total number of distinct paths
//        to reach from (0,0) to (M-1, N-1) under the constrained movement of one unit rightwards or downwards each time.
//        Approach: Top to Bottom
//        Recurrence Relation: If we know the number of unique paths from (1,0) & (0,1) to (M-1, N-1) individually.
//        Then the total number of distinct paths from (0,0) to (M-1, N-1) will be:
//        CountPaths(0,0) = CountPaths(0,1) + CountPaths(1,0)
//
//        Thus we can form a recursive relation as:
//        CountPaths(i, j) = CountPaths(i, j+1) + CountPaths(i+1, j)
//        Termination Condition: Since we know that i<M and j<N and for i==M-1 or j==N-1 there is only one path to reach the destination.
//        Therefore, the termination condition can be written as:
//        if(i==M-1 or j==N-1) return 1;
//        Time complexity: O(2^(M+N))
//        Space complexity: O(M+N)
        //initial call
        int distinctPathByRecursion = getDistinctPathByRecursion(0, 0);
        System.out.println(distinctPathByRecursion);


    }

    private static int getDistinctPathByRecursion(int i, int j) {
       if (i == m-1 || j == n-1){
           return 1;
       }
       return getDistinctPathByRecursion(i,j+1) + getDistinctPathByRecursion(i+1, j);
    }

}
