package Sorting.Concept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolveTheEquation {
    public static void main(String[] args){
//        Solve the Equation
//        We have been given an integer array Arr[N] containing distinct elements and we have to find the number of
//        sextuples satisfying the equation - (a*b+c)/d-e = f. Here, one element can play the role of multiple variables.
//
//        Input: Arr[1] = {1}
//        Output: 1 i.e. {1, 1,1,1,1,1}
//
//        Approach:
//
//        Brute Force - We can run six nested loops to generate all the possible combinations and check if they satisfy
//        the given equation or not.
//                Time complexity: O(N^6)
//        Note: We may encounter an edge case of 0/0, hence discard all combinations containing d=0.
        int []arr = {2, 3};
        solveEquationBruteForce(arr);

        //Better approach
//        We can rearrange the given equation to a*b+c = (f+e)*d. Now, we can separately find all the possible values of
//        LHS and RHS and store them in a vector LHSArr[N^3] and RHSArr[N^3].
//        Time complexity: O(N^3) ∵ There are total N^3 combinations for both LHS and RHS
//
//        The equation will be satisfied only when LHS=RHS, thus we can iterate on the vector containing the values of
//        LHS and use sorting and binary search to find the frequency of the value in RHS.
//
//        Time complexity for sorting RHSArr[N^3] = O(N^3logN)
//        Time complexity for iterating LHSArr[N^3] = O(N^3)
//        Time complexity for applying binary search on RHSArr[N^3] = O(log2N)
//
//        Overall Time complexity: O(N^3logN)
//        Space complexity: O(N^3)
//
//        Note: Do not forget to reject the values in RHS when d=0
        solveEquationUsingSorting(arr);
        
        solveEquationUsingHashMap(arr);
    }

    private static void solveEquationUsingHashMap(int[] arr) {
        HashMap<Integer, Integer> lhsMap = new HashMap<>();
        HashMap<Integer, Integer> rhsMap = new HashMap<>();
        //init lhs array
        for (int i=0; i<arr.length; i++){ //a
            for (int j=0; j<arr.length; j++){ //b
                for (int k=0; k<arr.length; k++){ //c
                    int key = (arr[i] * arr[j]) + arr[k];
                    if (lhsMap.containsKey(key)){
                        lhsMap.put(key, lhsMap.get(key)+1);
                    }else {
                        lhsMap.put(key, 1);
                    }
                }
            }
        }

        //init rhs array
        for (int i=0; i<arr.length; i++){ //d
            for (int j=0; j<arr.length; j++){ //e
                for (int k=0; k<arr.length; k++){ //f
                    if (arr[i] != 0) {
                        int key = arr[i]*(arr[j]+arr[k]);
                        if (rhsMap.containsKey(key)) {
                            rhsMap.put(key, rhsMap.get(key)+1);
                        } else {
                            rhsMap.put(key, 1);
                        }
                    }
                }
            }
        }

        int count = 0;
        for (Integer key : lhsMap.keySet()){
            if (rhsMap.get(key) != null){
                count += lhsMap.get(key)*rhsMap.get(key);
            }
        }
        System.out.println(count);
    }

    private static void solveEquationUsingSorting(int[] arr) {
        //a*b+c = (f+e)*d
        List<Integer> lhsArr = new ArrayList<>();
        List<Integer> rhsArr = new ArrayList<>();

        //init lhs array
        for (int i=0; i<arr.length; i++){ //a
            for (int j=0; j<arr.length; j++){ //b
                for (int k=0; k<arr.length; k++){ //c
                    lhsArr.add( (arr[i]*arr[j])+arr[k] );
                }
            }
        }

        //init rhs array
        for (int i=0; i<arr.length; i++){ //d
            for (int j=0; j<arr.length; j++){ //e
                for (int k=0; k<arr.length; k++){ //f
                    if (arr[i] != 0) { //since division by 0 would led to infinity
                        rhsArr.add( arr[i]*(arr[j]+arr[k]) );
                    }
                }
            }
        }

        //sort rhs array
        rhsArr.sort(Integer::compareTo);

        int count = 0;

        for (int i=0; i<lhsArr.size(); i++){
            int firstOccurrenceOfKey = getFirstOccurrenceOfKey(lhsArr.get(i), rhsArr);
            int lastOccurrenceOfKey = getLastOccurrenceOfKey(lhsArr.get(i), rhsArr);

            if (firstOccurrenceOfKey !=-1 || lastOccurrenceOfKey != -1) {
                count += lastOccurrenceOfKey - firstOccurrenceOfKey+1;
            }
        }

        System.out.println(count);
    }

    private static int getLastOccurrenceOfKey(int key, List<Integer> arr) {
        int l = 0, h = arr.size()-1;
        while (l<=h){
            int m = (l+h)/2;

            if (arr.get(m) > key){
                h = m-1;
            }
            else if (arr.get(m) < key){
                l = m+1;
            }
            else {//arr[m] == key
                if (m == arr.size()-1){
                    return m;
                }
                else if (arr.get(m+1) != key){
                    return m;
                }
                else {//move to right since last occurrence would be on right
                    l = m+1;
                }
            }
        }
        return -1; //key not found
    }

    private static int getFirstOccurrenceOfKey(int key, List<Integer> arr) {
        int l = 0, h = arr.size()-1;
        while (l<=h){
            int m = (l+h)/2;

            if (arr.get(m) > key){
                h = m-1;
            }
            else if (arr.get(m) < key){
                l = m+1;
            }
            else {//arr[m] == key
                if (m == 0){
                    return m;
                }
                else if (arr.get(m-1) != key){
                    return m;
                }
                else { //move to left since 1st occurrence would be on left
                    h = m-1;
                }
            }
        }
        return -1; //key not found
    }

    private static void solveEquationBruteForce(int[] arr) {
        int count = 0, N = arr.length;
        for (int i=0; i<N; i++){ //a
            for (int j=0; j<N; j++){ //b
                for (int k=0; k<N; k++){ //c
                    for (int l=0; l<N; l++){ //d
                        for (int m=0; m<N; m++){ //e
                            for (int n=0; n<N; n++){ //f
                                if (arr[l] != 0){ //since division by 0 would led to infinity
                                    boolean b = (((arr[i] * arr[j]) + arr[k]) / (double)arr[l]) - arr[m] == arr[n]; // double for arithmetic division
                                    if (b){
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
