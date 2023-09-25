package BitManipulation.concept;

import java.util.Arrays;

public class FindingMinimumXor {
    public static void main(String[] args){
        //given int arr[N]
        //find minimum value of arr[i] ^ arr[j] where i != j

        int[] arr = {10,1,9,4,7};

        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;
        for (int i=0; i<arr.length-2; i++){
            ans = Math.min(ans, arr[i] ^ arr[i+1]);
        }

        System.out.println(ans);
    }
}
