package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LightSabers {
    public static void main(String[] args) throws IOException {
        //https://codeforces.com/contest/958/problem/F2

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] l1 = br.readLine().split(" ");
        int n = Integer.parseInt(l1[0]);
        int m = Integer.parseInt(l1[1]);

        String[] l2 = br.readLine().split(" ");
        int[] knights = new int[n];
        for (int i=0;i<n; i++){
            knights[i] = Integer.parseInt(l2[i]);
        }

        String[] l3 = br.readLine().split(" ");
        int[] required = new int[m];
        for (int i=0;i<m; i++){
            required[i] = Integer.parseInt(l3[i]);
        }

        System.out.println(minJediRequired(n, knights, required));
    }

    private static int minJediRequired(int n, int[] knights, int[] required) {
        //calculate 1st window with all colors
        Map<Integer, Integer> freq = new HashMap<>();
        int start=0, end = 0;
        for (int i = 0; i< n; i++){
            if (!freq.containsKey(knights[i])){
                freq.put(knights[i], 1);
            }else {
                freq.put(knights[i], freq.get(knights[i])+1);
            }
            if (checkIfFreqIsRequired(freq, required)){
                end = i;
                break;
            }
        }
        //if no min window found  then no possible ans
        if (!checkIfFreqIsRequired(freq, required)){
            return -1;
        }
        //find the min window with all required colors
        int min = minJediToBeRemoved(freq, required);
        int prevStart = start;
        while (end < knights.length) {
            //trim extra Jedi
            while (freq.get(knights[start]) > required[knights[start] - 1]) {
                freq.put(knights[start], freq.get(knights[start])-1);
                start++;
            }
            //update min
            if (start > prevStart) {
                min = Math.min(min, minJediToBeRemoved(freq, required));
                prevStart = start;
            }
            //increment end i.e adding new jedi
            end++;
            if (end < knights.length){
                if (freq.containsKey(knights[end])) {
                    freq.put(knights[end], freq.get(knights[end]) + 1);
                }else {
                    freq.put(knights[end], 1);
                }
            }
        }
        return min;
    }

    private static int minJediToBeRemoved(Map<Integer, Integer> freq, int[] required) {
        int ans = 0;
        for (int i=0; i<required.length; i++){
            int needed = required[i];
            int has = freq.get(i + 1) == null ? 0 : freq.get(i + 1);
            if (has > needed){
                ans += has-needed;
            }
        }
        return ans;
    }

    private static boolean checkIfFreqIsRequired(Map<Integer, Integer> freq, int[] required) {
        for (int i=0; i< required.length; i++){
            int needed = required[i];
            int has = freq.get(i + 1) == null ? 0 : freq.get(i + 1);
            if (needed > has){
                return false;
            }
        }
        return true;
    }
}
