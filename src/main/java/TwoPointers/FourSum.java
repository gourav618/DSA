package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args){
        //https://leetcode.com/problems/4sum/

        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;

        List<List<Integer>> lists = fourSum(nums, target);
        System.out.println(lists.toString());

    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i=0; i< nums.length; i++){
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j=i+1; j< nums.length; j++){
                if (j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                long rem = (long) target - ((long) nums[i]+nums[j]);
                int p1 = j+1, p2 = nums.length-1;
                while (p1<p2){
                    long curr = (long) nums[p1]+nums[p2];
                    if (curr < rem){
                        p1++;
                    } else if (curr > rem) {
                        p2--;
                    }else {
                        List<Integer> quadruplet = List.of(nums[i], nums[j], nums[p1], nums[p2]);
                        quadruplets.add(quadruplet);
                        if (nums[p1] == nums[p2]){
                            break;
                        }else {
                            int x = nums[p1], y = nums[p2];
                            while (nums[p1] == x)
                                p1++;
                            while (nums[p2] == y)
                                p2--;
                        }
                    }
                }
            }
        }
        return quadruplets;
    }
}
