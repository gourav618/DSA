package Arrays.Questions;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StarSky {
    public static void main(String [] args) throws IOException {
        //https://dashboard.programmingpathshala.com/practice/question?questionId=17&sectionId=1&moduleId=1&topicId=1&subtopicId=11&homeworkId=2

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader s = new BufferedReader(r);

        List<Integer> nqc = Arrays.stream(s.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int [][][] mat = new int [nqc.get(2)+1][101][101];
        for (int i=0; i<nqc.get(0); i++){
            //int x1 = s.read(), x2 = s.read(), si = s.read();
            List<Integer> xys = Arrays.stream(s.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            mat[xys.get(2)][xys.get(0)][xys.get(1)]++;
        }

        for (int k=0; k<= nqc.get(2); k++){
            for (int i=1; i<101; i++){
                for (int j=1; j<101; j++){
                    mat[k][i][j] += mat[k][i-1][j] + mat[k][i][j-1] - mat[k][i-1][j-1];
                }
            }
        }

        for (int i=0; i< nqc.get(1); i++){
            List<Integer> txy = Arrays.stream(s.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            //int t = s.read(), x1 = s.read(), y1 = s.read(), x2 = s.read(), y2 = s.read();
            int ans = 0;

            for (int k=0; k<=nqc.get(2); k++){
                int bright = (k + txy.get(0)) % (nqc.get(2)+1);
                int rect = mat[k][txy.get(3)][txy.get(4)] - mat[k][txy.get(1)-1][txy.get(4)]
                        - mat[k][txy.get(3)][txy.get(2)-1] + mat[k][txy.get(1)-1][txy.get(2)-1];
                ans += (bright* rect);
            }
            System.out.println(ans);
        }
    }
}
