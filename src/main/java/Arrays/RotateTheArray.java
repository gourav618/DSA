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
}
