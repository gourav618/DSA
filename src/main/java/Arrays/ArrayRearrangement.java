package Arrays;

import java.util.Arrays;

public class ArrayRearrangement {
    public static void main(String[] args){

        // given int arr[N] which contains {0,1,2.... N-1} i.e permutation of 0,1,2...N-1
        //ex: arr[4] = {1, 3, 0, 2}
        //CHANGE this array: if arr[i] = j then arr[j] = i
        //i.e arr[0] = 1 then arr[1] = 0 {_,0,_,_} ; arr[1] = 3 then arr[3] = 1 {_,0,_,1} ; arr[2] = 0 then arr[0] = 2 {2,0,_,3} ;arr[3] = 2 then arr[2] = 3 {2,0,3,1}-> o/p

        int[] arr = {1,3,0,2};

        //naiveSolution
        // by creating temp arr and put the value to appropiate position
        arrangeArrayBybruteForce(arr);
        System.out.println();

        //using cycle in array
        //if we note above array from indx 0 we jump to 1 then from 1 to 3, then 3 to 2 then back to 0 -> type of cycle formed which starts and end at 0
        // note we can even have more than 1 cycle in an array so we may have to track visited item and not visit them again
        // this can be done by keeping a boolean array , but again we use extra o(N) space
        //so instead we can use some marker like moving elem x would be -x and -ve sign indicates this is visited
        //edge 0 would fail since there is no -ve 0 , so instead we can do -(x+1) and move the item in ccle and later on convert them back by multiplying -1 and then subtract -1
        int []arr1 = {2,0,1,4,5,3};
        arrangeArrayByCycleMethod(arr1);

    }

    // 2*n operation i.e time -> o(N)
    private static void arrangeArrayByCycleMethod(int[] arr) {

        for (int i=0; i<arr.length; i++){
            //non visited index start cycle
            if (arr[i] >= 0){
                int index = arr[i], val = i;
                // until arr[i] points to starting index
                while (index != i){
                    int temp = arr[index];
                    arr[index] = -(val+1);
                    val = index;
                    index = temp;
                }
                arr[index] = -(val+1);
            }
        }

        // convert the value to original one
        for (int i=0; i< arr.length; i++){
            arr[i] = -1*arr[i]-1;
        }

        Arrays.stream(arr).forEach(System.out::print);
    }

    //time -> o(N) and space-> o(N)
    private static void arrangeArrayBybruteForce(int[] arr) {
        int temp[] = new int[arr.length];

        for (int i=0; i< arr.length; i++){
            temp[arr[i]] = i;
        }
        Arrays.stream(temp).forEach(System.out::print);
    }
}
