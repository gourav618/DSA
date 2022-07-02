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
