package Recursion.Concept;

public class LexicoGraphicSubSet {
    public static void main(String[] args){
//        Lexicographic Subsets
//        The subsets of a set if arranged in ascending order are called lexicographic subsets. In this lecture, we will see how we can print the subsets of a set in lexicographic order with the help of recursion.
//
//        SS1: xyzp...
//        SS2: xyzq...
//
//        then  SS1>SS2  if p>q
//              SS1<SS2  if p<q
//
//        Input: N=3, S=[1, 2, 3]
//        Output: {1,2,3}: [ ], [1], [1 2], [1 2 3], [2], [2 3], [3]
//
//        Approach:
//
//        We can create a vector of vectors & store all the subsets. We can then sort them in lexicographic order.
//        Disadvantage: Extra space complexity & high time complexity
//        If the first element of a subset is shorter than the first element of another subset, then all the subsets starting
//        with the first element will be lexicographically smaller as compared to the second element.
//        For S={1,2,3}
//                [ ] < [1..] < [2..] < [3..]
//
//        Time complexity: O(2^N)
        int arr[] = {1,2,3,4};
        int aux[] = new int[arr.length];
        printAllSubsetLexicographically(aux, 0, 0, arr);
    }

    private static void printAllSubsetLexicographically(int[] aux, int size, int i, int[] arr) {
        //print content of array
        for (int k=0; k<size; k++){
            System.out.print(aux[k]+" ");
        }
        System.out.println();
        //terminate
        if (i == arr.length){
            return;
        }
        // call all other subset
        for (int j=i; j< arr.length; j++){
            aux[size] = arr[j];
            printAllSubsetLexicographically(aux, size+1, j+1, arr);
        }
    }
}
