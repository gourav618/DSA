package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RainWaterTrapping {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=2&sectionId=1&moduleId=1&topicId=1&subtopicId=6&assignmentId=1

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        List<Long> height = Arrays.stream(s.nextLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());

        //prefix max
        long[] pm = new long[n];
        pm[0] = height.get(0);
        for (int i=1; i<n; i++){
            pm[i] = Math.max(pm[i-1], height.get(i));
        }

        //suffix max
        long[] sm = new long[n];
        sm[n-1] = height.get(n-1);
        for (int i=n-2; i>=0; i--){
            sm[i] = Math.max(sm[i+1], height.get(i));
        }

        long ans = 0;
        //ignore 1st and last pillar
        for (int i=1; i<n-1; i++){
            long decidingHt = Math.min(pm[i - 1], sm[i + 1]);
            if (decidingHt > height.get(i)){
                ans += Math.max(0, decidingHt-height.get(i));
            }
        }
        System.out.println(ans);
    }
}
