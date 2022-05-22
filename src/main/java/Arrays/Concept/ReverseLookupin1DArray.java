package Arrays.Concept;


public class ReverseLookupin1DArray {

    public static void main(String [] args){
        //int arr[N], find the sum of all its subarray
        //ex: [1 2 3] possible subarray {1} {12} {123} {2} {23} {3} -> 1 + 3 + 6 + 2 + 5 + 3 = 20 --> ans

        int arr[] = {1,2,3};
        //by brute force technique
        //no of subraay ?
        //when i =0 , N subrray, i = 1, N-1 subarray, ....i=N-2, 2 subarray , i = N-1, 1 subarray i.e 1+2+3+...+N = N(N+1)/2 subarray
        findSumOfAllSubArrayByBruteForce(arr);

        //using prefix max we reduce the sum of that subarray to 0(1)
        findSumOfAllSubArrayByPrefixMax(arr);

        //using extra var to just store for previous subarray without prefixMax array to get the sum of array in a range
        findSumOfAllSubArrayByExtraSumVariableForPreviousSubArray(arr);

        //since in above approach we were considering all the subarray in array and there is o(N^2) of them , hence time o(N^2) is inevitable
        // answer is think reverse i,e reverse lookup
        //ex: [1 -1 2 0 3 4] -> here we have to fix a element i.e ith elem where i=2 i.e arr[2] = 2
        //no of subarray which contain this elem would be product of starting point and ending points
        // starting points will be 3 i.e index 0 , 1, 2 and ending point will be 4 i.e 2,3,4,5
        // total subarray containg ith =2 = 3 * 4 = 12
        // to generalize this for elem ai total subarray = (i+1) * (N-i) {starting point * ending points}
        // if there is a elem  'k' which is occuring in 100 subarrays , so its contribution in those many subarray would be 100 * K
        // Hence, for elem ai its contribution would be (i+1) * (N-i) * a[i]
        // and thus contribution of each elem can be calculated and sum together in 1 loop i.e o(N)
        findSumOfAllSubArrayUsingReverseLookUp(arr);

        //Note : for (i+1) * (N-i) * a[i] this operation if input is in order of 10^6 * 10^6 * 10^9 = 10^21 i.e leads to integer overflow even long
        //so question may ask to return ans % (10^9 + 7) instead of ans {anything % m would return 0 to m-1 which would be in range of dataType to preven overflow}

        // mod law to remember :
        // (a+b) % m = (a%m + b%m) % m
        // (a*b) % m = (a%m * b%m) % m

        //long long contribution = (i+1)*(arr.length-i)*arr[i] -> in form of (a*b*c)%m = ((a*b)%m * c%m) % m -> using 2nd rule and divide the expression
        //                                                          ((a%m * b%m) % m * c%m) % m
        // therefore long long contribution = ( ( (i+1)%m * (N-i)%m ) % m * arr[i]%m) %m
        // sum = sum + contribution can be --> sum = (sum%m + contribution%m) % m
        // will prevent overflow
    }

    // time -> o(N) and space -> o(1)
    private static void findSumOfAllSubArrayUsingReverseLookUp(int[] arr) {
        int sum = 0;
        for (int i=0;i< arr.length;i++){
            sum += (i+1)*(arr.length-i)*arr[i];
        }
        System.out.println(sum);
    }

    //time -> o(N^2) space-> o(1)
    private static void findSumOfAllSubArrayByExtraSumVariableForPreviousSubArray(int[] arr) {
        int sum = 0;
        for (int i=0;i< arr.length;i++){
            int sumOfPreviousSubArray =0;
            for (int j=i; j< arr.length; j++){
                sumOfPreviousSubArray += arr[j];
                sum += sumOfPreviousSubArray;
            }
        }
        System.out.println(sum);
    }

    //time -> 0(N^2) and space -> o(N)
    private static void findSumOfAllSubArrayByPrefixMax(int[] arr) {
        int [] prefixMax = new int[arr.length];
        prefixMax[0] = arr[0];
        //getPrefix Max
        for (int k =1; k< arr.length; k++){
            prefixMax[k] = prefixMax[k-1] + arr[k];
        }
        int sum = 0;
        for (int i=0;i< arr.length;i++){
            for (int j=i; j< arr.length; j++){
                sum += getSum(i, j, prefixMax);
            }
        }
        System.out.println(sum);
    }

    private static int getSum(int i, int j, int[] arr) {
        if (i ==0){
            return arr[j];
        }
        return arr[j] - arr[i-1];
    }

    //time -> o(N^3), space -> o(1)
    private static void findSumOfAllSubArrayByBruteForce(int[] arr) {
        int sum = 0;
        int count = 0;
        while(count < arr.length) {
            for (int i = count; i < arr.length; i++) {
                //get Sum for that subarray
                for (int j = count; j <= i; j++) {
                    sum += arr[j];
                }
            }
            count++;
        }
        System.out.println(sum);
    }
}
