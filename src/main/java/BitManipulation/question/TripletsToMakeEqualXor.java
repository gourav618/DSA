package BitManipulation.question;

public class TripletsToMakeEqualXor {
    public static void main(String[] args){
        //https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/description/

        int[] arr = {2,3,1,6,7};

        //We are searching for sub-array of length ≥ 2 and we need to split it to 2 non-empty arrays so that the xor of
        // the first array is equal to the xor of the second array. This is equivalent to searching for sub-array with xor = 0.

        //Keep the prefix xor of arr in another array, check the xor of all sub-arrays in O(n^2),
        // if the xor of sub-array of length x is 0 add x-1 to the answer.

        System.out.println(countTriplets(arr));
    }

    private static int countTriplets(int[] arr) {
        //prefix xor of
        int[] prefixXor = new int[arr.length];
        prefixXor[0] = arr[0];
        for (int i=1; i< arr.length; i++){
            prefixXor[i] = (prefixXor[i-1] ^ arr[i]);
        }

        int ans = 0;
        for (int i=0; i<arr.length; i++){
            for (int j=i; j<arr.length; j++){
                int xor;
                if (i==0){
                    xor = prefixXor[j];
                }else {
                    xor = prefixXor[j] ^ prefixXor[i-1];
                }
                if (xor == 0){
                    ans += (j-i);
                }
            }
        }
        return ans;
    }
}
