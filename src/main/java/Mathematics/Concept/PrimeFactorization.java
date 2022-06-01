package Mathematics.Concept;

import java.util.Arrays;

public class PrimeFactorization {
    public static void main(String [] args){
//        Expressing a number as a product of its prime factors is called Prime factorisation. N = P1*P2*P3..Pi where P1, P2,...Pi are primes.
//         Eg. 12=2*2*3

//        Brute Force - Iterate ‘i’ from 2 to N and keep dividing N till it is divisible by ‘i’. Maintain the count of each prime factor to
//        find their power in the prime factorisation of N.
//        Can it ever happen that i divides N but it is a composite number?
//              No, it will not happen as we are starting with the lowest possible prime number i.e. 2.
//        Time complexity: O(Nlog2N)
        getPrimeFactorizationByBruteForce(72);


//        Since √N*√N=N, therefore if one of the prime factors is larger than √N then the rest have to be smaller than √N otherwise
//        the product of prime factors will be larger than N, which is not possible.
//        Hence we can optimize the previous brute force approach by iterating ‘i’ from 2 to √N and keep dividing N till it is divisible by ‘i’.
//        At the end of the process, we have to check the remaining number. If it is not equal to 1 then it is to be counted as a prime factor of N.
//        Eg. 404=2*2*101
//        Note: The maximum number of terms the prime factorisation of a number would have is equal to log2N.
//                Time complexity: O(√N + log2N) = O(√N)
        getPrimeFactorizationByOptimizedBruteForce(404);

        // Fast Factorization
        // In this lecture, we will learn the concept of fast factorisation by finding the prime factorisation of Q queries.
        //Print the prime factorisation of n1, n2, n3,.., nq (ni<=N).
        //
        // Using Sieve of Eratosthenes - Create an array of prime numbers (<=N) using the Sieve of Eratosthenes.
        // Iterate through the array to find all the prime factors of ni.
        //Time complexity: O(Nlog(logN)+(number of primes x (logN)))
        //Space complexity: O(N)
        int[] q = {72,404,6060};
        getPrimeFactorizationOfQueries(q);

//        Using Smallest Prime Factor (SPF) - This method helps in getting rid of useless prime numbers by finding the smallest prime
//        factor of all the numbers till N. We implement this algorithm by slightly modifying the code of the sieve of Eratosthenes.
//        Time complexity: O(NloglogN + QlogN)
//        Space complexity: O(N)
          int[] q1 = {72,404,6060};
          getPrimeFactorizationOfQueriesUsingSPF(q1);
    }

    private static void getPrimeFactorizationOfQueriesUsingSPF(int[] q) {
        for (int i=0;i< q.length;i++){
            int [] spf = new int[q[i]+1];
            Arrays.fill(spf, -1);

            for (int j=2; j*j<=q[i]; j++){
                if (spf[j] == -1){
                    for (int k=j; k*j<=q[i]; k++){
                        if (spf[k*j] == -1){
                            spf[k*j] = j;
                        }
                    }
                }
            }
            int num = q[i];
            while (spf[num] != -1){
                System.out.print(spf[num]+" * ");
                num = num/spf[num];
            }
            if (num != 1)
                System.out.println(num);
        }
    }

    private static void getPrimeFactorizationOfQueries(int[] q) {
        for (int i=0; i<q.length; i++) {
            int[] primeArray = getPrimeArrayUsingSieveOfEratosthenes(q[i]);

            for (int j=2; j< primeArray.length; j++){
                while (q[i]%j == 0){
                    System.out.print(j+" * ");
                    q[i] = q[i]/j;
                }
            }
            if (q[i] != 1){
                System.out.print(q[i]);
            }
            System.out.println();
        }
    }

    private static int[] getPrimeArrayUsingSieveOfEratosthenes(int n) {
        int[] primes = new int[n+1];
        //init all elem to 1 , considering al;l are prime
        for (int i=1;i<=n;i++){
            primes[i] = 1;
        }
        //ignore 1 since universal factor and not prime
        primes[1] = 0;

        for (int i=2; i*i<=n;i++){
            if (primes[i] == 1){
                for (int j=2; j*i <= n; j++){
                    primes[i*j] = 0;
                }
            }
        }
        return primes;
    }

    private static void getPrimeFactorizationByOptimizedBruteForce(int n) {
        int num = n;
        for (int i=2; i*i<=num; i++){
            while (n%i == 0){
                System.out.print(i+" * ");
                n = n/i;
            }
        }
        if (n != 1){
            System.out.println(n);
        }
    }

    private static void getPrimeFactorizationByBruteForce(int n) {
        int num = n;
        for (int i=2; i<=num; i++){
            while (n%i == 0){
                System.out.print(i+" * ");
                n = n/i;
            }
        }
        System.out.println();
    }
}
