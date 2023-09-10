package BitManipulation.question;

public class PowerOfTwo {
    public static void main(String[] args){
        //https://leetcode.com/problems/power-of-two/

        int n = 16;
        System.out.println(isPowerOfTwo(n));
    }

    private static boolean isPowerOfTwo(int n) {
        return n>0 && ((n & (n-1)) == 0);
    }
}
