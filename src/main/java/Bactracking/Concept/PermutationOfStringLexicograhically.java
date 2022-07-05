package Bactracking.Concept;

public class PermutationOfStringLexicograhically {
    public static void main(String[] args){
//       Permutations of a String - 2
//        In this lecture, we will consider another version of the previous problem, here we are given a string ‘s’ and we need to print all the permutations of that string in lexicographic order.
//
//        Lexicographic order also known as lexical order is generally the ascending order of strings based on the characters & symbols.
//
//                Eg. ABC < ACB < BAC < BCA < CAB < CBA
//
//        Approach:
//
//        Use recursion & backtracking to generate all the permutations and store them in a vector. Sort the vector to print all the different permutations in lexicographic order.
//        Time complexity: O(N! + NlogN) = O(N!)
//        Space complexity: O(N!)
//        If we carefully analyse the approach followed in the previous lecture, we got non-lexicographic permutations only in the cases where the portion of the string, rightward to our current index is unsorted. As indicated in the below recursion tree diagram:
//        Recursion Tree
//        As evident from the above diagram, we need to sort the array from index ‘i+1’ to ‘j’ after swapping s[i] & s[j]. Is there a better way to do it?
//
//                Since we know that the initial array is already sorted, we can do it intelligently by right rotating the array elements from ‘i’ to ‘j’ by one unit.
//
//                Do: Right rotate the array by one unit
//        Recurse: Permute(s, i+1);
//        Undo: Left rotate the array by one unit
//
//        Previous: ...a b c d e f…
//        Now: ...e a b c d f...
//        This way we can easily print all the permutations in lexicographic order.

        // the origin string should be sorted too
        StringBuffer s = new StringBuffer("ABC");
        permute(s, 0);
    }

    private static void permute(StringBuffer s, int i) {
        if (i == s.length()-1){
            System.out.println(s);
            return;
        }
        for (int j=i; j< s.length(); j++){
            rightRotate(i, j, s);
            permute(s, i+1);
            leftRotate(i, j, s);
        }
    }

    private static void leftRotate(int i, int j, StringBuffer s) {
        char temp = s.charAt(i);
        for (int k=i; k<j; k++){
            s.setCharAt(k, s.charAt(k+1));
        }
        s.setCharAt(j, temp);
    }

    private static void rightRotate(int i, int j, StringBuffer s) {
        char temp = s.charAt(j);
        for (int k=j; k>i; k--){
            s.setCharAt(k, s.charAt(k-1));
        }
        s.setCharAt(i, temp);
    }
}
