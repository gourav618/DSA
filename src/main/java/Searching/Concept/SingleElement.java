package Searching.Concept;

public class SingleElement {
    public static void main(String [] args){
//        Single Element
//        We have been given an unsorted array Arr[N] where all elements occur in pairs (together at index i & i+1) except one element.
//        Find out that element.
//
//        Input: Arr[9] = {4, 4, 1, 1, 3, 7, 7, 6, 6}
//        Output: 3
//
//        Approach:
//
//        On observing the pairs before and after the single element we find that both the parts of the array have a
//        distinct identification characteristic.
//        Binary search L7
//
//
//        In the first subarray, the first and the second occurrences of the element has an even and an odd index
//        respectively while it is the reverse case for the second part of the array. The answer that is the single element will act as a pivot between the two subarrays. Therefore, we can apply binary search on the above rule to find the answer.
//        Arr[mid] is the answer if Arr[mid]!=Arr[mid-1] and Arr[mid]!=Arr[mid]+1.
//        Time complexity: O(log2N)
//        Space complexity: O(1)
//        Note: Take special care of the boundary conditions to ensure that the array indices are in their legal range.

        int []arr = {4,4,1,1,3,7,7,6,6};

        int singleElement = findSingleElement(arr);
        System.out.println(singleElement);

        System.out.println(findSingleElement(new int[]{7}));
    }

    private static int findSingleElement(int[] arr) {
        int l=0, h= arr.length-1;

        if (l==h){ // handle for case where length of arr equals 1
            return arr[0];
        }

        while (l<=h){
            int m= (l+h)/2;

            if (m==0){
                if (arr[m+1] != arr[m]){// ans is zero index itself
                    return arr[m];
                }else { // ans to right
                    l = m+1;
                }
            }
            else if (m == arr.length-1){
                if (arr[m-1] == arr[m]){// ans id last index itself
                    return arr[m];
                }else { // ans to left
                    h = m-1;
                }
            }
            else if (arr[m] != arr[m-1] && arr[m] != arr[m+1]){ // we found the ans in middle
                return arr[m];
            }
            else { // we are in middle of array
                int fo, so; //first and second occurrence
                if (arr[m] == arr[m+1]){
                    fo = m;
                    so = m+1;
                }else {
                    fo = m-1;
                    so = m;
                }

                if (fo % 2 == 0){ //go to right part
                    l = m+1;
                }else { // go to left part
                    h = m-1;
                }
            }
        }
        return -1;
    }
}
