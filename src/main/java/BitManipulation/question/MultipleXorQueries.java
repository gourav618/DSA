package BitManipulation.question;

import java.util.Arrays;

public class MultipleXorQueries {
    public static void main(String[] args){
        //https://leetcode.com/problems/xor-queries-of-a-subarray/description/

        int[] arr = {1,3,4,8};
        int[][] queries = {{0,1},{1,2},{0,3},{3,3}};

        int[] xorQueries = xorQueries(arr, queries);
        System.out.println(Arrays.toString(xorQueries));
    }

    private static int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];

        //calculate prefix xor of array
        int[] prefixXor = new int[arr.length];
        prefixXor[0] = arr[0];
        for (int i=1; i< arr.length; i++){
            prefixXor[i] = (prefixXor[i-1] ^ arr[i]);
        }

        //process the queries using prefix calculation
        for (int q=0; q< queries.length; q++){
            int i = queries[q][0], j = queries[q][1];
            if (i == 0){
                res[q] = prefixXor[j];
            }
            else {
                res[q] = prefixXor[j] ^ prefixXor[i-1];
            }
        }
        return res;
    }
}
