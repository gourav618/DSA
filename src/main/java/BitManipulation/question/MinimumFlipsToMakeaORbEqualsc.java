package BitManipulation.question;

public class MinimumFlipsToMakeaORbEqualsc {
    public static void main(String[] args){
        //https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/

            int a = 2, b = 6, c = 5;

            System.out.println(minFlips(a, b, c));
    }

    private static int minFlips(int a, int b, int c) {
        int count = 0;
        long mask = (1L << 31);
        //check for each bit position
        for (int i=31; i>=0; i--){
            long bitA = (a & mask);
            long bitB = (b & mask);
            long bitC = (c & mask);

            if (bitC != 0) {
                if (bitA == 0 && bitB == 0){
                    count++;
                }
            }else {
                if (bitA != 0){
                    count++;
                }
                if (bitB != 0){
                    count++;
                }
            }
            mask >>= 1;
        }
        return count;
    }
}
