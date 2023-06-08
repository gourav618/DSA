package Searching.Questions;

import java.util.Scanner;

public class FIndSmallestGoodBase {
    public static void main(String[] args) {
        //https://dashboard.programmingpathshala.com/practice/question?questionId=107&sectionId=1&moduleId=2&topicId=6&subtopicId=82&assignmentId=17
        //https://www.geeksforgeeks.org/find-smallest-number-whose-digits-multiply-given-number-n/

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while (T-- > 0) {
            long n = s.nextLong();
            System.out.println(findSmallestGoodBase(n));
        }
    }

    private static long findSmallestGoodBase(long n) {
        for (int i=63; i>=1; i--){//no of digits in base

            long l = 2, h = n-1;
            while (l<=h){
                long m = (l+h)/2;//mid

                long val = 0, x=1;// val is sum of series 1+m+m2.. and x is to calculate nest term
                int flag=0; //if val>num we break and make flag=1 i.e we move to left side
                for (int j=0; j<=i; j++){
                    val += x; //update val with next term
                    if (val>=n){
                        break;
                    }
                    if (j<i && (n-val)/m < x)// to prevent overflow of x*m
                    {
                        flag = 1;
                        break;
                    }
                    if (j<i) x *= m; // calculate next term
                }

                if (val>n || flag==1){
                    h = m-1;
                }else if (val<n){
                    l = m+1;
                }else {
                    return m;
                }
            }
        }
        return -1;
    }
}
