package TwoPointers;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args){
        //https://leetcode.com/problems/max-consecutive-ones-iii/

        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }

    private static int longestOnes(int[] nums, int k) {
        int i=0,j=0;
        int n=nums.length,countZeroes=0,ans=Integer.MIN_VALUE;

        while(j<n) {
            if(nums[j]==0) {
                countZeroes++;
            }
            while(countZeroes>k) {
                if(nums[i]==0) {
                    countZeroes--;
                }i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}
