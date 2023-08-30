package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PointsOnLine {
    public static void main(String[] args) throws IOException {
        //https://codeforces.com/contest/252/problem/C
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] l1 = br.readLine().split(" ");
        long n = Long.parseLong(l1[0]);
        long d = Long.parseLong(l1[1]);
        String[] l2 = br.readLine().split(" ");
        long[] arr = new long[(int) n];
        for (int i=0;i<n; i++){
            arr[i] = Long.parseLong(l2[i]);
        }
        long ans = 0;
        int i=0, j=1;
        while (j < n){
            if (arr[j] - arr[i] <= d){
                long count = j-i;
                ans += (count*(count-1))/2;
                j++;
            }else {
                i++;
            }
        }
        System.out.println(ans);
    }
}
