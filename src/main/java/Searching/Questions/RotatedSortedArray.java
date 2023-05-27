package Searching.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RotatedSortedArray {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=98&sectionId=1&moduleId=2&topicId=6&subtopicId=72&assignmentId=15

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int T = s.nextInt();
        s.nextLine();
        int pivot = findPivot(arr, N);
        while (T-- > 0){
            int target = s.nextInt();
            if (pivot != -1 && target <= arr.get(N-1)){
                System.out.println(search(arr, target, pivot+1, N-1));
            }else if (pivot != -1 && target >= arr.get(N-1)){
                System.out.println(search(arr, target, 0, pivot));
            }
            else {
                System.out.println(search(arr, target, 0, N-1));
            }
        }
    }

    private static int search(List<Integer> arr, int target, int l, int h) {
        while (l<=h){
            int mid = (l+h)/2;
            if (arr.get(mid) == target){
                return mid;
            } else if (arr.get(mid) > target) {
                h = mid-1;
            }else {
                l = mid+1;
            }
        }
        return -1;
    }

    private static int findPivot(List<Integer> arr, int N) {
        int l=0, h=N-1;
        while (l<=h){
            int mid = (l+h)/2;
            if (arr.get(mid) <= arr.get(N-1)){
                h = mid-1;
            }else {
                if (arr.get(mid) > arr.get(mid+1)){
                    return mid;
                }else {
                    l = mid+1;
                }
            }
        }
        return -1;
    }
}
