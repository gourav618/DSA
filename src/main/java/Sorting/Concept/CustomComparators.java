package Sorting.Concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomComparators {
    public static void main(String[] args){
//        Custom Comparators
//        In this lecture, we will learn how to write custom comparators by discussing a few problems.
//
//        Q. We have been given the coordinates of ‘N’ points and we have to find the first ‘k’ points which are closest to the origin.
//
//                Approach: We can create a comparator function to sort the points according to their distance (d=√(x^2 + y^2)) from the origin.
//                Note: We can compare (x^2+y^2) rather than √(x^2 + y^2) for faster calculation.

        findFirstKthPointsCloserToOrigin();

//        Q. We have been given an array Arr[N] such that 0<=Arr[ i ]<=100 and we have to sort it according to the following rule:
//
//        Smaller frequency elements should come first
//        Smaller value element should come first if the frequency is same
//        Smaller index element should come first if the value is same
//        Approach:
//
//        We can initialise a frequency array f[101] with 0 to count the frequency of each value.
//                We can create a structure containing the frequency, value & index of an element and pass it to the comparator
//                function for sorting the array according to the given conditions.
//        Note: The time complexity is equal to O(NlogN) which is typically the time taken by the default sort function in the language library.

        sortArrayAccordingToRule();
    }

    public static class Triplet{
        int val;
        int freq;
        int index;
    }
    private static void sortArrayAccordingToRule() {
        List<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(2);
        arr.add(3);
        arr.add(5);
        arr.add(2);

        //init frequency array with 0
        int []freq = new int[101];
        Arrays.fill(freq, 0);
        //update freq of elements in array
        for (int i=0; i< arr.size(); i++){
            freq[arr.get(i)]++;
        }
        //convert the arr to list of triplet
        List<Triplet> vec = new ArrayList<>();
        for (int i=0; i< arr.size(); i++){
            Triplet t = new Triplet();
            t.val = arr.get(i);
            t.freq = freq[arr.get(i)];
            t.index = i;
            vec.add(t);
        }

        vec.sort((p1, p2) -> {
            if (p1.freq != p2.freq){
                if (p1.freq < p2.freq)
                    return -1;
                else if (p2.freq > p1.freq)
                    return 1;
                else
                    return 0;
            }
            if (p1.val != p2.val){
                if (p1.val < p2.val)
                    return -1;
                else if (p2.val > p1.val)
                    return 1;
                else
                    return 0;
            }
            if (p1.index < p2.index)
                return -1;
            else if (p2.index > p1.index)
                return 1;
            else
                return 0;
        });

        for (Triplet v : vec){
            System.out.print(v.val+" : "+v.freq+" : "+v.index+" , ");
        }
    }

    private static void findFirstKthPointsCloserToOrigin() {
        List<List<Integer>> points = new ArrayList<>();
        points.add(List.of(2,3));
        points.add(List.of(3,2));
        points.add(List.of(2,5));
        points.add(List.of(1,5));
        points.add(List.of(4,5));
        points.add(List.of(-2,-5));

        points.sort((p1, p2) -> {
            int d1 = (p1.get(0) * p1.get(0)) + (p1.get(1) * p1.get(1));
            int d2 = (p2.get(0) * p2.get(0)) + (p2.get(1) * p2.get(1));

            if (d1 < d2) {
                return -1;
            } else if (d2 > d1) {
                return 1;
            } else {
                return 0;
            }
        });

        System.out.println(points);

        int k = 2;
        System.out.println(points.get(k-1));
    }
}
