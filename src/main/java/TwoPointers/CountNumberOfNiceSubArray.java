package TwoPointers;

public class CountNumberOfNiceSubArray {
    public static void main(String[] args){
        //https://leetcode.com/problems/count-number-of-nice-subarrays/
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k=2;

        System.out.println(numberOfSubarrays(nums, k));
    }

    private static int numberOfSubarrays(int[] nums, int k) {
        int i=0, j=0, ans=0, count=0, oddCount=0;
        while (j < nums.length){
            if (nums[j]%2 != 0){
                oddCount++;
                ans = 0;
            }

            while (oddCount == k){
                ans++;
                if (nums[i]%2 != 0){
                    oddCount--;
                }
                i++;
            }
            count += ans;
            j++;
        }
        return count;
    }
}
