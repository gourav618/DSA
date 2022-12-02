package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SpiralMatrix {
    public static void main(String []args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=26&sectionId=1&moduleId=1&topicId=1&subtopicId=14&homeworkId=3

        Scanner s  = new Scanner(System.in);
        List<Integer> mn = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int [][]mat = new int[mn.get(0)][mn.get(1)];
        for (int i=0; i< mn.get(0); i++){
            for (int j=0; j< mn.get(1); j++){
                mat[i][j] = s.nextInt();
            }
        }

        int nr = mn.get(0)-1;
        int nc = mn.get(1)-1;
        int i=0,j=0;
        while(i<=nr && j<=nc){
            for(int c=j;c<=nc;c++)
                System.out.print(mat[i][c]+ " ");
            for(int r=i+1;r<=nr;r++)
                System.out.print(mat[r][nc]+" ");
            if(i<nr && j<nc){
                for(int c=nc-1;c>j;c--)
                    System.out.print(mat[nr][c]+" ");
                for(int r=nr;r>j;r--)
                    System.out.print(mat[r][j]+" ");
            }
            i++;
            nr--;
            j++;
            nc--;

        }

    }
}
