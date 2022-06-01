package Mathematics.Concept;

import java.util.Arrays;

public class CountingDivisorFactor {
    public static void main(String[] args){
//        how to efficiently count the factors of a number ‘N’ by using the Rule of Products.
//        We have been given an integer, N = (P1)^c1(P2)^c2(P3)^c3..(Pi)^ci; where P1, P2, P3,.., Pi are prime numbers,
//        then print the value of c1 + c2 + c3 +..+ ci.
//         Approach:
//        Since we know that any factor of N consists of the product of some or all the prime factors of N.
//        And for every prime factor Pi with power ci, we have (ci+1) different powers to consider in the product.
//        Therefore by Rule of Products, total number of divisors = (c1+1)(c2+1)(c3+1)..(ci+1).
        int[] Q = {36, 6060}; //Q queries
        for (int i=0; i<Q.length; i++) {
            getCountOfAllFactorUsingSPFMethod(Q[i]);
        }
    }

    private static void getCountOfAllFactorUsingSPFMethod(int n) {
        int [] spf = new int[n+1];
        Arrays.fill(spf, -1);
        int num = n;
        for (int i=2; i*i<=num; i++){
            if (spf[i] == -1){
                for (int j=i; i*j<=num; j++){
                    if (spf[i*j] == -1){
                        spf[i*j] = i;
                    }
                }
            }
        }
        int res = 1, prev = spf[num],count =0;
        while (spf[num] != -1){
            if (spf[num] == prev){
                count++;
                num = num/spf[num];
            }else {
                res *= (count+1);
                count = 1;
                prev = spf[num];
                num = num/spf[num];
            }
        }
        if (num != prev) {
            res = res * (count + 1) * 2;
        }else {
            res = res * (++count + 1);
        }
        System.out.println(res);
    }
}


