package Sorting.Concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomSorting {
    public static void main(String [] args){
//        Custom Sorting
//        We have been given 2 strings ‘S’ and ‘T’ both containing lowercase alphabets only. We have to sort characters
//        of ‘T’ based on the order of characters in ‘S’ given that all the characters in ‘S’ are distinct.
//        Input: S = “cba”
//               T = “abcd”
//        Output: T = “cbad”
//
//        Approach:
//        We can create an array - rank[26] to store the ranks of all 26 characters according to the string S.
//        For characters that do not occur in S, we can give them a rank of infinity i.e. INT_MAX.
//        We can initialise a vector of pairs containing characters of string T and their rankThe pairs can be
//        passed to the custom comparator to define the sorting rule according to the given problem statement.

        sortTBasedOnCharInS("cba", "abcd");
    }

    static class Pair {
        char c;
        int rank;
    }

    private static void sortTBasedOnCharInS(String S, String T) {
        //init rank array
        int[] rank = new int[26];
        Arrays.fill(rank, Integer.MAX_VALUE);//init all value with int_max for char not present in S but in T

        //update rank for char in S
        for (int i=0; i<S.length(); i++){
            rank[S.charAt(i) - 'a'] = i;
        }

        //data structure for comparator to sort based on rank
        List<Pair> vec = new ArrayList<>();

        for (int i=0; i<T.length(); i++){
            Pair p = new Pair();
            p.c = T.charAt(i);
            p.rank = rank[T.charAt(i) - 'a'];
            vec.add(p);
        }

        //sort the list
        vec.sort((p1, p2) -> {
            if (p1.rank < p2.rank){
                return -1;
            }else if (p2.rank > p1.rank){
                return 1;
            }else {
                return 0;
            }
        });

        String ans = "";
        for (int i=0; i<vec.size(); i++){
            ans += vec.get(i).c;
        }
        System.out.println(ans);
    }
}
