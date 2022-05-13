package Arrays;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PreComputationTechnique {


    public static void main(String[] args){
        // In the given problem, there is an integer array ‘Arr[N]’ and we have to print the individual sum of ‘Q’ subarrays whose
        // first index - ‘l’ and the last index - ‘r’ is given

        int [] arr = {1,2,3,4,5};
        String Q = "1,2 1,3 1,4 0,0";
        System.out.println(LocalDateTime.now());
        //using bruteForce
        Arrays.stream(Q.split(" ")).forEach(q -> {
            List<String> collect = Arrays.stream(q.split(",")).collect(Collectors.toList());
            long l = sumOfQueryBruteForce(arr, Integer.parseInt(collect.get(0)), Integer.parseInt(collect.get(1)));

            System.out.println( "by brute force "+ q + " --> " + l);
        } );

        System.out.println(LocalDateTime.now());
        // using prefixSum
        int[] prefixSumArray = getPrefixMaxSumArray(arr);
        Arrays.stream(Q.split(" ")).forEach(q -> {
            List<String> collect = Arrays.stream(q.split(",")).collect(Collectors.toList());
            long l = 0l;
            if (Integer.parseInt(collect.get(0)) == 0){
                l = prefixSumArray[Integer.parseInt(collect.get(1))];
            }
            else {
                l = prefixSumArray[Integer.parseInt(collect.get(1))] - prefixSumArray[Integer.parseInt(collect.get(0)) - 1];
            }

            System.out.println( "by prefix max sum "+ q + " --> " + l);
        } );
        System.out.println(LocalDateTime.now());

        // In the given problem, there is an integer array ‘Arr[N]’ and we have to print the individual sum of ‘Q’ subarrays whose
        // int idx -> max elem from 0 .... to idx
        int [] arr1 = {5, -1, 0, 4, 2, 7};
        String idx = "0 1 2 3 4";

        System.out.println(LocalDateTime.now());
        // using prefixMax
        int[] prefixMaxElementArray = getPrefixMaxElementArray(arr1);
        Arrays.stream(idx.split(" ")).forEach(q -> {
            System.out.println( "by prefix max Element "+ q + " --> " + prefixMaxElementArray[Integer.parseInt(q)]);
        } );
        System.out.println(LocalDateTime.now());
    }

//    Create two nested loops to print the sum of different subarrays respectively.
//    Time Complexity: O(Q*N) --> since will we called for q queries
//    Space Complexity: O(1)
    private static long sumOfQueryBruteForce(int[] arr, int l, int r) {
        long sum = 0;
        for (int i = l; i <= r; i++){
            sum += arr[i];
        }
        return sum;
    }

    private static int[] getPrefixMaxSumArray(int [] arr){
        for (int i=1; i<arr.length; i++){
            arr[i] += arr[i-1];
        }
        return arr;
    }

    private static int[] getPrefixMaxElementArray(int [] arr){

        for (int i=1; i< arr.length; i++){
            //System.out.println(Math.max(arr[i-1] , arr[i]));
            arr[i] = Math.max(arr[i-1] , arr[i]);
        }
        return arr;
    }
}