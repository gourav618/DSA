package Searching.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PairSumSorted {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=109&sectionId=1&moduleId=2&topicId=6&subtopicId=68&homeworkId=14

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int target = s.nextInt();

        for (int i=0; i<N; i++){
            int keyToFind = target-arr.get(i);
            int index = search(i + 1, N - 1, keyToFind, arr);
            if (index != -1){
                System.out.println((i+1) +" "+ (index+1));
                break;
            }
        }
    }

    private static int search(int l, int h, int key, List<Integer> arr) {
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
        return -1;
    }
}
