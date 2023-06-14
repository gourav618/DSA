package Searching.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MagicPowder {
    public static void main(String[] args) throws IOException {
        //https://codeforces.com/problemset/problem/670/D1

        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        Long[] total = Arrays.stream(s.readLine().split(" ")).map(Long::parseLong).toArray(Long[]::new);
        long n = total[0], k = total[1];
        Long[] needed = Arrays.stream(s.readLine().split(" ")).map(Long::parseLong).toArray(Long[]::new);
        Long[] has = Arrays.stream(s.readLine().split(" ")).map(Long::parseLong).toArray(Long[]::new);

        long l = 0, h = (long) 1e13, ans = 0;
        while (l<=h){
            long mid = l + (h-l)/2;
            boolean r = isPossible(has, needed, n, k, mid);
            if (!r){
                h = mid-1;
            }else {
                boolean r1 = isPossible(has, needed, n, k, mid + 1);
                if (!r1){
                    ans = mid;
                    break;
                }else {
                    l = mid+1;
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean isPossible(Long[] has, Long[] needed, long n, long k, long mid) {
        long sum =0;
        for(int i=0; i<n; i++){
            long x = has[i] - (needed[i] * mid);
            if (x < 0){
                sum += x;
            }
        }
        return sum + k >= 0;
    }
}
