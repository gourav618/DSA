package Mathematics.Concept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SegementedSieve {
    public static void main(String[] args){
//        Here we will look at the implementation of the segmented sieve,
//        Find prime numbers in the range [Li, Ri] for the given ‘Q’ queries - (L1, R1), (L2, R2), (L3, R3)....(Lq, Rq) & R<=10^11.
        List<String> Q = new ArrayList<>();
        Q.add("90,99");
        Q.add("5,100");
        Q.add("10000,100000");
        Q.add("10,40");
        getPrimeUsingSegmentedSieve(Q);

    }

    private static void getPrimeUsingSegmentedSieve(List<String> q) {
        List<Integer> primes = getPrimes();

        for (int i=0; i< q.size(); i++){
            String[] split = q.get(i).split(",");
            int l = Integer.parseInt(split[0]), r = Integer.parseInt(split[1]);
            getPrimesFromLTOR(l,r,primes);
        }

    }

    private static void getPrimesFromLTOR(int l, int r, List<Integer> primes) {
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(r-l+1, true));

        for (int i=0; i< primes.size(); i++){
            int k = (int) Math.ceil(1.0 * l / primes.get(i));
            for (int j = Math.max(k,2); primes.get(i)*j <= r; j++){
                isPrime.set(primes.get(i)*j-l, false);
            }
        }

        for (int i=0; i<isPrime.size(); i++){
            if (isPrime.get(i)){
                System.out.print(i+l+" ");
            }
        }
        System.out.println();
    }

    private static List<Integer> getPrimes() {
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(1000001, true));
        isPrime.set(1, false);
        for (int i=2; i*i<=(1000000); i++){
            if (isPrime.get(i)){
                for (int j=i; i*j<=(1000000); j++){
                    isPrime.set(i*j, false);
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i=2; i<isPrime.size(); i++){
            if (isPrime.get(i)){
                primes.add(i);
            }
        }
        return primes;
    }
}
