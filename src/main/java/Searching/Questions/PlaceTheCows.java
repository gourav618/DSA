package Searching.Questions;

import java.util.Arrays;
import java.util.Scanner;

public class PlaceTheCows {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=105&sectionId=1&moduleId=2&topicId=6&subtopicId=82&assignmentId=17
        //https://www.geeksforgeeks.org/place-the-cows-in-the-fields-such-that-they-are-at-the-minimum-distance-from-each-other/

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] arr = new long[n];
        for (int i=0;i<n; i++){
            arr[i] = s.nextLong();
        }
        int T = s.nextInt();
        Arrays.sort(arr);
        while (T-- > 0){
            long c = s.nextLong();
            System.out.println(findMaxDistanceOfPlacingTheCows(arr, n, c));
        }
    }

    private static long findMaxDistanceOfPlacingTheCows(long[] arr, int n, long c) {
        long l = findLowerRange(arr, n);
        long h = arr[n-1]-arr[0];
        while (l<=h){
            long mid = l + (h-l)/2;
            boolean r = isPlacementPossible(arr, n, mid, c);
            if (!r){
                h = mid-1;
            }else {
                boolean r1 = isPlacementPossible(arr, n, mid + 1, c);
                if (!r1){
                    return mid;
                }else {
                    l = mid+1;
                }
            }
        }
        return 0;
    }

    private static boolean isPlacementPossible(long[] arr, int n, long m, long c) {
        long count=1, prev = arr[0];
        for (int i=1; i<n; i++){
            if (arr[i]-prev < m){
                continue;
            }else {
                count++;
                prev = arr[i];
            }
        }
        return count >= c;
    }

    private static long findLowerRange(long[] arr, int n) {
        long l = Long.MAX_VALUE;
        for (int i = 0; i< n -1; i++){
            l = Math.min(arr[i+1]- arr[i], l);
        }
        return l;
    }
}
