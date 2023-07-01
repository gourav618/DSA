package Sorting.Questions;

import java.util.*;

public class KefaAndCompany {
    public static void main(String[] args){
        //https://codeforces.com/contest/580/problem/B

        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);

        List<Long[]> friends = new ArrayList<>();
        for (int i=0; i<n; i++){
            Long[] s1 = Arrays.stream(sc.nextLine().split(" ")).map(Long::parseLong).toArray(Long[]::new);
            friends.add(s1);
        }

        friends.sort(Comparator.comparingLong(e -> e[0]));

        long[] ps = new long[n];
        ps[0] = friends.get(0)[1];
        for (int i=1; i<n; i++){
            ps[i] += friends.get(i)[1] + ps[i-1];
        }

        long ans = Long.MIN_VALUE;
        for (int i=0; i<n; i++){
            long max = findMaxFriendPossibleToInvite(friends, i, n - 1, d, ps);
            ans = Math.max(ans, max);
        }
        System.out.println(ans);
    }

    private static long findMaxFriendPossibleToInvite(List<Long[]> arr, int l, int h, int d, long[] ps) {
        int min=l, index = 0, f=0;
        while (l<=h){
            int mid = l + (h-l)/2;
            if (Math.abs(arr.get(mid)[0] - arr.get(min)[0]) < d){
                index = mid;
                f=1;
                l = mid+1;
            }else {
                h = mid-1;
            }
        }

        if (f != 1){
            index = min;
        }
        long sum = ps[index];
        if (min != 0){
            sum -= ps[min-1];
        }
        return sum;
    }
}
