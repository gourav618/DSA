package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AlyonaAndFlowers {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=7&sectionId=1&moduleId=1&topicId=1&subtopicId=6&homeworkId=1

        Scanner s = new Scanner(System.in);
        List<Integer> nM = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        //prefix sum
        int []ps = new int[nM.get(0)];
        ps[0] = arr.get(0);
        for (int i=1; i< nM.get(0); i++){
            ps[i] = ps[i-1] + arr.get(i);
        }

        int ans = 0;
        for (int i=0; i< nM.get(1); i++){
            List<Integer> choices = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            int l = choices.get(0) == 1 ? 0 : choices.get(0)-1;
            int r = choices.get(1) == 1 ? 0 : choices.get(1)-1;

            int subArrSum = l == 0 ? ps[r] : ps[r] - ps[l-1];

            if (subArrSum > 0){
                ans += subArrSum;
            }
        }
        System.out.println(ans);
    }
}
