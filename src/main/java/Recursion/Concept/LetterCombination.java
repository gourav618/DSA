package Recursion.Concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombination {
    public static void main(String [] args){
    //    We have been given a string containing digits from 2-9 inclusive and we have to return all possible letter combinations
        //    that the digit string could represent. The digits have been mapped to letters similar to the telephone buttons with 1 being mapped to none of the letters.

        letterComb("237");

//        In the previous approach, for every function call, we were creating a new string to store the letter combinations
//        because of which our program was space inefficient. Can you think of any alternative?

//        We can create a character array - char tmp[digits.length()+1] and pass it by reference. And we can take the help of
//        overwriting to find the desired letter combinations within the same character array.
//                Space complexity: O(digits.length( ))
        System.out.println();
        letterCombSavingSpace("237");


    }

    private static void letterCombSavingSpace(String digits) {
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
        char[] tmp = new char[digits.length()];
        printAllCombsSavingSpace(tmp, digits, 0, digitMap);
    }

    private static void printAllCombsSavingSpace(char[] tmp, String digits, int i, List<List<Character>> digitMap) {
        if (i >= digits.length()){
            for (int k=0; k< tmp.length; k++){
                System.out.print(tmp[k]);
            }
            System.out.print(" ");
            return;
        }
        for (int j=0; j<digitMap.get(digits.charAt(i) - '2').size(); j++){
            tmp[i] = digitMap.get(digits.charAt(i) - '2').get(j);
            printAllCombsSavingSpace(tmp, digits, i+1, digitMap);
        }
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
