package Searching.Concept;

public class SquareRoot {
    public static void main(String[] args){
//        Square Root
//        In this lecture, we will learn how to calculate the square root of a number ‘N’ with the help of monotonicity and binary search.
//
//        Property: √N = x   such that x^2=N or x^2<=N<=(x+1)^2
//
//        Since we know that
//
//        f(x) = x^2 is monotonically increasing from [0,∞]
//        1<=√N<=N
//        Hence we can apply binary search on the answer that is low = 1 and high = N to find the square root of ‘N’.

        int i = squareRootByBruteForce(15);
        System.out.println("Square root of 15: "+i);

        int i1 = squareRootByBinarySearch(77);
        System.out.println("square root of 77: "+i1);
    }

    private static int squareRootByBinarySearch(int N) {
        int l=0, h=N;

        while (l<=h){
            int m = (l+h)/2;
            if (m*m > N){
                h = m-1;
            }
            else {
                if ((m+1)*(m+1) > N){
                    return m;
                }else {
                    l = m+1;
                }
            }
        }
        return -1;
    }

    private static int squareRootByBruteForce(int N) {
        int i=0;
        while (i<=N){
            if (i*i == N){
                return i;
            }
            else if (i*i > N){
                return i-1;
            }
            i += 1;
        }
        return -1;
    }
}
