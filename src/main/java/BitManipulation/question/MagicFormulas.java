package BitManipulation.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MagicFormulas {
    /** explanation
     q1  = p1  ^ ( 1 mod 1)  ^ (1 mod 2 ) ….  ^(1 mod n )

     q2 = p2 ^ ( 2 mod 1) ^ (2 mod 2 ) ….  ^(2 mod n )

     q3 = p3 ^ ( 3 mod 1) ^ (3 mod 2 ) ….  ^(3 mod n )
     .
     .
     .
     qn = pn ^ ( n mod 1) ^ (n mod 2 ) …. ^(n mod n )

     We need to find:

     q1 ^ q2 ^ q3 ^ ...  ^  qn

     = p1  ^ ( 1 mod 1)  ^ (1 mod 2 ) ….  ^(1 mod n )   ^   p2 ^ ( 2 mod 1) ^ (2 mod 2 ) ….  ^(2 mod n )
     ^ . . .  ^  pn ^ ( n mod 1) ^ (n mod 2 ) …. ^(n mod n )

     The p_i terms can be taken together and this expression can be rearranged as:

     = (p1  ^ p2 ^ p3 ^ ... pn) ^

     (( 1 mod 1)  ^ (1 mod 2 ) ….  ^(1 mod n ) ^

     ( 2 mod 1) ^ (2 mod 2 ) ….  ^(2 mod n )  ^

     . . .  ^ ( n mod 1) ^ (n mod 2 ) …. ^(n mod n )

     The modulus for the p terms can be computed easily.

     Now coming to the other part, our purpose is to find the value of :

     (( 1 mod 1)  ^ (1 mod 2 ) ….  ^(1 mod n ) ^

     ( 2 mod 1) ^ (2 mod 2 ) ….  ^(2 mod n )  ^

     . . .  ^ ( n mod 1) ^ (n mod 2 ) …. ^(n mod n )

     If we group all the terms in the same column together, we can rearrange the expression as:

     ( 1 mod 1)  ^ (2 mod 1 ) ….  ^(n mod 1 ) ^       <-- terms of first column

     ( 1 mod 1) ^ (2 mod 2 ) ….  ^(n mod 2 )  ^       <-- terms of second column

     . . .  ^( 1 mod n) ^ (2 mod n ) …. ^(n mod n )       <-- terms of last column

     Now if we consider the first line, that is terms of the first column, we see all terms will be 0:  0 ^ 0 ^ .... n terms

     Considering the second line, that is terms of the second column, we see all terms will be 0:  1 ^ 0 ^ 1 ^ 0 ^ 1 ^ 0^ 1.... n terms

     This series will end on either 0 or 1 based on value of n. Basically the ending term would be ---> n%2

     Similarly the third line, that is terms of the third column, we see all terms will be 0:  1 ^ 2^ 0 ^ 1 ^ 2^ 0 ^ 1 ^ 2 ^0 ^ 1.... n terms

     We see that for each column, we have a periodicity. We can determine how many times the cycle will get repeated and how many terms would be left.

     For instance, if n = 7 and we are considering mod 3, the terms would be 1 ^ 2 ^ 0 ^ 1 ^ 2 ^ 0 ^ 1

     So the 1,2,0 cycle got repeated 2 times, and 1 got left. Since the cycle got repeated even number of times,
     the terms would cancel each other out and we would get 0 by the xor operation, so we'll be left with only the left 1.

     Now if n = 11 and we are considering mod 3, the terms would be 1 ^ 2 ^ 0 ^ 1 ^ 2 ^ 0 ^ 1 ^ 2 ^ 0 ^ 1 ^ 2

     So the 1,2,0 cycle got repeated 3 times, and 1 ^ 2 got left. Since the cycle got repeated odd number of times,
     the terms would cancel each other out except for one cycle. So we'll be left with only the left (xor from 1 to 3) ^ (xor from 1 to 2).
     **/
    public static void main(String[] args) throws IOException {
        //https://codeforces.com/problemset/problem/424/C

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        Long[] arr = Arrays.stream(br.readLine().split(" ")).map(Long::parseLong)
                .toArray(Long[]::new);
        long res = 0;
        //xor-ing p1 ^ p2 ^ .. ^ pn
        for (int i=0; i<n; i++){
            res = res ^ arr[i];
        }
        //now calculate (i%1 ^ i%2 ^ ... i%n for each p)
        //long ans = getValueOfModWithoutPrefixXor(n);
        //with prefix array of xor till n
        int[] prefix_xor = new int[(int)n+1];
        prefix_xor[0] = 0;
        for (int i=1; i<= n; i++){
            prefix_xor[i] = prefix_xor[i-1] ^ i;
        }

        long ans = 0;
        for (int i = 1; i<= n; i++){
            long blocks = n / i;
            long leftOver = n % i;
            if ((blocks & 1) == 1) {
                ans = ans ^ prefix_xor[i-1];
            }
            ans = ans ^ prefix_xor[(int)leftOver];
        }

        res = res ^ ans;

        System.out.println(res);
    }

    private static long getValueOfModWithoutPrefixXor(long n) {
        long ans = 0;
        for (int i = 1; i<= n; i++){
            long blocks = n / i;
            long leftOver = n % i;
            //if block is odd
            if ((blocks & 1) == 1) {
                ans = ans ^ xorUntil(i);
            }
            ans = ans ^ xorUntil(leftOver+1);
        }
        return ans;
    }

    /**
     * xorUntil can be replaced by maintaining a prefix array of xor value till i
     * @param x
     * @return
     */

    private static long xorUntil(long x) {
        long ans = 0;
        for (int i=1; i<x; i++){
            ans = ans ^ i;
        }
        return ans;
    }
}
