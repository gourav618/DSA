package Arrays.Questions;

import java.util.ArrayList;
import java.util.List;

public class leftRotateArray {
    public static void main(String[] args){
        //https://www.hackerrank.com/challenges/array-left-rotation/problem?isFullScreen=true

        List<Integer> arr = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> integers = rotateLeft(4, arr);
        System.out.println(integers);
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        int requiredRotation  = d % arr.size();
        //reverse part1 0 to d-1
        reverseArrayInRange(arr, 0, requiredRotation-1);
        //reverse part2 d to n-1
        reverseArrayInRange(arr, requiredRotation, arr.size()-1);
        //reverse whole array
        reverseArrayInRange(arr, 0, arr.size()-1);
        return arr;
    }

    private static void reverseArrayInRange(List<Integer> arr, int i, int j){
        for (int p=i; p<j; p++, j--){
            int temp = arr.get(p);
            arr.set(p, arr.get(j));
            arr.set(j, temp);
        }
    }
}
