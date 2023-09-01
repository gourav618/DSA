package TwoPointers;

public class UglyNumberII {
    public static void main(String[] args){
        //https://leetcode.com/problems/ugly-number-ii/
        int n=10;
        System.out.println(nthUglyNumber(n));
    }

    private static int nthUglyNumber(int n) {
        //prime factors
        int n1 = 2, n2 = 3, n3 = 5;
        //since we need to find nth prime factorization
        int[] arr = new int[n];
        //first val is 1
        arr[0]=1;
        //and all pointer will be pointing to 1, since there 1st factor generated
        int p1=0, p2=0, p3=0;
        for (int i=1; i<n; i++){
            //find next candidate
            int val = Math.min(arr[p1]*n1, Math.min(arr[p2]*n2, arr[p3]*n3));
            //put the candidate in its rightful position
            arr[i] = val;
            //now increment pointer whose candidate was generated
            if (val == arr[p1]*n1){
                p1++;
            }
            if (val == arr[p2]*n2){
                p2++;
            }
            if (val == arr[p3]*n3){
                p3++;
            }
        }
        return arr[n-1];
    }
}
