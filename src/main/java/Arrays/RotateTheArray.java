package Arrays;

//Given int arr[N] and int K
// rotate the array clockwise by k units
// ex: [1 5 2 4 3] and k = 3  rotation1 [3 1 5 2 4]
//                            rotation2 [4 3 1 5 2]
//                            rotation3 [2 4 3 1 5]  i.e pick 3 elem to end and bring to front

import java.util.Arrays;

public class RotateTheArray {

    public static void main (String [] args){

        int arr[] = {5,0,1,4,2};
        int k = 3;

        int[] rotatedByBruteForce = rotateByBruteForce(arr.clone(), k);
        Arrays.stream(rotatedByBruteForce).forEach(p -> System.out.print(p + " "));
        System.out.println();

        // for optimization we can see that after N rotation we get back the original array
        // ex: [1 0 2] --1 rot--> [2 1 0] --2 rot--> [0 2 1] --3 rot--> [1 0 2] i.e get back the same arrray
        // if  rotated more we get the same array after rotating the original one by 1 unit and so on..
        // So instead of rotating by k-units we can rotate the array by k % N units
        int[] rotateUntilModulo = rotateUntilModulo(arr.clone(), k);
        Arrays.stream(rotateUntilModulo).forEach(p -> System.out.print(p + " "));
        System.out.println();

        //to optimize the time complexity , using extra array of same size
        //and place each elem in rightfull position in new array
        //  and position can be determined using modulo operator
        // i,e temp [i+k] = arr[i] place ith elem from arr to remp i+k position
        //if i+k >=N then place it in (i+k) % N in temp arr
        // so , temp[(i+k) % N] = arr[i] for each elem to 0 to N-1 where temp[] is a new arr
        int[] rotateUsingTempArray = rotateUsingTempArray(arr.clone(), k);
        Arrays.stream(rotateUsingTempArray).forEach(p -> System.out.print(p + " "));
        System.out.println();

        //using reversal of array ex: k=3 [1 5 2 4 3] when we reverse this array we get [3 4 2 5 1] but when we rotate 3 unit we get [2 4 3 1 5]
        // since k = 3 we have 2 parts in original array i.e p1 -> {2 4 3} p2 -> {1 5} since k =3 and we roatae last p1 elem to first and  p2 to last
        // and if we notice reverted array is reverse of p1 and p2
        // so our approach would be reverse p2 and p1 reverse individually [5 1 3 4 2]
        // and then reverse this whole array we get array [2 4 3 1 5] rotated by 3 units
        // so the part from end of array will be k i.e p1 and part from front would be N-k i.e p2
        int[] rotateUsingReversalMethod = rotateUsingReversalMethod(arr.clone(), k);
        Arrays.stream(rotateUsingReversalMethod).forEach(p -> System.out.print(p + " "));
        System.out.println();
    }

    // time 0(N) ans space -> 0(1)
    private static int[] rotateUsingReversalMethod(int[] arr, int k) {
        //reverse array individually in parts
        //reverse right part
        reverseArray(arr, arr.length-k, arr.length-1);
        //reverse left part
        reverseArray(arr, 0, arr.length-k-1);
        //reverse whole array
        reverseArray(arr, 0, arr.length-1);

        return arr;
    }

    //reverse array in given range
    private static void reverseArray(int [] arr, int i, int j){

        for (int p = i; p<j; p++, j--){
            int temp = arr[p];
            arr[p] = arr[j];
            arr[j] = temp;
        }
    }

    // time -> o(N) and space -> o(N)
    private static int[] rotateUsingTempArray(int[] arr, int k) {
        int temp [] = new int[arr.length];
        for (int i = 0; i< arr.length; i++){
            temp[(i+k) % arr.length] = arr[i];
        }
        return temp;
    }

    //Order o(k*N)
    private static int[] rotateByBruteForce(int[] a, int k) {
        //rotate k times
        for (int j = 0; j < k; j++) {
            int lastElem = a[a.length - 1];
            // shift each elem by 1 position to right
            for (int i = a.length - 2; i >= 0; i--) {
                a[i + 1] = a[i];
            }
            //place the last elem to first position
            a[0] = lastElem;
        }
        return a;
    }

    // time -> o(n^2) space -> o(1)
    private static int[] rotateUntilModulo(int[] a, int k) {
        //rotate k%N times, since after N rotation the sequence repeats
        for (int j = 0; j < k % a.length; j++) {
            int lastElem = a[a.length - 1];
            // shift each elem by 1 position to right
            for (int i = a.length - 2; i >= 0; i--) {
                a[i + 1] = a[i];
            }
            //place the last elem to first position
            a[0] = lastElem;
        }
        return a;
    }
}
