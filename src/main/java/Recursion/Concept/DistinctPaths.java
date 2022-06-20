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

        int count[] = {0};// created array for pass by reference
        getDistinctPathByVoidRecursion(0, 0, count);
        System.out.println(count[0]);

        // above approach are top to bottom since we fixed destination and starting from source
        //BottomToTopApproach : source is fixed and need to start from destination
        int distinctPathByBottomToTOpApproach = getDistinctPathByBottomToTOpApproach(m-1, n-1);
        System.out.println(distinctPathByBottomToTOpApproach);

    }

    private static int getDistinctPathByBottomToTOpApproach(int i, int j) {
        if (i == 0 || j == 0){
            return 1;
        }
        return getDistinctPathByBottomToTOpApproach(i,j-1)+ getDistinctPathByBottomToTOpApproach(i-1,j);
    }

    private static void getDistinctPathByVoidRecursion(int i, int j, int count[]){
        if (i==m-1 || j==n-1){
            count[0]++;
            return;
        }
        getDistinctPathByVoidRecursion(i, j+1, count);
        getDistinctPathByVoidRecursion(i+1, j, count);
    }
    private static int getDistinctPathByRecursion(int i, int j) {
       if (i == m-1 || j == n-1){
           return 1;
       }
       return getDistinctPathByRecursion(i,j+1) + getDistinctPathByRecursion(i+1, j);
    }

}
