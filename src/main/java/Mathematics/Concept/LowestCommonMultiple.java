package Mathematics.Concept;

public class LowestCommonMultiple {
    public static void main(String[] args){

        //LCM(12,18), multiple of 12 = 12,24,36,48,60,72... and multiple of 18 = 18,35,54,72... ; common multiple  = 36,72, ....
        //lowest common multiple  = 36
        // not the lower bound of lcm will be greater than eqaul to max (A,B) Ex: lcm(12,36) = 36
        // max boound of lcm(A,B) = A*B since this number is multiple of both and if a no crosses this range there will be no common multiple Ex: lcm(5,7) = 35
        // max(A,B) <= lcm(A,B) <= A*B

        getLcmByBruteForce(12,18);

        //Mathematics solution
        // hcf(a,b) * lcm(a,b) = a*b ; here we know the 2 no's and hcf is nothing but the gcd(a,b) and that can be calculated in log(max(a,b))
        //hence , lcm can be calculated in constant time

        getLcmByMathematicsEquation(12,18);

        //LCM of more than 2 numbers can be calculated same way as we did for gcd
        //ex: lcm(a,b,c) = lcm(lcm(a,b), c)  = lcm(lcmab, c)  and so on
        int arr[] = {12,18,36};
        getLcmOfWholeArray(arr);

        //Given, int N; int A,B where N,A,B > 0
        //find the count of element between [1 to N] which are atleast divisible by A or B
        //Ex: N= 20, A=2,B=3 , find no's between [1 ... 20] which are div by either 2 or 3 or both
        // o/p = 13 i.e {2,3,4,6,8,9,10,12,14,15,16,18,20}

        //By brute fore we can simply do this by looping all no and check the divisibility i.e time -> o(N)

        //optimization
        //for no in [1 to .. N] ; no div by A = N/A , no div by B = N/B
        // total elem divisible by atleast one of them = N/A + N/B - common elem in N/A and N/B
        // ex: N= 20, A=2,B=3
        //no div by A = 20/2 = 10 i.e {2,4,6,8,10,12,14,16,18,20}
        //no div by B = 20/3 = 6 i.e {3,6,9,12,15,18}
        //here we can see that 6,12,18 are counted twice , and if we note this are multiple of 6 and 6 is the lcm of 2,3
        //so final equation = N/A + N/B - N/lcm(A,B)
        getCountOfElemAtleastDiv(20,2,3);

        // if we have 3 nos a,b,c
        //then equation would look like n/a + n/b + n/c - n/lcm(a,b) - n/lcm(b,c) - n/lcm(a,c) + n/lcm(a,b,c)
    }

    private static void getCountOfElemAtleastDiv(int n, int a, int b) {
        int count = (n/a) + (n/b) - (n/ getLcmByMathematicsEquation(a, b));
        System.out.println(count);
    }

    private static void getLcmOfWholeArray(int[] arr) {
        int lcm = getLcmByMathematicsEquation(arr[0], arr[1]);

        for (int i=2; i<arr.length; i++){
            lcm = (lcm * arr[i])/getGCDByRepeatedDivision(lcm, arr[i]);
        }
        System.out.println("lcm of whole array = "+lcm);
    }

    private static int getLcmByMathematicsEquation(int a, int b) {
        //time -> log(max(a,b))
        int gcdByRepeatedDivision = getGCDByRepeatedDivision(a, b);
        int lcm = a * b / gcdByRepeatedDivision;
        System.out.println("lcm of "+a+" ,"+b+" = "+lcm);
        return lcm;
    }

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

    private static void getLcmByBruteForce(int a, int b) {
        for (int i = Math.max(a,b); i< a*b; i++){
            if (i%a == 0 && i%b == 0){
                System.out.println("lcm of "+a+" ,"+b+" = "+i);
                break;
            }
        }
    }
}
