package BasicProgramming.TwoDimensionalArray;

import java.util.Scanner;

public class SearchInMatrix {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=616&sectionId=1&moduleId=0&topicId=43&subtopicId=602&assignmentId=94

        Scanner s = new Scanner(System.in);
        int m = s.nextInt(), n = s.nextInt();
        s.nextLine();
        int [][]mat = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                mat[i][j] = s.nextInt();
            }
            s.nextLine();
        }
        int target = s.nextInt(), flag = 0;

        for (int i=0; i<m; i++){
            if (target >= mat[i][0] && target <= mat[i][n-1]) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == target){
                        flag = 1;
                    }
                }
            }
        }

        if (flag == 1){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
