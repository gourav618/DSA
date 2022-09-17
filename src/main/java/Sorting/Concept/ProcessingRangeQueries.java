package Sorting.Concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessingRangeQueries {
    public static void main(String [] args){
//        Processing Range Queries
//
//        We have been given an array Arr[N] filled with zeroes and we have to print the final state of the array after
//        processing ‘Q’ queries [i1, j1], [i2, j2],.., [iq, jq]. In each query, we have to add 1 to the array indices from i to j.
//
//        Input: N=7, Arr[ ] = {0, 0, 0, 0, 0, 0, 0}, Q = 2, [2, 5], [3, 4]
//        Output: Arr[ ] = {0,0,1, 2, 2, 1, 1, 0}
//
//        Approach:
//        Brute Force - We can implement the queries individually by using a for loop.
//         Time complexity: O(N*Q)
//
        List<int[]> queries = new ArrayList<>();
        queries.add(new int[]{2,5});
        queries.add(new int[]{3,6});

        bruteForce(8, queries);
//        Optimal approach - Suppose we had queries like i1, i2,.., iq, where ij means we had to add 1 to all the indices
//        from 0 to j. To process such queries efficiently, we can increment the query indices by 1 and can calculate
//        the suffix sum after processing each query.

//        Can we use a similar technique for the given problem?
//        Solution: For every query, we can increment Arr[ j ] by 1 and decrement Arr[i-1] by 1. After processing each
//        query we can calculate the suffix sum of the array to reach the final answer.
//        Time complexity: O(Q+N)
        optimalApproach(8, queries);
    }

    private static void optimalApproach(int N, List<int[]> queries) {
        int []arr = new int[N];

        for (int i=0; i<queries.size(); i++){
            int[] query = queries.get(i);
            //update j to 1
            arr[query[1]]++;
            if (query[0] > 0){
                arr[query[0]-1]--; //update i with -1 if i > 0
            }
        }

        //calculate suffix sum
        for (int i=N-2; i>=0; i--){
            arr[i] += arr[i+1];
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void bruteForce(int N, List<int[]> queries) {
        int []arr = new int[N];

        for (int q=0; q<queries.size(); q++){ // for each queries
            int[] query = queries.get(q);
            for (int k=query[0]; k<=query[1]; k++){ // increment 1 from i to j
                arr[k]++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
