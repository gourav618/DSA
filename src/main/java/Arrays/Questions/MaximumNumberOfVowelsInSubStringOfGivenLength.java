package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaximumNumberOfVowelsInSubStringOfGivenLength {

    private static final String SEARCH = "aeiou";

    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=14&sectionId=1&moduleId=1&topicId=1&subtopicId=11&homeworkId=2

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();

        for (int i=0; i<T; i++){
            List<String> string = Arrays.stream(s.nextLine().split(" ")).collect(Collectors.toList());
            String S = string.get(0);
            int K = Integer.parseInt(string.get(1));

            System.out.println(findMaximumNumberOfVowel(S, K));
        }
    }

    private static int findMaximumNumberOfVowel(String s, int k) {

        //calculate vowels in first window
        int count = 0;
        for (int i=0; i<k; i++){
            if (SEARCH.contains(s.charAt(i)+"")){
                count++;
            }
        }

        int max_count = Integer.MIN_VALUE;
        for (int i=k; i<s.length(); i++){
            max_count = Math.max(max_count, count);

            if (SEARCH.contains(s.charAt(i)+"")){
                count++;
            }

            if (SEARCH.contains(s.charAt(i-k)+"")){
                count--;
            }
        }

        max_count = Math.max(max_count, count);

        return max_count;
    }
}
