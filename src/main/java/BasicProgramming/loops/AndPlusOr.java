package BasicProgramming.loops;

import java.util.Scanner;

public class AndPlusOr {
    public static void main(String[] args){
        //https://www.codechef.com/problems/ANDOR

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i=0; i<t; i++){
            long x = s.nextLong();
            for (int j=0; j<=x; j++){
                long a = j, b = x-a;
                if ((a&b)+(a|b) == x){
                    System.out.println(a+" "+b);
                    break;//if remove this its print all possible value of a and b
                }else {
                    System.out.println(-1);
                }
            }
        }
    }
}
