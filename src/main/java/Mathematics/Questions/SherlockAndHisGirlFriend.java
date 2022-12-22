package Mathematics.Questions;

import java.util.Arrays;
import java.util.Scanner;

public class SherlockAndHisGirlFriend {
    public static void main(String[] args){
        //https://codeforces.com/contest/776/problem/B

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int []prime = new int[n+2];
        Arrays.fill(prime, 1);

        prime[1] = 0;
        for (int i=2; i<=n+1; i++){
            if (prime[i] == 1){
                for (long j=i; j*i<=n+1; j++){
                    prime[(int) (i*j)] = 0;
                }
            }
        }

        if (n > 2){
          System.out.println("2");
        }else {
            System.out.println("1");
        }

        for (int i=2; i<=n+1; i++){
            if (prime[i] == 1){
                System.out.print("1 ");
            }else {
                System.out.print("2 ");
            }
        }
    }
}
