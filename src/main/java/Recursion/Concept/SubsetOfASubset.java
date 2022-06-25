package Recursion.Concept;

public class SubsetOfASubset {
    public static void main(String [] args){
//        how to find all the subsets of a set with the help of recursion.
//
//        A subset is a set of each of whose elements belong to an inclusive set. A set with n elements has 2n subsets.
//
//        Recursion call: subsets(i+1, tmp, size)
//        Termination condition: if(i==N){ print tmp; return;}
//
//        Recursion Tree:
//
//        Time complexity: O(2^N)
//        Space complexity: O(N)

        int arr[] = {1,2,3};
        int tmp[] = new int[arr.length];

        printAllSubSet(arr, arr.length, 0, tmp, 0);

        System.out.println();

//        Bitmasking is a technique used to select a certain number of bits from a collection of bits.
//        we will learn how to find all the subsets of a set with the help of bitmasking.
//        binary representation of digits from 0 to 2^N-1 accounts for all the possible subsets of a set S with ‘N’ elements.
//        Therefore, we can iterate over the numbers to find their binary representation and extract the 1s to print the elements of the subset.
//        Time complexity: O(2^N)
//        Space complexity: O(N)
        printAllSubSetUsingBitMasking(arr, arr.length);

    }

    private static void printAllSubSetUsingBitMasking(int[] arr, int N) {
        for (int i=0; i<Math.pow(2, N); i++){
            // Function to print integer to binary using
            // inbuilt toBinaryString method
            //System.out.println(Integer.toBinaryString(num));
            int[] binary = generateBinaryRepresentation(i, N);

            System.out.print("{ ");
            for (int k=0; k< binary.length; k++){
                if (binary[k] == 1) {
                    System.out.print(arr[k] + " ");
                }
            }
            System.out.print("} ");
        }
    }

    private static int[] generateBinaryRepresentation(int i, int N) {
        int[] binary = new int[N];

        int id = 0;
        while (i > 0){
            binary[id++] = i%2;
            i = i/2;
        }
        return binary;
    }

    private static void printAllSubSet(int[] arr, int N, int i, int[] tmp, int size) {
        if (i == N){
            System.out.print("{ ");
            for (int k=0; k<size; k++){
                System.out.print(tmp[k]+" ");
            }
            System.out.print("} ");
            return;
        }
        //if included
        tmp[size] = arr[i];
        printAllSubSet(arr, N, i+1, tmp, size+1);
        //if not included
        printAllSubSet(arr, N, i+1, tmp, size);
    }
}
