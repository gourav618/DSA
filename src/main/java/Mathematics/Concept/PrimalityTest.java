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

        //Primality test in a range

        //Brute Force - We can iterate from 1 to N and can check the primality of each number individually.
        //Time complexity: O(N√N)
        //Space complexity: O(1)
        printAllPrimeNumberInARange(20);

//        Using Sieve of Eratosthenes - In this technique, we create a boolean array to represent the state of the numbers from 1 to N.
//        Initially we assume each one of them to be prime and we iterate from 2 to N marking all their divisors to be non-prime in the boolean array.
//        We follow this process only for the numbers that are marked as prime in the boolean array.
//        At the end, we will be left with the true nature of the numbers in the boolean array.
//        Time complexity: N/2+N/3+N/5+N/7+...+=N[1/2+1/3+1/5+1/7+...+] = O(Nlog(logN))
//        Space complexity: O(N)
        printAllPrimeNumberInRangeUsingSieveOfEratosthenes(20);

        System.out.println();

        //optimization in sieve
        // instead of always striking multiple from i*2 instead start from i*i
        //and once we reach square root of n all and we starting from i*i it will be greater than N
        printAllPrimeNumberInRangeUsingSieveOfEratosthenesOptimized(20);

    }

    private static void printAllPrimeNumberInRangeUsingSieveOfEratosthenesOptimized(int n) {
        int[] primes = new int[n+1];
        //init all elem to 1 , considering al;l are prime
        for (int i=1;i<=n;i++){
            primes[i] = 1;
        }
        //ignore 1 since universal factor and not prime
        primes[1] = 0;

        for (int i=2; i*i<=n;i++){
            if (primes[i] == 1){
                for (int j=i; j*i <= n; j++){
                    primes[i*j] = 0;
                }
            }
        }

        //print all prime
        for (int i = 2;i< primes.length; i++){
            if (primes[i] == 1){
                System.out.print(i+" ");
            }
        }
    }

    private static void printAllPrimeNumberInRangeUsingSieveOfEratosthenes(int n) {
        int[] primes = new int[n+1];
        //init all elem to 1 , considering al;l are prime
        for (int i=1;i<=n;i++){
            primes[i] = 1;
        }
        //ignore 1 since universal factor and not prime
        primes[1] = 0;

        for (int i=2; i<=n;i++){
            if (primes[i] == 1){
                for (int j=2; j*i <= n; j++){
                    primes[i*j] = 0;
                }
            }
        }

        //print all prime
        for (int i = 2;i< primes.length; i++){
            if (primes[i] == 1){
                System.out.print(i+" ");
            }
        }
    }

    private static void printAllPrimeNumberInARange(int n) {
        for (int i=2; i<=n;i++) {
            int count = 0;
            for (int j = 2; j * j <= i; j++) {
                count = 0;
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
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
