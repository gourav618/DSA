package Searching.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SagheerAndNubianMarket {
    public static void main(String[] args) throws IOException {
        //https://codeforces.com/problemset/problem/812/C
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        Long[] line1 = Arrays.stream(s.readLine().split(" ")).map(Long::parseLong).toArray(Long[]::new);
        long n = line1[0], budget = line1[1];
        Long[] items = Arrays.stream(s.readLine().split(" ")).map(Long::parseLong).toArray(Long[]::new);
        long low=0, high = n, k = 0, cost = 0;
        while (low<=high){
            long mid = low + (high-low)/2;
            long spent = ifPossible(items, n, budget, mid);
            if (spent > budget){
                high = mid-1;
            }else {
                if (mid == n){
                    k = mid;
                    cost = spent;
                    break;
                }else {
                    long spent1 = ifPossible(items, n, budget, mid + 1);
                    if (spent1 > budget) {
                        k = mid;
                        cost = spent;
                        break;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        System.out.println(k+" "+cost);
    }

    private static long ifPossible(Long[] items, long n, long budget, long mid) {
        long[] prices = new long[(int) n];
        for (int i=0; i<n; i++){
            prices[i] = items[i] + ((i+1)*mid);
        }
        Arrays.sort(prices);
        long sum = 0;
        for (int i=0; i<mid; i++){
            sum += prices[i];
        }
        return sum;
    }
}
