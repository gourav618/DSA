package TwoPointers;

public class MinimizeTheExpression {
    public static void main(String[] args){
        //https://www.geeksforgeeks.org/minimize-maxai-bj-ck-minai-bj-ck-three-different-sorted-arrays/

        int[] A = {1, 4, 5, 8, 10};
        int[] B = {6, 9, 15};
        int[] C = {2, 3, 6, 6};

        System.out.println(minimize(A, B, C));
    }

    private static int minimize(int[] a, int[] b, int[] c) {
        //all pointer for 3 array starts from 0
        int i=0,j=0,k=0;
        //min of expression updated for triplet considered
        int ans = Integer.MAX_VALUE;
        while (i<a.length && j<b.length && k<c.length){
            //calculate the value of expression
            int val = Math.max(a[i], Math.max(b[j], c[k])) - Math.min(a[i], Math.min(b[j], c[k]));
            //update the ans
            ans = Math.min(ans, val);
            //increment pointer pointing to the least element
            int min = Math.min(a[i], Math.min(b[j], c[k]));
            if (a[i] == min){
                i++;
            } else if (b[j] == min) {
                j++;
            }else {
                k++;
            }
        }
        return ans;
    }
}
