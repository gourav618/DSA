package BitManipulation.question;

public class MinimumOneBitOperationsToMakeIntegersZero {
    public static void main(String[] args){
        //https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/description/
        //https://www.youtube.com/watch?v=Lp2pncT8FXc

        int n = 6;
        System.out.println(minimumOneBitOperations(n));
    }

    private static int minimumOneBitOperations(int n) {
        int[] f = new int[31];
        f[0] = 1;
        for (int i=1; i<31; i++){
            f[i] = f[i-1]*2 + 1;
        }

        int ans = 0;
        int plus = 1;
        for (int i=30; i>=0; i--){
            boolean is_ith_bit_set = ((1<<i)&n) != 0;
            if (!is_ith_bit_set)
                continue;

            if (plus == 1)
                ans += f[i];
            else
                ans -= f[i];
            plus ^= 1;
        }
        return ans;
    }
}
