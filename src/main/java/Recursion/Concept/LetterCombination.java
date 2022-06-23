package Recursion.Concept;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void main(String [] args){
    //    We have been given a string containing digits from 2-9 inclusive and we have to return all possible letter combinations
        //    that the digit string could represent. The digits have been mapped to letters similar to the telephone buttons with 1 being mapped to none of the letters.

        letterComb("237");

    }

    private static void letterComb(String digits) {
        List<List<Character>> digitMap = new ArrayList<>();
        digitMap.add(List.of('a', 'b', 'c'));
        digitMap.add(List.of('d','e','f'));
        digitMap.add(List.of('g','h','i'));
        digitMap.add(List.of('j','k','l'));
        digitMap.add(List.of('m','n','o'));
        digitMap.add(List.of('p','q','r','s'));
        digitMap.add(List.of('t','u','v'));
        digitMap.add(List.of('w','x','z'));
        //if digit string is 0 then no possible combination
        if (digits.length() == 0){
            return ;
        }
        //initial call to recursion function for level 0
        printAllCombs("", digits, 0, digitMap);
    }

    private static void printAllCombs(String tmp, String digits, int i, List<List<Character>> digitMap) {
        // when reaches to last elem in digit string then terminates
        if (i >= digits.length()){
            System.out.print(tmp+" ");
            return;
        }
        // make a call for each possible selection in that level
        for (int j=0; j< digitMap.get(digits.charAt(i) - '2').size(); j++){
            printAllCombs(tmp + digitMap.get(digits.charAt(i) - '2').get(j), digits, i+1, digitMap);
        }
    }
}
