package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MajorityElement2 {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=24&sectionId=1&moduleId=1&topicId=1&subtopicId=14&homeworkId=3

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();

        for (int i=0; i<T; i++){
            int N = s.nextInt();
            s.nextLine();
            List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            System.out.println(findMajority(N, arr));
        }
    }

    private static String findMajority(int n, List<Integer> arr) {
        int count1 = 0, count2 = 0;
        int flag = 0;

        int first = Integer.MIN_VALUE, second = Integer.MAX_VALUE;

        for (int i=0; i<n; i++){
            //if elem is seen previously
            if (first == arr.get(i))
                count1++;

            else if (second == arr.get(i))
                count2++;

            else if (count1 == 0){
                count1++;
                first = arr.get(i);
            } else if (count2 == 0) {
                count2++;
                second = arr.get(i);
            }
            //if elem diff from both prev elem decrement both
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        //again traverse and update the actual count
        for (int i=0; i<n; i++){
            if (arr.get(i) == first){
                count1++;
            } else if (arr.get(i) == second) {
                count2++;
            }
        }

        String ans = "";
        if (count1 > n/3){
            ans += first;
            flag = 1;
        }
        if (count2 > n/3){
            if (count1 > n/3) {
                if (second < first)
                    ans = second + " " + ans;
                else
                    ans = ans + " " + second;
            }else {
                ans += second;
            }
            flag = 1;
        }
        if (flag == 0)
            ans += "-1";

        return ans;
    }
}
