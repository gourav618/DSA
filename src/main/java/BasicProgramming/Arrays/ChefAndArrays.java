package BasicProgramming.Arrays;

import java.util.Scanner;

public class ChefAndArrays {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=605&sectionId=1&moduleId=0&topicId=42&subtopicId=585&assignmentId=93

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();
        for (int i=0; i<T; i++) {
            int Na = s.nextInt();
            s.nextLine();
            String[] A = s.nextLine().split(" ");
            int Nb = s.nextInt();
            s.nextLine();
            String[] B = s.nextLine().split(" ");

            for (int j=0; j<Na; j++){
                String no = (Integer.parseInt(A[j]) >= Integer.parseInt(B[j])) ? (A[j] + B[j]) : (B[j] + A[j]);
                System.out.print( no.equals("00") ? "0 " : no+" ");
            }
            System.out.println();
        }
    }
}
