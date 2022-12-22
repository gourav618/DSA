package Mathematics.Questions;

import java.util.Arrays;
import java.util.Scanner;

public class CountingPrimes {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=30&sectionId=1&moduleId=1&topicId=2&subtopicId=25&assignmentId=5

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();
        int[] primeArray = getPrimeArray();
        for (int i=0; i<T; i++){
            int N = s.nextInt();
            System.out.println(primeArray[N]);
        }
    }

    private static int[] getPrimeArray() {
        int max = 1000000;
        int [] prime = new int[max+1];
        Arrays.fill(prime, 1);

        prime[1] = 0;
        for (int i=2; i<=max; i++){
            if (prime[i] == 1){
                for (long j=i; i*j <= max; j++){
                    prime[(int) (i*j)] = 0;
                }
            }
            //do prefix sum
            prime[i] += prime[i-1];
        }
        return prime;
    }

    //instead of calculating prime array each time and counting the prime we can precompute it
    //i.e get prime array for max value of Ni.e 10^6 and do prefix sum that indicates the prime no till that N

//    private static int getPrimeInRange(long n) {
//        if (n <=1){
//            return 0;
//        }
//        int [] prime = new int[(int) (n+1)];
//        Arrays.fill(prime, 1);
//
//        prime[1] = 0;
//        int count = 0;
//        for (int i=2; i <= n; i++){
//            if (prime[ i] == 1){
//
//                for (long j=i; i*j <= n; j++){
//                    prime[(int) (i*j)] = 0;
//                }
//            }
//        }
//
//        return count;
//    }
}
