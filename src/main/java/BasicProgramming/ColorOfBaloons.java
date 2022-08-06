package BasicProgramming;

import java.util.Scanner;

public class ColorOfBaloons {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        s.nextLine();
        for(int i=0;i<t;i++){
            String n = s.nextLine();
            int countA=0, countB=0;
            for(int j=0; j<n.length(); j++){
                if(n.charAt(j) == 'a')
                    countA++;
                if(n.charAt(j) == 'b')
                    countB++;
            }

            if (countA > countB){
                System.out.println(countB);
            }else if (countB > countA){
                System.out.println(countA);
            }else {
                System.out.println(countA);
            }
        }
    }
}
