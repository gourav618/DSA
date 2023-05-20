package Searching.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IndexOfInsertion {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int T = s.nextInt();
        s.nextLine();
        while (T-- > 0){
            int key = s.nextInt();
            s.nextLine();
            int indexOfInsertion = findIndexOfInsertion(0, N-1, key, arr);
            System.out.println(indexOfInsertion);
        }
    }

    private static int findIndexOfInsertion(int l, int h, int key, List<Integer> arr) {
        while (l<=h){
            int mid = (l+h)/2;
            if (arr.get(mid) == key){
                return mid;
            } else if (arr.get(mid) < key) {
                l = mid+1;
            }else {
                h = mid-1;
            }
        }
        return l;
    }
}
