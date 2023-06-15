package Searching.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Monitor {
    public static void main(String[] args) throws IOException {
        //https://codeforces.com/problemset/problem/846/D
        //https://codeforces.com/blog/entry/54357
        //https://codeforces.com/contest/846/submission/189360150

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(str[0]);

        int m = Integer.parseInt(str[1]);

        int k = Integer.parseInt(str[2]);

        int q = Integer.parseInt(str[3]);

        long max = Long.MIN_VALUE;

        int[] x = new int[q];

        int[] y = new int[q];

        int[] t = new int[q];

        for (int i = 0; i < q; i++)
        {
            str = br.readLine().trim().split("\\s+");
            x[i] = Integer.parseInt(str[0]);

            y[i] = Integer.parseInt(str[1]);

            t[i] = Integer.parseInt(str[2]);

            max = Math.max(t[i], max);
        }

        long min = 0;

        System.out.println(binarySearch(x, y, t, k, min, max, n, m));
    }

    public static long binarySearch(int[] x, int[] y, int[] t, int k, long min, long max, int n, int m)
    {

        long low = min;

        long high = max;

        while (low <= high)
        {

            long mid = low + (high - low) / 2;

            if (!isPossible(x, y, t, k, mid, n, m))
            {

                low = mid + 1;
            }

            else
            {

                if (!isPossible(x, y, t, k, mid - 1, n, m))
                {

                    return mid;
                }

                high = mid - 1;
            }
        }

        return -1;
    }

    public static boolean isPossible(int[] x, int[] y, int[] t, int k, long mid, int n, int m)
    {

        int[][] sum = new int[n + 1][m + 1];

        for (int i = 0; i < t.length; i++)
        {

            if (t[i] <= mid)
            {

                sum[x[i]][y[i]] = 1;
            }
        }

        for (int i = 1; i <= n; i++)
        {

            for (int j = 1; j <= m; j++)
            {

                sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];

                if (i >= k && j >= k && sum[i][j] - sum[i - k][j] - sum[i][j - k] + sum[i - k][j - k] == k * k)
                {

                    return true;
                }
            }
        }

        return false;
    }
}
