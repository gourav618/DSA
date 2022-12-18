package Mathematics.Questions;

import java.util.*;
import java.util.stream.Collectors;

public class EquallyDistributedGroup {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=34&sectionId=1&moduleId=1&topicId=2&subtopicId=19&homeworkId=4

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();
        for (int i=0;i<T; i++){
            int N = s.nextInt();
            s.nextLine();
            List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            boolean b = canBeEquallyDistributed(arr, N);
            System.out.println(b ? "true" : "false");
        }
    }

    private static boolean canBeEquallyDistributed(List<Integer> arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int gcd = 0;
        for(int i : map.values()){
            if (gcd == 0)gcd=i;
            else gcd = getGcd(i, gcd);
        }
        return gcd != 1;
    }

    private static int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a%b);
    }
}
