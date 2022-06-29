package Recursion.Concept;

public class DivideAndConquer {
    public static void main(String[] args){
//        Divide and Conquer is an algorithmic paradigm where we divide a certain problem into several subproblems and recursively solve these subproblems.
//        Once we get the result of the smaller subproblems, we start combining them to get the final result. Let us understand this concept with the help of a problem.


//        Q. Find the maximum element in Arr[N] = [7, 1, 4, 3, 2, 6, 5] through Recursion.
//        Approach:
//        We can divide the Arr[ ] into two parts from the middle and can separately find the maximum elements of the two halves.
//        We can later compare the two maximas to find the overall maximum.
//        On the above logic, we can further divide the parts into two parts so that we have the smallest subproblem whose answer is already known to us.
//        In the given question, we can break a subarray with i=starting index and j=ending index into two halves - left(i,m) & right(m+1, j) where m=(i+j)/2.
//        Then we can start solving the subproblems and return their maximum after every call.
//        Recurrence Relation: return max(findMax(i,m), findMax(m+1,j)):
//        Termination Condition: if(i==j) return Arr[ i ];
//        Since it is the only element left in the array when i becomes equal to j.
//
//        Time complexity: O(N)
//        Space complexity: Maximum size of call stack = O(log2N)
        int[] arr = {7,1,4,3,2,6,5};
        int max = findMax(0, arr.length - 1, arr);
        System.out.println(max);


        // find sum of array using divide and conquer
        int sum = findSum(0, arr.length - 1, arr);
        System.out.println(sum);

    }

    private static int findSum(int i, int j, int[] arr) {
        // termination
        if (i == j){
            return arr[i];
        }

        int mid = (i+j)/2;
        int s1 = findSum(i, mid, arr);
        int s2 = findSum(mid + 1, j, arr);
        return s1+s2;
    }

    private static int findMax(int i, int j, int[] arr) {
        // termination
        if (i == j){
            return arr[i];
        }
        // divide the problem in sub problem
        int mid = (i+j)/2;
        int m1 = findMax(i, mid, arr);
        int m2 = findMax(mid+1, j, arr);
        //conquer the result by finding max of sub problem
        return Math.max(m1, m2);
    }
}
