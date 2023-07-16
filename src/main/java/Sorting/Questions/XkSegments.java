package Sorting.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class XkSegments {
    public static void main(String[] args) throws IOException {
        //https://codeforces.com/contest/895/problem/B

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long n = Long.parseLong(s[0]), x = Long.parseLong(s[1]), k = Long.parseLong(s[2]);
        Long[] arr = Arrays.stream(br.readLine().split(" ")).map(Long::parseLong).toArray(Long[]::new);

        Arrays.sort(arr);
        long count = 0, prev = 0;
        for (int i=0; i<n; i++){

            if (i > 0 && !arr[i].equals(arr[i-1])){
                //System.out.println(arr[i] +" "+ arr[i - 1]);
                prev = i;
            }
            long maximalIndices = maximalIndices(arr, arr[i], prev, n - 1, k, x);
            if (maximalIndices != -1) {
                long minimalIndices = minimalIndices(arr, arr[i], prev, n - 1, k, x);
                count += (maximalIndices - minimalIndices + 1);
            }
        }
        System.out.println(count);
    }

    private static long minimalIndices(Long[] arr, long i, long l, long h, long k, long x) {
        long prev = l;
        long i1 = (i - 1) / x;
        while (l <= h) {
            long mid = l + (h - l) / 2;
            long noOfDivisors = (arr[(int) mid] / x) - i1;
            if (noOfDivisors < k) {
                l = mid + 1;
            } else if (noOfDivisors > k) {
                h = mid - 1;
            } else {
                if (mid == prev) {
                    return mid;
                }else {
                    long noOfDivisorsOnLeft = (arr[(int) mid - 1] / x) - i1;
                    if (noOfDivisorsOnLeft == k) {
                        h = mid - 1;
                    } else {
                        return mid;
                    }
                }
            }
        }
        return -1;
    }

    private static long maximalIndices(Long[] arr, long i, long l, long h, long k, long x) {
        long i1 = (i - 1) / x;
        while (l<=h){
            long mid = l + (h-l)/2;
            long noOfDivisors = (arr[(int) mid] / x) - i1;
            if (noOfDivisors < k) {
                l = mid+1;
            } else if (noOfDivisors > k) {
                h = mid-1;
            }else {
                if (mid == arr.length-1){
                    return mid;
                }else {
                    long noOfDivisorsOnRight = (arr[(int) mid + 1] / x) - i1;
                    if (noOfDivisorsOnRight == k) {
                        l = mid + 1;
                    } else {
                        return mid;
                    }
                }
            }
        }
        return -1;
    }
}
