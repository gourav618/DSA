package Searching.Concept;

public class FirstAndLastOccurrence {
    public static void main(String [] args){
//        Lecture 3: First and Last Occurrence
//        We have been given a sorted array containing repeated elements and a key ‘k’. We have to find the first & last occurrence of the key.
//
//                Approach:
//
//        We can use a simple “For” loop to find the first and the last occurrence of the key.
//        Time complexity: O(N)
//        Space complexity: O(1)
//        Binary Search: We can write two separate binary search codes to find the first and the last occurrences of the key.
//                First occurrence: When mid is equal to the key and the element before mid is not equal to the key.
//        if(arr[m]==k){
//            if(m==0 or arr[m-1]!=k)return m;
//        }
//        Secondary occurrence: When mid is equal to the key and the element after mid is not equal to the key.
//        if(arr[m]==k){
//            if(m==N-1or arr[m+1]!=k)return m;
//        }
//        Time complexity: O(log2N)
//        Space complexity: O(1)
//        Note: Occurrence of element ‘k’ in the array is = last occurrence - first occurrence + 1

        int arr[] = {1,1,2,2,2,3,4,4};

        int firstOccurrenceOfKey = getFirstOccurrenceOfKey(2, arr);
        System.out.println("first occurrence of key : "+firstOccurrenceOfKey);

        int lastOccurrenceOfKey = getLastOccurrenceOfKey(2, arr);
        System.out.println("last occurrence of key : "+lastOccurrenceOfKey);

        getFrequencyOfKey(2, arr);
    }

    private static void getFrequencyOfKey(int key, int[] arr) {
        int lastOccurrenceOfKey = getLastOccurrenceOfKey(key, arr);
        int firstOccurrenceOfKey = getFirstOccurrenceOfKey(key, arr);
        System.out.println("freq of key: "+(lastOccurrenceOfKey-firstOccurrenceOfKey+1));
    }

    private static int getLastOccurrenceOfKey(int key, int[] arr) {
        int l = 0, h = arr.length-1;
        while (l<=h){
            int m = (l+h)/2;

            if (arr[m] > key){
                h = m-1;
            }
            else if (arr[m] < key){
                l = m+1;
            }
            else {//arr[m] == key
                if (m == arr.length-1){
                    return m;
                }
                else if (arr[m+1] != key){
                    return m;
                }
                else {//move to right since last occurrence would be on right
                    l = m+1;
                }
            }
        }
        return -1; //key not found
    }

    private static int getFirstOccurrenceOfKey(int key, int[] arr) {
        int l = 0, h = arr.length-1;
        while (l<=h){
            int m = (l+h)/2;

            if (arr[m] > key){
                h = m-1;
            }
            else if (arr[m] < key){
                l = m+1;
            }
            else {//arr[m] == key
                if (m == 0){
                    return m;
                }
                else if (arr[m-1] != key){
                    return m;
                }
                else { //move to left since 1st occurrence would be on left
                    h = m-1;
                }
            }
        }
        return -1; //key not found
    }
}
