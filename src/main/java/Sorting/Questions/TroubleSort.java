package Sorting.Questions;

import java.util.Arrays;
import java.util.Scanner;

public class TroubleSort {
    public static void main(String[] args){
        //https://codingcompetitions.withgoogle.com/codejam/round/00000000000000cb/00000000000079cb#problem

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        int test = 1;
        while (test <= t){
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i=0; i<n; i++){
                arr[i] = s.nextInt();
            }
            troubleSort(arr, n);

            boolean done = false;
            for (int i=0; i<n-1; i++){
                if (arr[i] > arr[i+1]){
                    System.out.println("Case #"+test+": "+i);
                    done = true;
                }
            }
            if (!done){
                System.out.println("Case #"+test+": OK");
            }
            test++;
        }

    }

    //applying trouble sort without using trouble sort algorithm
    private static void troubleSort(int[] arr, int n) {
        int[] even = new int[n/2 + n%2];
        int[] odd = new int[n/2];
        for (int i=0; i<n; i++){
            if (i%2 == 0){
                even[i/2] = arr[i];
            }else {
                odd[i/2] = arr[i];
            }
        }
        Arrays.sort(even);
        Arrays.sort(odd);
        for (int i=0; i<n; i++){
            if (i%2 == 0){
                arr[i] = even[i/2];
            }else {
                arr[i] = odd[i/2];
            }
        }
    }
}
