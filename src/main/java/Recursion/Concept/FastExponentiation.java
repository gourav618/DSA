package Recursion.Concept;

public class FastExponentiation {
    public static void main(String[] args){
//        Fast Exponentiation
//        we will learn the fast exponentiation technique which is used to calculate large exponents of a number.
//        Generally, it takes O(k) time to calculate N^k but with the help of the divide & conquer algorithm and recursion we can find it in O(log2k) time.
//
//                Eg. For 5^9
//
//        Fast Exponentiation
//        As clear from the example, we can divide the powers into two and can reduce the number of calculations to reach the final answer.
//
//                N^k = N^(k/2)*N^(k/2)  if k is even
//
//                = N^(k/2)*N^(K/2)*N if k is odd
//
//        Time complexity: O(log2k)
//        Space complexity: O(log2k)

        //BruteForce
        getPowerByBruteForce(4,7);

        //recursive way
        int powerByRecursion = getPowerByRecursion(4, 7);
        System.out.println(powerByRecursion);

        //binary exponentiation
        int powerByBinary = getPowerByBinary(4, 7);
        System.out.println(powerByBinary);

        //ternary exponentiation
        int powerByTernary = getPowerByTernary(4, 7);
        System.out.println(powerByTernary);
    }

    private static int getPowerByTernary(int n, int k) {
        if (k == 0){
            return 1;
        }
        int x = getPowerByTernary(n, k / 3);
        if (k%3 == 0){
            return x*x*x;
        }else if (k%3 == 1){
            return x*x*x*n;
        }
        return x*x*x*n*n;
    }

    private static int getPowerByRecursion(int n, int k) {
        if (k == 0){
            return 1;
        }
        return n * getPowerByRecursion(n, k-1);
    }

    private static int getPowerByBinary(int n, int k) {
        if (k == 0){
            return 1;
        }
        int x = getPowerByBinary(n, k / 2);

        if (k%2 == 0){
            return x*x;
        }else {
            return x*x*n;
        }
    }

    private static void getPowerByBruteForce(int n, int k) {
        int curr_val = 1;
        for (int i=0; i<k; i++){
            curr_val *= n;
        }
        System.out.println(curr_val);
    }
}
