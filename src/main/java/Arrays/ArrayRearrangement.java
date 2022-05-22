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
        //edge 0 would fail since there is no -ve 0 , so instead we can do -(x+1) and move the item in cycle and later on convert them back by multiplying -1 and then subtract -1
        int []arr1 = {2,0,1,4,5,3};
        arrangeArrayByCycleMethod(arr1.clone());
        System.out.println();

        //alternative technique
        //ex we have arr[N]->{__,6,___5,_} , here for i=2 we want to assign arr[6] = 2 and arr[6] has 5 in it which indicate arr[5] need to be assign 6 and so on..
        //THE IDEA is we want to replace arr[6] with a num which represent old_val and new_val both , where old_val=5 and new_val=2 and both lies in 0<=x<=N-1
        //what should be done for num ?? assume we have 2 int (a,b) < N both less than N , then
        // we can establish an equation num = N*a + b where a-> Quotient, b-> Remainder, num-> Dividend and N-> Divisor AND num%N = b AND num/N = a
        //hence, num = N* new_val + old_val and we replace arr[6] = num i.e 8*2 + 5 = 21 old_val = 21%8 = 5 and new_val = 21/8 = 2
        // each index in  array is replace with num
        //NOTE: num = N* old_val + new_val -> does this equation make sense No. because while we traverse arr from left to
        // right to get the old value we do arr[j]%N and if the index is not modified (i.e if y) then y%n = y always since 0<=y<=N-1 , so it make sense to keep the old value as remainder
        // since new value is set as arr[old_val] = N*j + arr[old_val]
        // ex: {2 0 1 4 5 3} N=6 -> at j= 0 arr[j] = 2 so we need to make arr[2] as 6*0 + 1 where old_val = 1, new_val = 0 and arr[j] = 6*1 + 2 where old_val = 2, new_val = 1
        arrangeArrayByAlternativeMethod(arr1.clone());

    }

    // time -> o(N) and space -> o(1)
    private static void arrangeArrayByAlternativeMethod(int[] arr) {

        int N = arr.length;
        // update each index with value num = N* new_val + old_val
        for (int i = 0; i< N; i++){
            int old_val = arr[i]% N;
            arr[old_val] = N * i + arr[old_val];
        }
        //update each index with new value
        for (int i = 0; i< N; i++){
            arr[i] = arr[i]/ N;
        }

        Arrays.stream(arr).forEach(System.out::print);
    }

    // 2*n operation i.e time -> o(N) and space -> o(1)
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
