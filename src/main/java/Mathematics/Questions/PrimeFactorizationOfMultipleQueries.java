package Mathematics.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PrimeFactorizationOfMultipleQueries {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/practice/question?questionId=31&sectionId=1&moduleId=1&topicId=2&subtopicId=25&assignmentId=5

        //Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] spf = getSmallestPrimeFactorForEveryNo();
        for (int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            getPrimeFactorization(N, spf);
        }
    }

    private static void getPrimeFactorization(int n, int[] spf) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (spf[n] != -1){
            map.put(spf[n], map.getOrDefault(spf[n], 0)+1);
            n = n/spf[n];
        }
        if (n != 1){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        for (Map.Entry<Integer, Integer> mapElem : map.entrySet()){
            System.out.println(mapElem.getKey()+" "+mapElem.getValue());
        }
    }

    private static int[] getSmallestPrimeFactorForEveryNo() {
        int max = 1000000;
        int [] spf = new int[max+1];
        Arrays.fill(spf, -1);

        for (long i=2; i*i <= max; i++){
            if (spf[(int) i] == -1){
                for (long j=i; i*j <= max; j++){
                    if (spf[(int) (i*j)] == -1){
                        spf[(int) (i*j)] = (int) i;
                    }
                }
            }
        }
        return spf;
    }
}
