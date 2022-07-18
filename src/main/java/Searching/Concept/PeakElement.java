package Searching.Concept;

public class PeakElement {
    public static void main(String[] args){
//        Peak Element
//        We have been given an unsorted array Arr[N] and we have to find a peak element in the array.
//
//                Input: Arr[7] = {10, 20, 15, 2, 23, 90, 67}
//        Output: 20 (or 90)
//
//        Note: An element Arr[i] is said to be a peak if:
//
//        Arr[i-1] =< Arr[i] <= Arr[i+1]   (i<=1 and i<N-1)
//
//        The first and the last elements can qualify as a peak element only if:
//
//        Arr[0]>=Arr[1]
//
//        Arr[N-1]>=Arr[N-2]
//
//        Approach:
//
//        If we apply binary search on the array then our mid will be the peak when -
//                Arr[mid]>=Arr[mid-1] and Arr[mid]>=Arr[mid+1]
//        But what if the above condition is false? Then where should we move next, to the left or to the right?
//        The answer is to the direction where finding a peak is certain i.e. towards the greater adjacent element,
//        and if both are greater then we can move randomly in any direction. It can be easily understood from the illustration given below.
//        Binary Search L5
//
//        Time complexity: O(log2N)
//        Space complexity: O(1)
        int[] arr = {10,20,15,2,23,90,67};
        int atleastOnePeak = findAtleastOnePeak(arr);
        System.out.println(atleastOnePeak);

        int[] arr1 = {50,40,30,20,10};
        System.out.println(findAtleastOnePeak(arr1));

        int[] arr2 = {10,20,30,40};
        System.out.println(findAtleastOnePeak(arr2));
    }

    private static int findAtleastOnePeak(int[] arr) {
        int l=0, h= arr.length-1;

        while (l<=h){
            int m = (l+h)/2;

            if (m == 0 && arr[m] > arr[m+1]){
                return arr[m];
            }
            else if (m == arr.length-1 && arr[m] > arr[m-1]){
                return arr[m];
            }
            else if (arr[m] > arr[m+1] && arr[m] > arr[m-1]){
                return arr[m];
            }
            if (arr[m] > arr[m+1]){
                h = m-1;
            }else {
                l = m+1;
            }
        }
        return -1;
    }
}
