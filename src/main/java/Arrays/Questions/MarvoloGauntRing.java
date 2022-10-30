package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MarvoloGauntRing {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=1&sectionId=1&moduleId=1&topicId=1&subtopicId=6&assignmentId=1
//        Sample Input :
//        5 1 2 -3
//        -1 -2 -3 -4 -5
        //Sample Output : 12
        //refer maximize the expression

        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), p = s.nextInt(), q = s.nextInt(), r = s.nextInt();
        s.nextLine();
        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        //prefix max
        long []pm = new long[n];
        pm[0] = (long) arr.get(0) * p;
        for (int i=1; i<n; i++){
            pm[i] = Math.max(pm[i-1], (long) arr.get(i) *p);
        }

        //suffix max
        long []sm = new long[n];
        sm[n-1] = (long) arr.get(n - 1) *r;
        for (int i=n-2; i>=0; i--){
            sm[i] = Math.max(sm[i+1], (long) arr.get(i) *r);
        }

        long ans = Long.MIN_VALUE;
        for (int i=0; i<n;i++){
            ans = Math.max(ans, pm[i]+((long) q *arr.get(i))+sm[i]);
        }
        System.out.println(ans);
    }
}
