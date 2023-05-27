package Searching.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OnlyRepeatedElement {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=100&sectionId=1&moduleId=2&topicId=6&subtopicId=72&assignmentId=15

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int l=0, h=N-1, ans=-1;
        while (l<=h){
            int mid = (l+h)/2;
            if (arr.get(mid) == mid){
                h = mid-1;
            }
            else {
                if (arr.get(mid+1) == arr.get(mid)){
                    ans = arr.get(mid);
                    break;
                }else {
                    l = mid+1;
                }
            }
        }
        System.out.println(ans);
    }
}
