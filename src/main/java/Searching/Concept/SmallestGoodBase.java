package Searching.Concept;

public class SmallestGoodBase {
    public static void main(String[] args){
//        Smallest Good Base
//        We have been given a number ‘N’ and we have to find its smallest good base ‘k’ such that k>=2 and N ∈ [3, 10^18].
//
//        A base is said to be a good base iff all the digits in that base representation are 1.
//
//        Input: 4681
//        Output: 8 ∵ 4681 = (11111)8
//
//        Approach:
//
//        A number ‘N’ can have multiple good bases.
//        Eg. 13 = (111)3 and 13 = (11)12
//        1 & N-1 will always be a good base of any number N.
//        N = (11)N-1 = (111111….N times)1
//        If we look at the representation of a good base ‘m’ then it will be expressed as:
//        N = (111111….i times)m = 1+m+m2+...+mi-1  (i terms)
//        From the above representation, it is clear that if ‘N’ has two good bases ‘k1’ and ‘k2’ with ‘i1’ and ‘i2’ terms respectively.
//        Then for k1<k2, i1>i2. Thus, there is monotonicity on the base if we fix the number of terms ‘i’.
//
//        Hence we can apply binary search on the number of terms ‘i’ to find if there exists a good base that has ‘i’ terms in the representation of ‘N’ where 2 < = i < 63.
//        (10^18) = Base 2 will have around 63 terms
//        In order to find the smallest good base, we should vary ‘i’ from 63 to 2 since the smallest good base will have the greatest number of terms.
//
//        Time complexity: O(63*log2N*63)
//        Space complexity: O(1)
//        Note: While writing the code you may encounter “Integer overflow” at multiple places. Therefore, use long long datatype
//        and handle summation and multiplication operations carefully.
//
//        Eg. You may get Integer overflow in a situation such as 1+10^10+10^20 since 10^20 can not be stored in any data type.
//        To counter this, we can keep subtracting the sum from N each time and increase the power of m only when (n-sum)/m^x>m.

        long smallestGoodBase = findSmallestGoodBase(4681);
        System.out.println(smallestGoodBase);
    }

    private static long findSmallestGoodBase(long N) {

        for (int i=63; i>=1; i--){//no of digits in base

            long l = 2, h = N-1;
            while (l<=h){
                long m = (l+h)/2;//mid

                long val = 0, x=1;// val is sum of series 1+m+m2.. and x is to calculate nest term
                int flag=0; //if val>num we break and make flag=1 i.e we move to left side
                for (int j=0; j<=i; j++){
                    val += x; //update val with next term
                    if (val>=N){
                        break;
                    }
                    if (j<i && (N-val)/m < x)// to prevent overflow of x*m
                    {
                        flag = 1;
                        break;
                    }
                    if (j<i) x *= m; // calculate next term
                }

                if (val>N || flag==1){
                    h = m-1;
                }else if (val<N){
                    l = m+1;
                }else {
                    return m;
                }
            }
        }

        return -1;
    }
}
