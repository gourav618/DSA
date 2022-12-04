package Arrays.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=25&sectionId=1&moduleId=1&topicId=1&subtopicId=14&homeworkId=3

        Scanner s = new Scanner(System.in);

        int numRows = s.nextInt();

        List<List<Integer>> pascal = new ArrayList<>();

        pascal.add(0, List.of(1));

        for (int i=1; i<numRows; i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = pascal.get(i - 1);

            row.add(1);
            for (int j=1; j<i; j++){
                row.add(prevRow.get(j-1)+ prevRow.get(j));
            }
            row.add(1);
            pascal.add(row);
        }

        for (List<Integer> row: pascal){
            for (int i=0; i<row.size(); i++){
                System.out.print(row.get(i)+" ");
            }
            System.out.println();
        }
    }
}
