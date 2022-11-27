package Arrays.Questions;

import java.util.Scanner;

public class PermutationInString {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=15&sectionId=1&moduleId=1&topicId=1&subtopicId=11&homeworkId=2

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();

        for (int i=0; i<T; i++){
            String s1 = s.nextLine();
            String s2 = s.nextLine();

            System.out.println(checkPermutation(s1, s2) ? "True" : "False");
        }
    }

    private static boolean checkPermutation(String s1, String s2) {
        s1 = s1.trim();
        s2 = s2.trim();

        int k = s1.length();

        //if length of s1 > s2
        if (k > s2.length()){
            return false;
        }

        //if both string equal
        if (s1.equals(s2)){
            return true;
        }

        //update freq for s1
        int []freqS1 = new int[26];
        for (int i=0; i<k; i++){
            freqS1[s1.charAt(i)-'a']++;
        }

        //update freq of 1st window in s2
        int []freqS2 = new int[26];
        for (int i=0; i<k; i++){
            freqS2[s2.charAt(i)-'a']++;
        }

        for (int i=k; i<s2.length(); i++){
            //return true if last window was permutation of s1
            boolean b = checkFreq(freqS1, freqS2);
            if (b){
                return true;
            }else {
                freqS2[s2.charAt(i) - 'a']++;
                freqS2[s2.charAt(i - k) - 'a']--;
            }
        }
        //check for last window
        return checkFreq(freqS1, freqS2);
    }

    private static boolean checkFreq(int[] freqS1, int[] freqS2) {
        for (int i=0; i<26; i++){
            if (freqS1[i] != freqS2[i])
                return false;
        }
        return true;
    }
}
