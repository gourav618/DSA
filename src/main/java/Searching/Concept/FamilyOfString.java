package Searching.Concept;

public class FamilyOfString {
    public static void main(String[] args){
//        Family of Strings
//        Consider a family of boolean strings defined by the rule: S(0) = 0 and S( i ) = S(i-1).0.S(i-1)’.
//        We have to find the kth character of ith member i.e. S( i ).
//        Input: i=3, k=2
//        Output: 0
//        S(3) = 001011001101001
//
//        Approach:
//        What will be the middle character of a string S(i)? The answer is 0 and it is obvious from the definition of
//        the family of string.
//        What will be the length of the ith string? It is 2^(i+1)-1.
//        S[0] = 0 : 1 (2^(0+1)-1)
//        S[1] = 001 : 3 (2^(1+1)-1)
//        S[2] = 0010110 : 7 (2^(2+1)-1)
//        S[3] = 0010110011010011 : 15 (2^(3+1)-1)
//        If we try to represent any random string in the form of a tree with the centre of the string as the root of the
//        tree, then we will find that -
//                The character changes when we move towards the right (RT)
//                It remains the same when we move towards the left (LT)
//
//        Thus we can apply binary search on the string length and move the mid depending on whether mid<k, mid=k or mid>k.
//        Time complexity: O(2^(N+1)-1) = O(N)
//        Space complexity: O(1)

        int kthCharacterFromFamilyOfString = findKthCharacterFromFamilyOfString(3, 2);
        System.out.println(kthCharacterFromFamilyOfString);

    }

    private static int findKthCharacterFromFamilyOfString(int n, int k) {
        int l=0, h= (int) (Math.pow(2, n+1)-2); //for s[n] string length = 2^n+1 -1 so range lies from [0, 2^n+1 -2]
        int bit = 0; // central bit is always zero

        while (l<=h){
            int m = (l+h)/2;

            if (m == k){// m is the kth char in s[n]
                return bit;
            }else if (m < k){//move right and when we move right across tree bit changes
                l = m+1;
                bit = 1-bit; //toggle bit
            }else {//when move left bit doesn't change so no toggle needed
                h = m-1;
            }
        }
        return -1;
    }
}
