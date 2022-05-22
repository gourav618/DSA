package Arrays.Concept;

public class MaximizeTheExpression {

    // int Arr[N]
    //int p,q,r;
    //maximize the expression Max(p*Arr[i] + q*Arr[j] + r*Arr[k]) such that i < j < k

    //if the question would be Max(Arr[i] + Arr[j] + Arr[k]) such that i < j < k --> then we could have solve it by fixing the middle elem (i.e 1 to N-1)
    // and maintain the prefixMax and suffixMax array and loop through the middle elem and find the max via Max(ans , x)
    // where x = pMax[j-1] + a[j] + sMax[j+1] and ans is initialized to Int.min_value

    //same for this question we can calculate the Pmax array my multiplying each elem with p and sMax with r and compare the ans var....
    public static void main (String [] args){

        int arr[] =  {1,2,3,4,-5};
        int p = 1, q= 2, r = -3;
        System.out.println(byBruteForceMethod(arr, p,q,r));

        //using pMax and sMax
        int arr1[] = {1,2,3,4,-5};
        int[] prefixMaxSumArray = getPrefixMaxSumArray(arr1.clone(), p);
        int[] suffixMaxSumArray = getSuffixMaxSumArray(arr1.clone(), r);
        int ans = Integer.MIN_VALUE;
        // setting the mid elem and looping to find the max of expression
        for (int j = 1; j<arr1.length-1; j++){
            ans = Math.max(ans, prefixMaxSumArray[j-1] + q*arr1[j] + suffixMaxSumArray[j+1]);
        }
        System.out.println(ans);

    }

    // o( n^3 )
    private static int byBruteForceMethod(int arr[], int p, int q,int r){
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i<arr.length; i++){
            for (int j = i+1; j<arr.length; j++){
                for (int k = j+1; k<arr.length; k++){
                    ans = Math.max(ans, (p*arr[i] + q*arr[j] + r*arr[k]));
                }
            }
        }
        return ans;
    }

    private static int[] getPrefixMaxSumArray(int [] arr, int p){
        arr [0] = arr[0] * p;
        for (int i=1; i< arr.length; i++){
            arr[i] = Math.max(arr[i-1] , p*arr[i]);
        }
        return arr;
    }

    private static int[] getSuffixMaxSumArray(int [] arr, int r){
        arr[arr.length-1] = r * arr[arr.length-1];
        for (int i= arr.length-2; i>=0; i--){
            arr[i] = Math.max(arr[i+1], r*arr[i]);
        }
        return arr;
    }
}
