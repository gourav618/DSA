package BasicProgramming.Arrays;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ForgottenLanguage {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=609&sectionId=1&moduleId=0&topicId=42&subtopicId=585&assignmentId=93

//        3 2
//        piygu ezyfo rzotm
//        1 piygu
//        6 tefwz tefwz piygu ezyfo tefwz piygu

        Scanner s = new Scanner(System.in);
        String[] nK = s.nextLine().split(" ");
        String[] N = s.nextLine().split(" ");

        String[] output = new String[N.length];

        for (int i=0; i<Integer.parseInt(nK[1]); i++){
            String[] K = s.nextLine().split(" ");
            for (int j=0; j<Integer.parseInt(nK[0]); j++){
                for (int z=1; z<=Integer.parseInt(K[0]); z++){
                    if (Objects.equals(N[j], K[z])){
                        output[j] = "YES";
                    }else if (!Objects.equals(output[j], "YES")){
                        output[j] = "NO";
                    }
                }
            }
        }

        Arrays.stream(output).forEach(i -> System.out.print(i+" "));
    }
}
