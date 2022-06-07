package Mathematics.Concept;

public class PascalTriangleForNcR {
    public static void main(String[] args){

//        We have been given ‘N’ boys and ‘M’ girls and we need to choose a group containing exactly ‘T’ people
//        having no less than 4 boys and 1 girl. Print the number of distinct combinations of groups that are possible. 4<=N<=30 & 1<=M<=30
//
//        Approach:
//
//        Suppose we have 5 boys & 5 girls and we want to make a team of 5, then the number of distinct combinations will be 10C5
//        If we want all the above combinations except those consisting of 2 boys & 3 girls then the number of distinct combinations will be 10C5 - 5C2*5C3.
//                Taking a hint from above, the number of distinct groups consisting of T people out of N+M people will be (N+M)CT.
//                Since 4<=N and M>=1, therefore
//        Answer
//        Note: In NCr, N>=r. Pay attention to this rule while writing the code. For eg. In NC1*MCT, T-1>=M.
//
//               For N=M=30, we will need to calculate 60C30 = 60!/(30!*30!). But 60! can not be stored in any of the known data types.
//               But we also know that 60C30 lies in the integer range. This is where Pascal’s Triangle comes to the rescue.

//        Pascal’s Triangle is a numerical pattern consisting of numbers arranged in a triangular fashion.
//        Pascal's Trangle
//∴ We can create a 2D matrix of size 61x61 and use the above formula to calculate different nCr values.
        long numberOfDistinctGroup = getNumberOfDistinctGroup(17, 2, 6);
        System.out.println(numberOfDistinctGroup);

        long numberOfDistinctGroup1 = getNumberOfDistinctGroup(5, 2, 5);
        System.out.println(numberOfDistinctGroup1);

    }

    private static long getNumberOfDistinctGroup(int n, int m, int t) {
        long[][] pas = new long [61][61];// since n and m can be max 30 and n+m = 60 so triangle from 0 to 60 needed;
        pas[0][0] = 1;
        //initialize pascal triangle
        for (int i=1; i<=60; i++){
            for (int j=0; j<=i; j++){
                if (j==0 || j==i){
                    pas[i][j] = 1;
                }else {
                    pas[i][j] = pas[i-1][j]+pas[i-1][j-1];
                }
            }
        }
        long ans = 0;
        ans += pas[n+m][t];
        if (t<=m){
            ans -= pas[m][t];
        }
        if (t-1<=m){
            ans -= n*pas[m][t-1];
        }
        if (t-2<=m){
            ans -= (((long) n *(n-1))/2)*pas[m][t-2];
        }
        if (t-3<=m){
            ans -= (((long) n *(n-1)*(n-2))/6)*pas[m][t];
        }
        if (t<=n){
            ans -= pas[n][t];
        }
        return ans;
    }
}
