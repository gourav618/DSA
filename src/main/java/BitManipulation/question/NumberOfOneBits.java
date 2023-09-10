package BitManipulation.question;

public class NumberOfOneBits {
    public static void main(String[] args){
        //https://leetcode.com/problems/number-of-1-bits/

        int n = 00000000000000000000000000001011;

        System.out.println(hammingWeight(n));
    }

    private static int hammingWeight(int n) {
        int count=0;
        while (n!=0){
            n = (n&(n-1));
            count++;
        }
        return count;
    }
}
