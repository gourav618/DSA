package Recursion.Concept;

public class SubSetSum {
    static int count = 0;
    public static void main(String[] args){
        //count of distinct subset of array with sum  = given sum

        int arr[] = {1,2,3};
        int sum = 3;


        //void function return
        countOfSubsetSum(0, sum, arr);
        System.out.println(count);

        //int returning function
        int count = countOfSubsetSumRet(0, sum, arr);
        System.out.println(count);


//        Subset Sum-2
//        In this lecture, we will discuss a comparatively harder version of the previous problem - “Subset sum”. Here,
//        we have been given an integer array containing ‘N’ positive elements and a variable ‘SUM’. We need to find the count of distinct combinations
//        of array elements such that the sum of the combination is equal to SUM.
//
//         I/P: Arr[2] = {1, 2}, SUM = 4
//        O/P: 3   ∵ [1, 1, 1, 1], [2, 2], [1, 1, 2]
//
//        Approach:
//
//        Why not negative elements?
//        The count will be infinite since we can select an element multiple times
//        Eg. [1, 2, -1], SUM = 4
//        Follow the approach used in the previous lecture but do not increase the index of the element for one call, i.e. select the element multiple times.
//
//                Recursion call: return func(sum-Arr[i], i) + func(sum, i+1)
//        Termination condition: if(sum<0 or i==N) return 0;
//        if(sum==0) return 1;
        int arr1[] = {1,2}; // [1111] [112] [22]
        int SUM = 4;
        int count1 = countOfDistinctCombinationEqualsSum(SUM, 0, arr1);
        System.out.println(count1);

    }

    private static int countOfDistinctCombinationEqualsSum(int sum, int i, int[] arr) {
        if (sum < 0) return 0;
        if (sum == 0) return 1;
        if (i == arr.length) return 0; // since sum is neither -ve nor equals 0 hence we dont have elem to consider

        // else for yes case dec sum and repeat i for multiple times else for N case we increase i
        return countOfDistinctCombinationEqualsSum(sum-arr[i], i, arr) +
                countOfDistinctCombinationEqualsSum(sum, i+1, arr);
    }

    private static int countOfSubsetSumRet(int i, int sum, int[] arr) {
        if (i == arr.length){
            if (sum == 0)
                return 1;
            else
                return 0;
        }
        return countOfSubsetSumRet(i+1, sum-arr[i], arr) + countOfSubsetSumRet(i+1, sum, arr);
    }

    private static void countOfSubsetSum(int i, int sum, int[] arr) {
        if (i == arr.length){
            if (sum == 0){
                count++;
            }
            return;
        }
        countOfSubsetSum(i+1, sum-arr[i], arr); // selected
        countOfSubsetSum(i+1, sum, arr); // not selected
    }
}
