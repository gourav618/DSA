package BasicProgramming.loops;

import java.util.Objects;
import java.util.Scanner;

public class Laddu {
    public static void main(String[] args){
        //https://www.codechef.com/problems/LADDU

//        2
//        4 INDIAN
//        CONTEST_WON 1
//        TOP_CONTRIBUTOR
//        BUG_FOUND 100
//        CONTEST_HOSTED
//        4 NON_INDIAN
//        CONTEST_WON 1
//        TOP_CONTRIBUTOR
//        BUG_FOUND 100
//        CONTEST_HOSTED

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        s.nextLine();

        for (int i=0; i<t; i++){
            String[] actOrg = s.nextLine().split(" ");
            int ladduCount=0;

            for (int j=0; j< Integer.parseInt(actOrg[0]); j++){
                String[] activity = s.nextLine().split(" ");
                if (Objects.equals(activity[0], "CONTEST_WON")){
                    ladduCount += 300;
                    int rank = Integer.parseInt(activity[1]);
                    if (rank <=20){
                        ladduCount += (20 - rank);
                    }
                }
                if (Objects.equals(activity[0], "TOP_CONTRIBUTOR")){
                    ladduCount += 300;
                }
                if (Objects.equals(activity[0], "BUG_FOUND")){
                    ladduCount += Integer.parseInt(activity[1]);
                }
                if (Objects.equals(activity[0], "CONTEST_HOSTED")){
                    ladduCount += 50;
                }
            }

            if (Objects.equals(actOrg[1], "INDIAN")){
                System.out.println(ladduCount/200);
            }else {
                System.out.println(ladduCount/400);
            }
        }
    }
}
