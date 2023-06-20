package Sorting.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CustomSortString {
    public static void main(String[] args){
        //https://leetcode.com/problems/custom-sort-string/

        String order = "cba";
        String s = "abcd";

        System.out.println(customSortString(order, s));

    }

    static class Pair {
        char ch;
        int rank;
    }
    private static String customSortString(String order, String s) {
        int[] rank = new int[26];
        Arrays.fill(rank, Integer.MAX_VALUE);

        for (int i=0; i< order.length(); i++){
            rank[order.charAt(i)-'a'] = i;
        }

        List<Pair> vector = new ArrayList<>();
        for (int i=0; i<s.length(); i++){
            Pair p = new Pair();
            p.ch = s.charAt(i);
            p.rank = rank[s.charAt(i)-'a'];
            vector.add(p);
        }

        vector.sort(Comparator.comparingInt(c -> c.rank));
        StringBuilder sb = new StringBuilder();
        for (Pair p : vector){
            sb.append(p.ch);
        }
        return sb.toString();
    }
}
