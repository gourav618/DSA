package Sorting.Concept;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MaximizeTheIndexDifference {
    public static void main(String[] args){
//        Maximize the Index Difference
//        We have been given an integer array Arr[N] and we have to find the maximum value of (j - i) such that a[ j ] >= a[ i ] and i ≠ j, without tampering the original array.
//
//        Input: Arr[7] = {5, 2, 6, 4, 4, 3, 1}
//        Output: 4   (i = 1, j = 5)
//
//        Approach:
//
//        Brute Force - We can check the differences of all the pairs to find the maximum value of (j - i) such that Arr[ j ] >= Arr[ i ].
//        Time complexity: O(N^2)
//        Note: - The answer can also be negative, so initialize the answer variable with INT_MIN instead of zero. - The minimum possible answer is -1.
        int []arr = {5,2,6,4,4,3,1};
        maximizeBruteForce(arr);

//        We can create a vector of pairs containing Arr[ i ] and ‘i’ and sort it in ascending order. After that, we can calculate the suffix max of the indices and find their differences to get the desired answer.
//        Note: There is an edge case.
//        The in-built sort function doesn’t maintain stability while sorting. Therefore we need to use a comparator function for stable sorting.
//
//        Time complexity: O(Nlog2N)
//        Space complexity: O(N)
        maximizeOptimalApproach(arr);
    }

    private static void maximizeBruteForce(int[] arr) {
        int ans = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++){ // fix i
            for (int j=0; j<arr.length; j++){ // check for each value of j and maximize the ans
                if (j != i && arr[j] >= arr[i]){
                    ans = Math.max(ans, j-i);
                }
            }
        }
        System.out.println(ans);
    }

    private static void maximizeOptimalApproach(int[] arr) {
        List<List<Integer>> vec = new ArrayList<>();
        //push arr elem with its index
        for (int i=0; i< arr.length; i++){
            List<Integer> elem = new ArrayList<>();
            elem.add(arr[i]);
            elem.add(i);
            vec.add(elem);
        }

        //sort the vec with its value remembering the index
        vec.sort((p1, p2) -> {
            if (p1.get(0) < p2.get(0)) {
                return -1;
            } else if (p1.get(0) > p2.get(0)) {
                return 1;
            } else {
                return 0;
            }
        });

        int ans = Integer.MIN_VALUE, suffix_max = vec.get(vec.size()-1).get(1);
        for (int i=vec.size()-2; i>=0; i--){
            ans = Math.max(ans, suffix_max - vec.get(i).get(1));
            suffix_max = Math.max(suffix_max, vec.get(i).get(1));
        }
        System.out.println(ans);
    }
}
