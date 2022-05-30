package Mathematics.Concept;

public class PrimalityTest {
    public static void main(String []args){
        //If a number ‘x’(>1) has only two divisors - 1 and ‘x’ ie. the number itself then it is called a Prime Number.
        // we will learn how to check the primality of any number ‘N’ in O(√N) time complexity.

        //Brute Force - Count the factors of ‘N’ by iterating from 1 to 'N'. It will be a prime number only if the count is 2.
        //Time complexity: O(N)
        checkPrimeByBruteForce(17);

        //Optimised Brute Force - Since we know that the factors of ‘N’ are symmetric about √N. Therefore, we can iterate
        // from 1 to √N and count the total number of factors of ‘N’. It will be a prime number if the count is 1.
        //Time complexity: O(N)
        checkPrimeByOptimizedBruteForce(17);

    }

    private static void checkPrimeByOptimizedBruteForce(int n) {
        int count = 0;
        for (int i=2; i<=(int)Math.sqrt(n); i++){
            if (n%i == 0){
                count++;
            }
        }
        if (count == 0){
            System.out.println(n+" is prime no");
        }
    }

    private static void checkPrimeByBruteForce(int n) {
        int count = 0;
        for (int i=1; i<=n; i++){
            if (n%i == 0){
                count++;
            }
        }
        if (count == 2){
            System.out.println(n+" is prime no");
        }
    }
}
