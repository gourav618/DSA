package Mathematics.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DivisiblePairs {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=45&sectionId=1&moduleId=1&topicId=2&subtopicId=30&assignmentId=6

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();

        while (T-- > 0){
            int N = s.nextInt();
            s.nextLine();
            List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            int k = 4;
            //store count of remainder from arr
            int []count = new int[k];
            for (int i=0; i<N; i++){
                count[arr.get(i) % 4]++;
            }
            //handle count of bucket
            int ans = count[0] * (count[0]-1)/2; //0th bucket case
            for (int i=1; i<=(k/2 - 1); i++){
                ans += count[i] * count[k-i];
            }
            //since k is 4 and will have 1 bucket in mid
            ans += count[k/2] * (count[k/2]-1)/2;

            System.out.println(ans);
        }
    }
}
