package BasicProgramming.loops;

import java.util.Scanner;

public class MagicianVsChef {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=599&sectionId=1&moduleId=0&topicId=41&subtopicId=573&assignmentId=92

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int X = s.nextInt();
        int noOfSwaps = s.nextInt();

        s.nextLine();
        for (int i=0; i<noOfSwaps;i++){
            int a = s.nextInt();
            int b = s.nextInt();

            if (a !=X && b !=X){
                continue;
            }
            int currBox = 0;
            if (a != X){
                currBox = a;
            }else{
                currBox = b;
            }

            X = currBox != 0 ? currBox : X;
        }
        System.out.println(X);
    }
}
