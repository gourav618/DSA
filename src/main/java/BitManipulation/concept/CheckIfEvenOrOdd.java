package BitManipulation.concept;

import java.util.Scanner;

public class CheckIfEvenOrOdd {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        //check if the LSB is 1 then odd else even
        if ((n&1) == 1){ //if(n&1) -> both are same if (1) -> true i.e any non zero number
            System.out.println(n+" is odd");
        }else {
            System.out.println(n+" is even");
        }
    }
}
