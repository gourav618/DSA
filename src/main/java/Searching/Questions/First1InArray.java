package Searching.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class First1InArray {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=108&sectionId=1&moduleId=2&topicId=6&subtopicId=68&homeworkId=14

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int l=0, h=N-1, ans=-1;
        while (l<=h){
            int mid = (l+h)/2;
            if (arr.get(mid) > 1){
                h = mid-1;
            }else if (arr.get(mid) < 1){
                l = mid+1;
            }else {
                if (mid == 0){
                    ans = mid+1;
                    break;
                }else if (arr.get(mid-1) != 1){
                    ans = mid+1;
                    break;
                }else {
                    h = mid-1;
                }
            }
        }
        System.out.println(ans);
    }
}
