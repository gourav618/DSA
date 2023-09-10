package BitManipulation.concept;

import java.util.Scanner;

public class CheckIfithBitIsSetOrUnset {
    public static void main(String[] args){
        //without using bitwise we have to generate all bit and maintain the count
        // and when count ith then we return the bit at that count

        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int i = s.nextInt();

        //we create a mask where the ith bit is 1 and perform the AND operation to check if ith bit is 1
        long mask = (1L<<i);

        if ((num & mask) == 0){
            System.out.println(0);
        }else {
            System.out.println(1);
        }
    }
}
