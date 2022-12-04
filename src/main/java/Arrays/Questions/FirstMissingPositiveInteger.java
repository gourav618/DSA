package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FirstMissingPositiveInteger {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=22&sectionId=1&moduleId=1&topicId=1&subtopicId=14&homeworkId=3

        Scanner s  = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();

        for (int i=0; i<T; i++){
            int N = s.nextInt();
            s.nextLine();
            List<Long> arr = Arrays.stream(s.nextLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());
            System.out.println(findSmallestPositiveInteger(N, arr));
        }
    }

    private static int findSmallestPositiveInteger(int n, List<Long> arr) {
        //use original array as hashset i.e mark index i to n as -ve if elem present else n+1 answer

        //remove all -ve no to 0 since it doesn't matter to the ans
        for (int i=0; i<n; i++){
            if (arr.get(i) < 0)
                arr.set(i, 0L);
        }

        //mark the elem 1 to n as -ve if present
        for (int i=0; i<n; i++){
            long val = Math.abs(arr.get(i));
            //if val lie in our ans range [1...n+1] mark arr[val-1] as -ve Edge case : if arr[val-1] then -1*(n+1)
            if (1 <= val && val <= n){
                if (arr.get((int) (val-1)) > 0)
                    arr.set((int) (val-1), arr.get((int) (val-1))* -1);
                else if (arr.get((int) (val-1)) == 0)
                    arr.set((int) (val-1), (long) ((n+1) * -1));
            }
        }

        //traverse from 1 to n if any value >=0 then ans else n+1 ans
        for (int i=1; i<n+1; i++){
            if (arr.get(i-1) >= 0)
                return i;
        }
        return n+1;
    }
}
