package Searching.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FirstAndLastPosition {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int T = s.nextInt();
        s.nextLine();
        while (T-- > 0){
            int key = s.nextInt();
            int firstPosition = findFirstOrLastPosition(0, N - 1, key, arr, true);
            if (firstPosition != -1){
                int lastPosition = findFirstOrLastPosition(0, N - 1, key, arr, false);
                System.out.println((firstPosition+1) +" "+ (lastPosition+1));
            }else {
                System.out.println(firstPosition);
            }
        }
    }

    private static int findFirstOrLastPosition(int l, int h, int key, List<Integer> arr, boolean findFirstIndex) {
        int ans = -1;
        while (l<=h){
            int mid = (l+h)/2;
            if (arr.get(mid) > key){
                h = mid-1;
            } else if (arr.get(mid) < key) {
                l = mid+1;
            }else {
                ans = mid;
                if (findFirstIndex){
                    h = mid-1;
                }else {
                    l = mid+1;
                }
            }
        }
        return ans;
    }
}
