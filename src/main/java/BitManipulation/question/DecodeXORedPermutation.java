package BitManipulation.question;

import java.util.Arrays;

public class DecodeXORedPermutation {
    public static void main(String[] args){
        //https://leetcode.com/problems/decode-xored-permutation/description/

        int[] encoded = {6,5,4,6};

        int[] decoded = decode(encoded);

        System.out.println(Arrays.toString(decoded));
    }

    private static int[] decode(int[] encoded) {
        int n = encoded.length;
        //find over all xor from 1 to n
        int overAllXor = 0;
        for (int i=1; i<=n+1; i++) {
            overAllXor ^= i;
        }

        int[] perm = new int[n+1];
        //find perm[0] = overAllXor ^ encoded[1] ^ encoded[3] ^ encoded[5] .....
        perm[0] ^= overAllXor;
        for (int i=1; i<n; i+=2){
            perm[0] ^= encoded[i];
        }

        //find other perm[i] = perm[i-1] ^ encoded[i-1]
        for (int i=1;i<n+1; i++){
            perm[i] = perm[i-1] ^ encoded[i-1];
        }
        return perm;
    }
}
