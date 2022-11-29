package Arrays.Questions;

public class RowWithMaximumOnes {
    public static void main(String[] args){
        //https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1

        //input
        int [][]arr = {{0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};
        int n = 4, m = 4;


        int row_number = -1, prev_j = Integer.MAX_VALUE;
        for (int i=0; i<n;i++){
            for (int j=0; j<m;){

                if (arr[i][j] == 0){
                    j++;
                } else {
                    if (j < prev_j) {
                        row_number = i;
                    }
                    prev_j = Math.min(prev_j, j);
                    break;
                }
            }
        }
        System.out.println(row_number);
    }
}
