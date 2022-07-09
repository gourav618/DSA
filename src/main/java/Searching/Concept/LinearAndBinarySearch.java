package Searching.Concept;

public class LinearAndBinarySearch {
    public static void main(String[] args){
//        Binary Search
//        Searching techniques have two major components:
//        Search Key
//        Search Space
//        Types of Searches:
//
//        Linear Search is a searching technique in which the search space is reduced by one element after every operation.
//                Time complexity: O(N)
//        Space complexity: O(1)
//
//        Binary Search technique is used to search an element in a sorted array by repeatedly dividing the search interval into half based on a middle element and a condition.
//                Sample code to search a key ‘k’ in a sorted array a[N]
//
//        int l=0, m;  //low = l, mid = m
//        int h=N-1;  //high = h
//        while(l<=h){  //as long as we have a non-empty subarray
//            m=(l+h)/2;
//            if(arr[m]==a[k]) return m;
//            else if(a[m]<k) l=m+1;
//            else h=m-1;
//        }
//        Time complexity: O(log2N)
//        Space complexity: O(1)
//        Note: Binary search requires an ordered search space & not necessarily a sorted search space

        int[] arr = {10, 23, 40, 45, 56, 70, 93, 100, 121};

        int index = linearSearch(arr, 93);
        System.out.println(index);

        int indx = binarySearch(arr, 40);
        System.out.println(indx);

    }

    private static int binarySearch(int[] arr, int key) {
        int l=0, h=arr.length-1;
        while (l <= h){
            int mid = (l+h)/2;

            if (arr[mid] == key){
                return mid;
            }
            else if (arr[mid] < key){
                l = mid+1;
            }else {
                h = mid-1;
            }
        }
        return -1;
    }

    private static int linearSearch(int[] arr, int key) {
        for (int i=0; i< arr.length; i++){
            if (arr[i] == key){
                return i;
            }
        }
        return -1;
    }
}
