package Searching.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SearchIn2dMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        Integer[] dim = Arrays.stream(s.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int[][] mat = new int[dim[0]][dim[1]];
        for (int i=0; i<dim[0]; i++){
            Integer[] row = Arrays.stream(s.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            for (int j=0; j<dim[1]; j++){
                mat[i][j] = row[j];
            }
        }

        int T = Integer.parseInt(s.readLine());
        while (T-- > 0){
            int target = Integer.parseInt(s.readLine());
            boolean flag = false;
            for (int i=0; i<dim[0]; i++){
                int[] row = mat[i];
                if (target >= row[0] && target <= row[dim[1]-1]){
                    flag = search(row, target);
                    break;
                }
            }
            System.out.println(flag);
        }

    }

    private static boolean search(int[] row, int target) {
        int l=0, h = row.length-1;
        while (l<=h){
            int mid = (l+h)/2;
            if (row[mid] == target){
                return true;
            }else if (row[mid] < target){
                l = mid+1;
            }else {
                h = mid-1;
            }
        }
        return false;
    }
}
