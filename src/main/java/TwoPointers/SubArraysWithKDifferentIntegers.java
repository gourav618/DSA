package TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDifferentIntegers {
    public static void main(String[] args){
        //https://leetcode.com/problems/subarrays-with-k-different-integers/
        int[] nums = {1,2,1,3,4};
        int k=3;

        System.out.println(subarraysWithKDistinct(nums, k));
    }

    private static int subarraysWithKDistinct(int[] nums, int k) {
        int i=0, j=0, ans=0, curr=0;
        int n = nums.length;
        //to store the freq of distinct element
        Map<Integer, Integer> freq = new HashMap<>();

        while (j < n){
            if (!freq.containsKey(nums[j])){
                curr++;
                freq.put(nums[j], 1);
            }else {
                freq.put(nums[j], freq.get(nums[j])+1);
            }

            if (curr == k){
                int index = findFirstIntegerNotInMap(nums, j, freq);
                while (curr == k){
                    ans += index-j;
                    if (freq.get(nums[i]) == 1){
                        curr--;
                        freq.remove(nums[i]);
                    }else {
                        freq.put(nums[i], freq.get(nums[i])-1);
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }

    private static int findFirstIntegerNotInMap(int[] nums, int j, Map<Integer, Integer> freq) {
        for (int i=j+1; i<nums.length; i++){
            if (!freq.containsKey(nums[i])){
                return i;
            }
        }
        return nums.length;
    }
}
