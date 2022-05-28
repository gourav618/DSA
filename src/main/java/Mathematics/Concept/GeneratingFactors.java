package Mathematics.Concept;

public class GeneratingFactors {
    public static void main(String[] args){
        
        //Given int N; print all the factors/divisors
        
        //for N the smallest factor is always 1 and largest factor would be number itself N
        //all the no which is factor of N lies between 1 to N
        
        printAllFactorsByBruteForce(12);

        //to optimize this we think for a way where we can reduce the loop size
        // ex: N=100 , factors = 1,2,4,5 ... , 50,100
        // if we note the last factor is number itself and 2nd last factor is N/2, so we can say that no matter what N value is last factor is no itself 
        // and the other factor lies between 1 to N/2
        printAllFactorByDecreasingIteration(12);

        //to optimize further we use concept/property: Factors of N are symmetric about square root of N
        //Ex: N=16, factors = 1,2,4,8,16 , where 16 is a perfect square
        // square root of 16 = 4 , and we can see that  all the number left to it will have counterpart of it on right side
        //i.e 1 let assume i on left will have its counter part 16 on its right i.e N/i , 2 on left side -> 16/2 = 8 on right side
        // where N is not a perfect square ,Ex: N=20, factors = 1,2,4,5,10,20 , square root of 20 = 4.47..
        // so symmetry lie between-> {1,2,4}{5,10,20} where 1 & 20, 2 & 10 ..
        // to proof this mathematically, let N = x*y where x & y !> square root of N and x & y !< square root of N
        // so one part need to be less than square root of N and other greater
        printAllFactorBySymmetricMethod(16);

        //Given, int N; if number of divisor is even then return false else true i.e odd

        //by brute force we can get all the factor and count it and decide the no of factor is even or odd , o(n)

        //but if we note,if the no has square root then consider it as point and if we have x elem on left we will have x on right i.e 2x + 1 where 1 is square root
        // if the no is not perfect square then we will have 2x factor
        // so order of algo is o(1)
        boolean ifweHaveEvenDivisorOrNot = findIfweHaveEvenDivisorOrNot(16);
        System.out.print("\n"+ifweHaveEvenDivisorOrNot);

    }

    private static boolean findIfweHaveEvenDivisorOrNot(int n) {
        int i = (int) Math.sqrt(n);

        if (i*i == n){
            return false;
        }
        return true;
    }

    // time -> o(square root of n)
    private static void printAllFactorBySymmetricMethod(int n) {
        for (int i=1; i<=Math.sqrt(n); i++){
            if (n%i == 0){
                if (i*i == n){
                    System.out.print(i+" ");
                }else {
                    System.out.print(i+" ");
                    System.out.print(n/i+" ");
                }
            }
        }
    }

    // time -> o(n/2)
    // but if we note asymptotically there is not much diff in complexity with o(n)
    private static void printAllFactorByDecreasingIteration(int n) {
        for (int i=1; i<=n/2; i++){
            if (n%i == 0){
                System.out.print(i+" ");
            }
        }
        System.out.println(n);
    }

    // time -> o(n)
    private static void printAllFactorsByBruteForce(int n) {
        for (int i=1; i<=n; i++){
            if (n%i == 0){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
}
