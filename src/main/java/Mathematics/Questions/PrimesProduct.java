package Mathematics.Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimesProduct {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=44&sectionId=1&moduleId=1&topicId=2&subtopicId=30&assignmentId=6

        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        s.nextLine();

        List<Integer> primes = getPrimes();

        while (T-- > 0){
            String[] s1 = s.nextLine().split(" ");
            int l = Integer.parseInt(s1[0]);
            int r = Integer.parseInt(s1[1]);

            long primeFromLToR = getPrimeFromLToR(l, r, primes);
            System.out.println(primeFromLToR);
        }
    }

    private static long getPrimeFromLToR(int l, int r, List<Integer> primes) {
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(r-l+1, true));

        for (Integer prime : primes){
            int k = (int) Math.ceil(1.0*l/prime);
            for (int j= Math.max(k, 2); prime*j<=r; j++){
                isPrime.set(prime*j-l, false);
            }
        }

        long ans = 1; long mod = 1000000007;
        for (int i=0; i<isPrime.size(); i++){
            if (isPrime.get(i)){
                ans = ((ans % mod) * ((i+l) % mod)) % mod;
            }
        }
        return ans;
    }

    private static List<Integer> getPrimes() {
        int max = 1000000;
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(max+1, true));
        isPrime.set(1, false);

        List<Integer> primes = new ArrayList<>();
        for (int i=2; i<=Math.sqrt(max); i++){
            if (isPrime.get(i)){
                for (int j=i; i*j<=max; j++){
                    isPrime.set(i*j, false);
                }
            }
        }
        for (int i=2; i<=max; i++){
            if (isPrime.get(i))
                primes.add(i);
        }
        return primes;
    }
}
