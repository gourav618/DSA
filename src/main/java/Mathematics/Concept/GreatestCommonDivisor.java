package Mathematics.Concept;

public class GreatestCommonDivisor {
    public static void main(String [] args){

        // GCD(A,B) of 12,18 ->note numbers can be 2 or more , A,B >= 0
        //divisor of 12 -> 1,2,3,4,6,12 divisor of 18 -> 1,2,3,6,9,18 :- common divisor = 1,2,3,6 :- greatest common divisor:- 6 -> GCD(12,18)
        //Note: GCD(A,B) <= min(A,B) since divisor of A cannot be greater than A worst case it will be equal to min(A+B) EX: GCD(4,12) = 4
        //      min value of GCD(A,B) = 1,i.e is a unique number which divide all Hence, 1 <= GCD(A,B) <= min(A,B)
        getGCDBYBruteForce(12, 18);

        //By repeated division method also called EUCLID'S GCD Method
        //GCD(12,18) -> 12%18 = 6 , 6%12 = 0 , hence GCD(12, 18) = 6
        //GCD(A,B) = when A is min else vice versa,if A%B == x and x==0 then A is GCD else if  x%A = x1 and x1 == 0 ...... until xn % xn-1 == 0 and gcd = xn
        getGCDByRepeatedDivision(12,18);

        //More on GCD

        //gcd(a0,a1,a2,...,an-1) = gcd of any 2 random no numbers and again a new pair
        // i.e gcd(a1,a2) = Ca1a2 , so then gcd(a0,Ca1a2,a3) -> gcd(Ca0a1a2, a3) -> answer

        //int arr[N], GCD of entire array ,N >=2 else edge case question would tell us what to do
        int arr[] = {12,18,20};
        int gcdOfWholeArray = getGCDOfWholeArray(arr);
        System.out.println("gcd of whole array: "+gcdOfWholeArray);

        //int arr[N], return 1 if there is any subsequence of array with GCD = 1
        //subsequence means pair/single/or group of element need not to be contigious ex: {a0,a1,a2,a3,a4} = {a1,a2},{a1},{a0,a3,a4} -> all are subsequence
        //for each element we have 2 choices either its in subsequence or not, and there are N such element so 2^N possible subsequence present
        // EX: gcd(a0,a1,a2,a3,a4,a5,a6) , such that gcd(a0,a2,a4,a6) = 1 then gcd(gcd(a0,a2,a4,a6), a1,a3,a5) also equals 1
        // i.e if gcd of entire array is 1 then there will be a subsequence with gcd =1 as shown above
        // so we dont need to compare each pair or triplet to find the subsequence having gcd 1
        // we can just find the gcd of entire array as done above and see if there is a subsequence with gcd=1
        int arr1[] = {6,10,15};
        getSubSequenceWithGCDEqualsOne(arr1);
        getSubSequenceWithGCDEqualsOne(arr);
    }

    private static void getSubSequenceWithGCDEqualsOne(int[] arr) {
        int gcdOfWholeArray = getGCDOfWholeArray(arr);
        if (gcdOfWholeArray == 1){
            System.out.println(1);
        }
        else {
            System.out.println("no subsequence with gcd = 1");
        }
    }

    //there are N-1 invocation to getGCD method , since we calculate gcd in pair
    // gcd for each will take time -> o(log2(max(a,b)) , in case of array it would be log(max(arr[i])) -> max element in array
    //total time complexity -> o(N * log(max(arr[i]))
    private static int getGCDOfWholeArray(int[] arr) {
        int gcd = getGCDByRepeatedDivision(arr[0], arr[1]);
        for (int i=2; i<arr.length; i++){
            gcd = getGCDByRepeatedDivision(gcd, arr[i]);
        }
        return gcd;
    }

    // time is determine by the while loop running since other than that all are constant operation
    // gcd(a,b) considering min = a , a%b = x ,value x is determined by the previous value(a,b) and x < a [but not enough to determine the complexity]
    // if a <= b/2 then nxt_divisor < b/2 and if a > b/2 then the quotient is always 1 and remainder i.e nxt_divisor will be b-a and will be less than b/2
    // so, we can conclude nxt_divisor is always half of max(a,b) i.e max(a,b) - > max(a,b)/2 - > max(a,b)/2^2 .... until it becomes 1
    // lets assume it take x step , max(a,b)/2^x = 1 :- 2^x = max(a,b) :- x = log(max(A,b)) with base 2
    // time -> o(log2(max(a,b))
    private static int getGCDByRepeatedDivision(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a,b);
        //Note: if both no is 0 then we cannot identify gcd since 0%0 is infinity
        // if any 1 no is 0 then gcd of something with 0 will be a non-zero element
        if (min == 0){
             return max;
        }
        while (max%min != 0){
            int temp = max;
            max = min;
            min = temp%min;
        }
        return min;
        //System.out.println("GCD("+a+" ,"+b+") ->"+min);
    }

    //time -> o(min(A,B))
    private static void getGCDBYBruteForce(int a, int b) {
        int gcd = 0;
        for (int i=1; i<= Math.min(a,b); i++){
            if (a%i == 0 && b%i == 0){
                gcd = i;
            }
        }
        System.out.println("GCD("+a+" ,"+b+") ->"+gcd);
    }
}
