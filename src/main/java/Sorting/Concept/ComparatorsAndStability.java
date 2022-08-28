package Sorting.Concept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorsAndStability {
    public static void main(String [] args){

//        In sorting, the order between two elements is decided using the comparator function.
//        In Java, the return value of a comparator should be an integer.
//                Let’s say we pass two elements to the comparator function - e1,e2.
//                  When the comparator returns a negative number, the sorting algorithm places the 1st element before the 2nd one.
//                  When the comparator returns a positive number, the sorting algorithm places the 2nd element before the 1st one.
//                  When the comparator returns zero, the relative order between the elements is not changed.
//                  If we need stability in our sorting function, we should return zero for equal elements.


        //int []arr = {7, -1, 2, 9, 5};
        List<Integer> arr = new ArrayList<>();
        arr.add(7);
        arr.add(-1);
        arr.add(2);
        arr.add(9);
        arr.add(5);

        //sort in asc order
        sortArrayUsingSortFUnction(arr);
        System.out.println(arr);

        //sort in desc order
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(7);
        arr1.add(-1);
        arr1.add(2);
        arr1.add(9);
        arr1.add(5);
        sortDescOrderUsingSort(arr1);
        System.out.println(arr1);

        //Stable sort using comparator
//        List<Integer> arr2 = new ArrayList<>();
//        arr2.add(5);
//        arr2.add(-1);
//        arr2.add(2);
//        arr2.add(9);
//        arr2.add(5);
//        stableSortUsingSortFunction(arr2);
//        System.out.println(arr2);

        //no need for all this for stable sort since we return 0 for same element and the stability is maintained..
    }

//    private static void stableSortUsingSortFunction(List<Integer> arr) {
//        List<List<Integer>> v = new ArrayList<>();
//        for (int i=0; i< arr.size(); i++){
//            List<Integer> toAdd = new ArrayList<>();
//            toAdd.add(arr.get(i));
//            toAdd.add(i);
//            v.add(toAdd);
//        }
//
//        Collections.sort(v, (p1, p2) -> {
//            if (p1.get(0) != p2.get(0)){
//                if (p1.get(0) < p2.get(0)){
//                    return -1;
//                }else {
//                    return 1;
//                }
//            }
//            else {
//                if (p1.get(1) < p2.get(1)){
//                    return -1;
//                }else {
//                    return 1;
//                }
//            }
//        });
//    }

    private static void sortDescOrderUsingSort(List<Integer> arr1) {
        Collections.sort(arr1, (p1,p2)->{
            if (p1 < p2)
                return 1;
            else if (p1 > p2)
                return -1;
            else
                return 0;
        });
    }

    private static void sortArrayUsingSortFUnction(List<Integer> arr) {
        Collections.sort(arr, ( p1, p2) -> {
            if (p1<p2) {
                return -1;
            }else if (p2 > p1){
                return 1;
            }else {
                return 0;
            }
        });
    }
}
