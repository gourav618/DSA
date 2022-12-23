package Mathematics.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindingPrimes {
    public static void main(String []args) throws IOException {
        //https://dashboard.programmingpathshala.com/practice/question?questionId=42&sectionId=1&moduleId=1&topicId=2&subtopicId=25&homeworkId=5

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine().split(" ")[0]);

        int max=1000001;
        int[] prime=new int[max+1];
        prime[1]=1;
        for(int i=2;i*i<=max;i++){
            if(prime[i]==0){
                for(int j=i;j*i<=max;j++)
                    prime[i*j]=1;
            }
        }

        int[] counts=new int[max+1];
        for(int i=1;i<=max;i++)
            counts[i]=counts[i-1]+(prime[i]==0?1:0);

        while(t-->0){
            int n=Integer.parseInt(br.readLine().split(" ")[0]);
            System.out.println(counts[n]-counts[n/2]);
        }
    }
}
