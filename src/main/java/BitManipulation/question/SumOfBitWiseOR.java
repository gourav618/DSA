package BitManipulation.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfBitWiseOR {
    public static void main(String[] args) throws IOException {
        //https://www.hackerrank.com/contests/codeagon/challenges/bob-and-subarray-or

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        long ans = 0, mask = (1L << 31);
        for (int i=31; i>=0; i--){
            int next = n;
            for (int j=n-1; j>=0; j--){
                if ((arr[j] & mask) != 0){
                    next = j;
                }
                ans += ((n-next) * mask);
            }
            mask >>= 1;
        }
        System.out.println(ans);
    }
}
