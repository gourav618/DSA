package Arrays.Concept;

public class SpecialSearchingProblem {
    public static void main(String[] args){

        // given a 2-D matrix dimension m*n
        // int key
        // check if key present ? if yes then print the co-ordinates : else -1,-1 i.e not present
        // special properties of array - 1: each row is sorted 2: each column is sorted
        // ex: [{10 20 30 40} {14 25 35 45} {27 29 37 48} {32 33 39 50}] , key = 29

        int arr[][] ={{10, 20, 30, 40}, {14, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
        int key = 29;
        //by brute force o(m*n)
        findCoordinateOfKey(arr, key);

        // using binay search
        // since the array is sorted row wise (column sort not needed for this approach), we can apply binary search for each row
        // and there are M rows and for each rows there are N elem the complexity would be log N for binary search
        // total complexity o(M * log N)

        //HERE THE APPROACH IS curtain the search space i.e define the concise search space
        //we can define the starting point from top right of matrix i.e (0, N-1)-> (i,j) [since we know row is sorted
        // and elem lower than this will lie left of this or else next row i.e (i+1, j) , and if key is less than the elem
        // than we ignore that column since column is sorted and  key will be not present in that column i.e  (i, j-1)]
        // 3 case can happen i.e 1: key == elem, 2: key > elem, 3: key < elem
        // if 1st case then we got our key , else if 2nd case then move to next row by incrementing i coordinate , 3rd case we ignore that column and move left i.e dec j index

        // Note : we can not start from top left and bottom right since row sorted in asc order and
        // if key less than/greater than that elem can lie either in that row and column ,  we cannot discard neither row or column
        // and we can start searching from bottom left since elem sorted in asc order and above rule apply to it
        findCoordinateOfKeyInOptmizeManner(arr, key);

    }

    // worst case is we have cut off all row and column 1 by 1 i.e move 1 left and then 1 bottom and so on until we reach bottom left
    // we have M rows and N column i.e we have cut off all M and N
    // o(M+N) -> time , space --> o(1)
    private static void findCoordinateOfKeyInOptmizeManner(int[][] arr, int key) {
        int i=0, j=arr[0].length-1;

        while (i< arr.length && j>=0){
            // key found
            if (arr[i][j] == key){
                System.out.println(i + ", " + j);
                break;
            } else if (arr[i][j] > key) { // elem > key i.e ignore column
                j--;
            }else { // elem < key i.e ignore row
                i++;
            }
        }

    }

    //o(m*n)
    private static void findCoordinateOfKey(int[][] arr, int key) {
        for (int i=0; i< arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                if (arr[i][j] == key){
                    System.out.println("(i, j): ("+ i +", "+j+ ")");
                    break;
                }
            }
        }
        //System.out.println("(i, j): (-1,-1)");
    }
}
