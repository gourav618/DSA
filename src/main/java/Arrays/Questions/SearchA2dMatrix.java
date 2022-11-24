package Arrays.Questions;

public class SearchA2dMatrix {
    public static void main(String[] args){
        //https://leetcode.com/problems/search-a-2d-matrix-ii/

        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;

        int i=0, j = matrix[0].length-1, flag = 0;
        while (i < matrix.length && j>=0){
            if (matrix[i][j] == target){
                flag = 1;
                break;
            }
            if (matrix[i][j] > target){
                j--;
            }else {
                i++;
            }

        }

        System.out.println(flag == 1);
    }
}
