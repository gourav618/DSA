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
