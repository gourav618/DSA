package BasicProgramming.loops;

import java.util.Scanner;

public class AdaAndSchool {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=596&sectionId=1&moduleId=0&topicId=41&subtopicId=573&assignmentId=92

        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        s.nextLine();
        for (int i=0;i<t;i++){
            int n = s.nextInt();
            int m = s.nextInt();

            boolean isPossible = n % 2 == 0 || m % 2 == 0;

            System.out.println(isPossible ? "YES": "NO");
        }
    }
}
