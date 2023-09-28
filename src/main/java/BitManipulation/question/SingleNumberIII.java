package BitManipulation.question;

import java.util.Arrays;

public class SingleNumberIII {
    public static void main(String[] args){
        //https://leetcode.com/problems/single-number-iii/description/

        int[] nums = {1,2,1,3,2,5};

        int[] singleNumbers = singleNumber(nums);
        System.out.println(Arrays.toString(singleNumbers));
    }

    private static int[] singleNumber(int[] nums) {
        int overAllXor = 0;
        for (int i=0; i< nums.length; i++){
            overAllXor ^= nums[i];
        }
        int leastSetBit = 1;
        while ((leastSetBit &  overAllXor) == 0) {
            leastSetBit <<= 1;
        }
        int val1 = 0;
        for (int i=0; i< nums.length; i++){
            if ((nums[i] & leastSetBit) != 0)
                val1 ^= nums[i];
        }
        int val2 = val1 ^ overAllXor;
        return new int[]{val1, val2};
    }
}
