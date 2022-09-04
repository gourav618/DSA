package Sorting.Concept;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String [] args){
        int []arr = {10,2,5,1,3,7};

        for (int i=0; i< arr.length; i++){
            //find min in i to N-1 and swap with ith index
            int min = Integer.MAX_VALUE, index = -1;
            for (int j=i; j< arr.length; j++){
                if (arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            //swap with i
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }

        Arrays.stream(arr).forEach(i -> System.out.print(i+" "));
    }
}
