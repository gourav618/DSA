package Arrays;

public class ReverseLookupIn2DArray {

    public static  void main(String [] args){
        //A 2-d matrix m*n is given, find sum of all its submatrix
        //ex: 2*2 {{1,1} {1,1}} -> different submatrix = {{1}, {1}, {1}, {1}, horizontally-> {1 1} {1 1}, vertically {1 1} {1 1} , {1 1 1 1}} -> 1+1+1+1+2+2+2+2+4 = 16

        int [][] arr = {{1,1},{1,1}};
        // to get all the submatrix we need to consider a starting(top left) and end point(bottom right) same as 1D array, only diff is need to consider 2d here
        //we need to fix one point , i.e the top left(i1 j1) need to be fixed and then the bottom left(i2 j2) will be i2>=i1 and j2>=j1
        // since the bottom left will not be on the top and left side of 2d array , and all sub matrix possible within that range
        //by brute force
        findSumByBruteForce(arr);

        // by reverse lookup method
        // for each element we need to figure out the total sub matrix this elem can be part of
        // for each elem(i, j) -> we create 2 matrix : 1st towards left of i and top of j (tl-matrix), 2nd towards right of i and bot of j (bl-matrix)
        // and elem in tl-matrix will be (i+1)*(j+1) i.e no of choices for tl
        // and elem in bl-matrix will be (N-i)*(N-j) i.e no of choices for bl
        // and any top left in 1st matrix and bottom left  in 2nd matrix will lead to inclusion of elem (i,j) i.e a unique subtrix including elem (i,j)
        // total no of choices = choices for tl * choices for bl = (i+1)*(j+1) * (N-i)*(N-j)
        // contribution of elem (i,j) = arr[i][j] * total no of choices = arr[i][j] * (i+1)*(j+1) * (N-i)*(N-j)
        // we can keep adding this contribution for each cell and sum up
        findSumByReverseLookUp(arr);

        // Note : in above approach we created 2 matrix which is top left and bottom right,
        // we can change the convention to top right( (N-i)*(j+1) -> no of choices ) and bottom left ( (i+1)*(N-j) )
    }

    // time-> o(N^2)
    private static void findSumByReverseLookUp(int[][] arr) {
        int sum = 0;
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                sum += arr[i][j] * (i+1)*(j+1) * (arr.length-i)*(arr.length-j);
            }
        }
        System.out.println(sum);
    }

    // total time -> o(N^2 {for tl} * N^2 {for bl} * N^2 {worst case to get the sum of sub array}) -> o(N^6)
    private static void findSumByBruteForce(int[][] arr) {
        int sum = 0;
        // for top left -> o(N^2)
        for (int i1 =0; i1<arr.length; i1++ ){
            for (int j1=0; j1< arr.length; j1++){
                // for all possible bottom left -> o(N^2)
                for (int i2=i1; i2< arr.length; i2++){
                    for (int j2=j1; j2< arr.length; j2++){
                        sum += getSumofSubArray2D(i1, j1, i2, j2, arr);
                    }
                }
            }
        }
        System.out.println(sum);
    }

    // time -> o(N^2)
    private static int getSumofSubArray2D(int i1, int j1, int i2, int j2, int[][] arr) {
        int sum = 0;
        for (int i = i1; i<= i2; i++){
            for (int j = j1; j<= j2; j++){
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
