package Arrays.Concept;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessingQueriesEfficiently {

    public static void main(String [] args){

        // a matrix of m*n i.e 2d
        // given Q queries, every query will contain 4 int -> i1, j1, i2, j2  -> rep sub-matrix in 2d matrix
        //for each submatrix print the sum of that submatrix

        int arr[][] = {{1,2,3},{4,5,6},{2,0,1}};
        String Q = "0,1,1,2"; //can be any no of queries
        List<Integer> queries = Arrays.stream(Q.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //byBruteForce
        // there qre Q queries and each query take o(m*n) -> total time taken o(Q*m*n)
        findSumByBruteForce(arr, queries);

        //using prefix max method in 2d
        //here we change the value of each index considering it as bottom right , and find the sum of that sub matrix
        // we can do this in steps -> step 1: do row wise prefix sum || step 2: column wise prefix sum
        // ex : arr[{a b c}{d e f}{g h i}] : step 1 -> [{a a+b a+b+c} {d d+e d+e+f} {g g+h g+h+i}]
//                                             step 2 -> [{a a+b a+b+c} {a+d a+b+d+e a+b+c} {a+d+g a+b+d+e+g+h a+b+c+g+h+i}]
//                                             ---> this is the sum of that sub matrix considerring it has bottom right  --> o(m*n)
        // since now we have sum of submatrix for i,j as bottom right of sub matrix
        // we can do it by getting sum of sumMatrix[i2][j2] - sumMatrix[i1-1][j2] [area 1 top] - sumMatrix[i2][j1-1] [area 2 left]
        // and add the part i.e common area  which got subtracted twice i.e  sumMatrix[i1-1][j1-1]
        // when ask for query-> i1 j1 i2 j2 , we can pick sumMatrix[i2][j2] - sumMatrix[i1-1][j2]- sumMatrix[i2][j1-1] + sumMatrix[i1-1][j1-1]
        // above computation can be done in o(1) time i.e total time o(m*n + Q)
        int[][] prefixSumOfSubMatrrix = getPrefixSumOfSubMatrrix(arr);
        findSumByPrefixMax2DArray(prefixSumOfSubMatrrix, queries);

    }

    // constant time for each query
    // for Q query o(m*n + Q)
    private static void findSumByPrefixMax2DArray(int[][] prefixSumOfSubMatrrix, List<Integer> queries) {
        int sum = prefixSumOfSubMatrrix[queries.get(2)][queries.get(3)];
        if (queries.get(1) -1 >= 0){
            sum -= prefixSumOfSubMatrrix[queries.get(2)][queries.get(1)-1];
        }
        if (queries.get(0)-1 >= 0){
            sum -= prefixSumOfSubMatrrix[queries.get(1)-1][queries.get(3)];
        }
        if (queries.get(0)-1 >= 0 && queries.get(1) -1 >= 0){
            sum += prefixSumOfSubMatrrix[queries.get(0)-1][queries.get(1) -1];
        }
        System.out.println(sum);
    }

    //o(m*n + m*n) -> o(2m*n) ~ o(m*n)
    private static int[][] getPrefixSumOfSubMatrrix(int[][] arr) {
        int prefixArray[][] = new int [arr.length][arr[0].length];
        // step 1: do row wise prefix sum o(m*n)
        for (int i = 0; i< arr.length; i++){
            prefixArray[i][0] = arr[i][0];
            for (int j = 1; j< arr[0].length; j++){
                prefixArray[i][j] = prefixArray[i][j-1] + arr[i][j];
            }
        }
        //step 2: column wise prefix sum o(m*n)
        for (int i = 0; i< arr[0].length; i++){
            for (int j = 1; j< arr.length; j++){
                prefixArray[j][i] = prefixArray[j-1][i] + prefixArray[j][i];
            }
        }
        return prefixArray;
    }

    // time 0(m*n)
    private static void findSumByBruteForce(int[][] arr, List<Integer> queries) {
        int sum = 0;
        for (int i = queries.get(0); i<= queries.get(2); i++){
            for (int j = queries.get(1); j<= queries.get(3); j++){
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }
}
