package Sorting.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdaAndUnstableSort {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=148&sectionId=1&moduleId=2&topicId=7&subtopicId=85&homeworkId=18
        //https://www.codechef.com/problems/ADASORT

//        let's take the test case arr=5 5 2 2 3
//
//        we assign indices to each of these element
//
//        (5,1),(5,2),(2,3),(2,4),(3,5)
//
//        we want to sort the original array, but we also want that for elements that are equal, their relative order should not be the same as earlier
//
//        eg:(2,4) should come before (2,3)
//
//        therefore for final answer we can say that their indices will be ordered in following way
//
//        4,3,5,2,1

        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());

        while (t-- > 0){
            int n = Integer.parseInt(s.nextLine());
            Integer[] arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            unstableSort(arr, n);
        }
    }

    static class Pair{
        int elem;
        int index;
    }
    private static void unstableSort(Integer[] arr, int n) {
        List<Pair> elem = new ArrayList<>();
        for (int i=0; i< arr.length; i++){
            Pair p = new Pair();
            p.elem = arr[i];
            p.index = i+1;
            elem.add(p);
        }


        elem.sort((e1, e2) -> {
            if (e1.elem == e2.elem){
                return Integer.compare(e2.index, e1.index);
            }else {
                return Integer.compare(e1.elem, e2.elem);
            }
        });

        for (Pair e : elem){
            System.out.print(e.index+" ");
        }
        System.out.println();
    }
}
