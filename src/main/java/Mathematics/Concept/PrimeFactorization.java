package Mathematics.Concept;

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
