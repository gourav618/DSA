package Mathematics.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountOfDivisorsForMultipleQueries {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/practice/question?questionId=32&sectionId=1&moduleId=1&topicId=2&subtopicId=25&assignmentId=5

        //Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 1000000;
        //get prime and spf array
        int [] prime = new int[max+1];
        int [] spf = new int[max+1];
        Arrays.fill(prime, 1);
        Arrays.fill(spf, -1);

        for (int i=2; i<= (int)Math.sqrt(max); i++){
            if (prime[i] == 1){
                for (int j=i; i*j <= max; j++){
                    if (prime[i*j] == 1){
                        spf[i*j] = i;
                        prime[i*j] = 0;
                    }
                }
            }
        }

        //counting prime factors
        for (int i=2; i<=max; i++){
            int n = i;
            int factor = spf[n];
            int count = 0;

            while (spf[n] != -1){
                n = n/spf[n];
                if (factor != n && factor != spf[n])
                    count++;
                if (spf[n] == -1)
                    count++;
                factor = spf[n];
            }
            if (count != 0)
                prime[i] = count;
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];
            String[] str = br.readLine().trim().split("\\s+");
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(str[i]);
            }

            for (int i=0; i<N; i++){
                System.out.print(prime[arr[i]]+" ");
            }
            System.out.println();
        }
    }
}
