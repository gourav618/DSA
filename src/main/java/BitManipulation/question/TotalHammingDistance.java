package BitManipulation.question;

public class TotalHammingDistance {
    public static void main(String[] args){
        //https://leetcode.com/problems/total-hamming-distance/

        int [] nums = {4,14,2};

        System.out.println(totalHammingDistance(nums));
    }

    private static int totalHammingDistance(int[] nums) {
        int n = nums.length;
        long mask = (1L << 31);
        int ans = 0;
        for (int i=31; i>=0; i--){
            int count = 0;
            for (int j=0; j<n; j++){
                if ((mask & nums[j]) != 0){
                    count++;
                }
            }
            ans += count * (n-count);
            mask >>= 1;
        }
        return ans;
    }
}
