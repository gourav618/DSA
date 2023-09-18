package BitManipulation.question;

public class SingleNumberII {
    public static void main(String[] args){
        //https://leetcode.com/problems/single-number-ii/

        int[] nums = {0,1,0,1,0,1,99};

        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        long mask = (1L << 31), ans = 0;
        for (int i=31; i>=0; i--){
            int count = 0;
            for (int num : nums) {
                if ((mask & num) != 0) {
                    count++;
                }
            }
            if (count % 3 !=0){
                ans += mask;
            }
            mask = (mask >> 1);
        }
        return (int) ans;
    }
}
