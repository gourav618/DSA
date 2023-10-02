package BitManipulation.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MissingAPoint {
    public static void main(String[] args) throws IOException {
        //https://www.codechef.com/JULY20B/problems/PTMSSNG?tab=statement
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int xx=0, yy=0;
            for (int i=0; i<(4*n - 1); i++){
                int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                xx ^= xy[0];
                yy ^= xy[1];
            }
            System.out.println(xx+" "+yy);
        }
    }
}
