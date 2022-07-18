package Searching.Concept;

public class SearchInSortedRotatedArray {
    public static void main(String[] args){
//        Lecture 4: Search in Sorted Rotated Array
//        We have been given a sorted rotated array containing ‘N’ distinct elements and a key ‘k’. We have to check if the key lies in the array or not.
//
//        Input: Arr[7] = {5, 6, 7, 1, 2, 3, 4}, k = 3
//        Output: 5
//
//        Approach:
//
//        We know that the sorted array is rotated, therefore there exist two individual subarrays that are sorted in ascending order.
//                Eg. Arr = [5, 6, 7, 1, 2, 3, 4]

//        Binary Search L4
//        We can use binary search to find the pivot. Property of the pivot element:
//        It is the largest element of the array
//        It is the only element for which a[ i ] > a[i+1]
//        We can compare a[mid] with a[N-1] to find out the part in which “mid” is lying in. Let the pivot index be j,
//        then there will be two sorted subarrays - from 0 to j and from j+1 to N-1.
//        We can compare the key with a[N-1] to know in which subarray it lies. And then we can directly search the key in that subarray.
//                Time complexity: O(log2N)
//        Space complexity: O(1)
//
//        Note: The above technique may not work for arrays containing non-distinct elements as we may not be able to
//        identify the part in which our “mid” is lying in. This will create a hindrance in finding the pivot by using Binary Search.
//                Eg. Arr = [3, 3, 3, 5, 9, 1, 2, 3, 3, 3, 3]
//        Here part2 >= Arr[N-1] but part1 ≯ Arr[N-1]

        int arr[] = {5,6,7,1,2,3,4};

        searchInSortedRotatedArray(3, arr);

        int arr1[] = {1,2,3,4,5,6,7};
        searchInSortedRotatedArray(3, arr1);

        int arr2[] = {3,3,4,5,6,7,1,2,3,3};
        searchInSortedRotatedArray(2,  arr2);
    }

    private static void searchInSortedRotatedArray(int key, int[] arr) {
        int pivot = getPivot(arr);
        int i = -9999;
        if (pivot < 0){ // arr not rotated
            i = binarySearch(arr, 0, arr.length - 1, key);
        }else {//arr rotated
            if (arr[arr.length-1] >= key){ // key in part 2
                i = binarySearch(arr, pivot+1, arr.length-1, key);
            }else {
                i = binarySearch(arr, 0, pivot, key);
            }
        }

        System.out.println(i);
    }

    private static int binarySearch(int[] arr, int l, int h, int key) {
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

    private static int getPivot(int[] arr) {
        int l=0, h=arr.length-1;
        while (l<=h){
            int m = (l+h)/2;

            if (arr[m] <= arr[arr.length-1]){
                h = m-1;
            }
            //handle duplicate elem towards at starting and ending index
            else if (arr[l] == arr[m] && arr[m] == arr[h]){
                l++;
                h--;
            }
            else {
                if (arr[m] > arr[m+1]){
                    return m;
                }
                else {
                    l = m+1;
                }
            }
        }
        return -1;
    }
}
