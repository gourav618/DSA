package Bactracking.Concept;

public class PermutationOfStringWithRepeatedChar {
    public static void main(String[] args){
//       Permutations of a String - 3
//        we will discuss an advanced version of the “Permutation of a String” problem. Here, we have been given a string ‘s’
//        with non-distinct characters and we have to print all its permutations.
//
//     If ‘N’ is the length of a string and ‘a’, ‘b’ is the no. of repetitions of two different characters then the no. of permutations will be = N!/(a!*b!)
//
//        Eg. For s=”ababc”
//        Number of Permutations = 5!/(2!*2!) = 30
//
//        Approach:
//
//        What problem can arise if we follow the approach used in the previous two lectures?
//
//        It can lead to repetitions as evident from the below recursion tree diagram. The repetitions occur in two cases:
//
//        If we are swapping a character with itself. Eg. Node 1 & 3.
//        In Node 3 we swapped ‘a’ with ‘a’, thus leading to the same left(‘a’) & right(P(“bab”)) halves and the same set of permutations later on.
//                If we are swapping the current index with the same character that we had swapped it earlier with.
//                Eg. Node 2 & 4. In Node 2 we swapped ‘a’ with ‘b’ & in node 4 we again swapped ‘a’ with ‘b’, thus
//                leading to the same left(‘b) & right halves and the same set of permutations later on.
//        How same right halves? Since, P(“aab”) = P(“baa”) = {“baa”, “aba”, “aab”}
//        Backtracking
//        Therefore we have to account for the above two cases while writing the code. To implement this, we can maintain an
//        array to keep track of all the swapped characters and we can swap s[‘i’] with s[‘j’] only if(frequency[s[j]-’a’]==0).
//        After swapping we can increment the frequency of s[‘j’] so that the same character is not swapped again at its future occurrences.
        StringBuilder s = new StringBuilder("aba");
        permute(s, 0);
    }

    private static void permute(StringBuilder s, int i) {
        if (i == s.length()-1){
            System.out.println(s);
            return;
        }
        // to check if the char are already swapped
        int[] freq = new int[26];
        for (int j=i; j<s.length(); j++){
            if (freq[s.charAt(j)-'a'] == 0){
                swap(i, j, s);
                permute(s, i+1);
                swap(i, j, s);
            }
            //increment if ith char is already swapped with jth
            freq[s.charAt(j)-'a']++;
        }
    }

    private static void swap(int i, int j, StringBuilder s) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }
}
