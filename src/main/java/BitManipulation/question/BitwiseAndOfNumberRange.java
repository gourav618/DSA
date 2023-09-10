package BitManipulation.question;

public class BitwiseAndOfNumberRange {
    public static void main(String[] args){
        //https://leetcode.com/problems/bitwise-and-of-numbers-range/
        int left=5, right =7;
        System.out.println(rangeBitwiseAnd(left , right));
    }

    private static int rangeBitwiseAnd(int left, int right) {
        long mask = (1L << 31), ans = 0;
        while (mask != 0){
            if ((mask & left) == (mask & right)){
                if ((mask & left) != 0){
                    ans += mask;
                }
                mask = (mask >> 1);
            }else {
                break;
            }
        }
        return (int)ans;
    }
}
