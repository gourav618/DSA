package Sorting.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ToAddOrNotToAdd {
    public static void main(String[] args) throws IOException {
        //https://codeforces.com/contest/231/problem/C

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        long n = Long.parseLong(line1[0]);
        long k = Long.parseLong(line1[1]);
        Long[] arr = Arrays.stream(br.readLine().split(" ")).map(Long::parseLong).toArray(Long[]::new);

        Arrays.sort(arr);
        long[] prefixSum = new long[(int) n];
        prefixSum[0] = arr[0];
        for (int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        long m = arr[0], freq = 1;
        for (int i=1; i<n; i++){
            long c = count(arr, prefixSum, i, k);
            if (c > freq){
                freq = c;
                m = arr[i];
            }
        }
        System.out.println(freq + " " + m);
    }

    private static long count(Long[] arr, long[] prefixSum, long i, long k) {
        long low = 0, high = i;
        long elem = arr[(int) i];
        long ans = 0;
        while (low <= high){
            long mid = low + (high - low)/2;
            if (operations(prefixSum, i, mid, elem) > k){
                //move right
                low = mid + 1;
            }else {
                if (mid == 0 || operations(prefixSum, i, mid-1, elem) > k){
                    ans = i - mid + 1;
                    break;
                }
                high = mid - 1;
            }
        }
        return ans;
    }

    private static long operations(long[] prefixSum, long i, long mid, long elem) {
        long actual = prefixSum[(int) i]; //actual sum of elements
        if (mid > 0){
            actual -= prefixSum[(int) mid - 1];
        }
        long desired = (i - mid + 1) * elem;
        return desired - actual; // required operations
    }
}
