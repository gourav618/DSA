package TwoPointers;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args){
        //https://leetcode.com/problems/3sum-closest/

        int[] nums = {1,1,-1};
        int target = 1;

        System.out.println(threeSumClosest(nums, target));
    }

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i=0; i< nums.length; i++){
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int rem = target - nums[i];
            int p1 = i+1, p2 = nums.length-1;
            while (p1<p2){
                int curr = nums[p1] + nums[p2];
                ans = updateClosestToTarget(target, (nums[i]+nums[p1]+nums[p2]), ans);
                if (curr > rem){
                    p2--;
                } else if (curr < rem) {
                    p1++;
                }else {
                    //if we got sum == target no need to check further triplet
                    break;
                }
            }
        }
        return ans;
    }

    private static int updateClosestToTarget(int target, int curr, int ans) {
        if (Math.abs(target-ans) > Math.abs(target - curr)){
            return curr;
        }else {
            return ans;
        }
    }
}
