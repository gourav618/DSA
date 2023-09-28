package BitManipulation.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class InfiniteOrGame {
    public static void main(String[] args) throws IOException {
        //https://www.codechef.com/problems/LIKECS03?tab=statement

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t >= 1) {
            t--;
            int[] limits = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = limits[0], k = limits[1];

            int[] arr = new int[n];

            arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Map<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int i = 0; i < n; i++) {
                map.put(arr[i], 1);
            }
            int count = 0;
            int mask = 1;
            for (int i = 1; i <= k; i++) {

                if (!map.containsKey(mask)) {
                    count++;
                }

                mask <<= 1;
            }

            System.out.println(count);
        }
    }
}
