package Mathematics.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MakingTeams {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=46&sectionId=1&moduleId=1&topicId=2&subtopicId=36&assignmentId=7

        Scanner s = new Scanner(System.in);

        //populate pascal triangle to get nCr values
        long [][] pascal = new long[61][61];
        pascal[0][0]=1;

        for (int i=1; i<61; i++){
            for (int j=0; j<=i; j++){
                if (j == 0 || j == i){
                    pascal[i][j] = 1;
                }else {
                    pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
                }
            }
        }

        int T = s.nextInt(); s.nextLine();

        while (T-- > 0){
            List<Integer> nMx = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            int n = nMx.get(0), m = nMx.get(1), x = nMx.get(2);

            long ans = 0;
            ans += pascal[n+m][x];

            if (x <= m){
                ans -= pascal[m][x];
            }
            if (x-1<=m){
                ans -= n * pascal[m][x-1];
            }
            if (x-2<=m){
                ans -= (((long) n *(n-1))/2) * pascal[m][x-2];
            }
            if (x-3<=m){
                ans -= (((long) n *(n-1)*(n-2))/6) * pascal[m][x-3];
            }
            if (x<=n){
                ans -= pascal[n][x];
            }

            System.out.println(ans);
        }
    }
}
