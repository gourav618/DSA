package BasicProgramming.loops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ComparingPowers {
    public static void main(String[] args){
        //Danya gave integers a, b and n to Archi. Archi wants to compare a^n and b^n. Help Archi with this task.
        //Input Format
        //The first line of the input contains a single integer T denoting the number of test cases. The description of T
        // test cases follows.
        //The first and only line of each test case contains three space-separated integers a, b and n

        //https://dashboard.programmingpathshala.com/practice/question?questionId=595&sectionId=1&moduleId=0&topicId=41&subtopicId=573&assignmentId=92

//        pow() function also operates in O(n) time complexity which is not acceptable. Also in this problem,
//        you actually don't have to calculate the a^n and b^n and then compare them but here we have to check them using the properties of the exponent. For example
//
//        if a > 0 and b > 0 and a > b then a^n > b^n for all n > 0 similarly for other cases

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for (int i=0; i<T; i++) {
            long a = s.nextLong();
            long b = s.nextLong();
            long n = s.nextLong();

            if (a>0 && b>0){
                if (a > b){
                    System.out.println(1);
                }else if (a < b){
                    System.out.println(2);
                }else {
                    System.out.println(0);
                }
            }else if (a<0 && b>0){
                if (n%2 ==0){
                    if (Math.abs(a) > b){
                        System.out.println(1);
                    }else if (Math.abs(a) < b){
                        System.out.println(2);
                    }else {
                        System.out.println(0);
                    }
                }else {
                    System.out.println(2);
                }
            }else if (a>0 && b<0){
                if (n%2 == 0){
                    if (a > Math.abs(b)){
                        System.out.println(1);
                    }else if (a < Math.abs(b)){
                        System.out.println(2);
                    }else {
                        System.out.println(0);
                    }
                }else {
                    System.out.println(1);
                }
            }else {// a<0 && b<0
                if (n%2 == 0){
                    if (a > b){
                        System.out.println(2);
                    }else if (a < b){
                        System.out.println(1);
                    }else {
                        System.out.println(0);
                    }
                }else {
                    if (a > b){
                        System.out.println(1);
                    }else if (a < b){
                        System.out.println(2);
                    }else {
                        System.out.println(0);
                    }
                }
            }
        }
    }
}
