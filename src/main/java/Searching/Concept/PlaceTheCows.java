package Searching.Concept;

public class PlaceTheCows {
    public static void main(String[] args){
//        Place the Cows
//        A farmer has ‘N’ stalls located at some points on a number line x0, x1, x2,.., xN. Each stall can contain at
//        max 1 cow. Given that N>=2, C>=2 and C<N, place ‘C’ cows such that the minimum distance between any two adjacent cows is maximum possible.
//
//        Input: N=5, C=3, Arr = [1, 2, 4, 8, 9]
//        Output: 3
//
//        Explanation: Selected combinations are (1, 4, 8) or (1, 4, 9)
//
//        Approach:
//
//        Brute Force - Use recursion to figure out all the NCC combinations and find the maximum possible value of the
//        minimum distance between any two adjacent cows.

           

//       Binary Search on Answer: Hint: Focus on the minimum adjacent distance(d) between any two cows in a specific configuration.
//
//       If it is possible to put ‘C’ cows at ‘N’ stalls for d=4 then, it is also possible for d<=3.
//
//        Similarly, if it is not possible to put ‘C’ cows at ‘N’ stalls for d=9, then it is also not possible for d>=10.
//        Searching_L14
//
//        Therefore, we have a monotonic function on which we can apply binary search to find the correct answer.
//
//        Where low = 1, the minimum possible distance between any two adjacent cows/stalls
//        And high = max-min, the maximum possible distance between any two cows
//
//        We can implement a function to check whether it is possible to put C cows at N stalls for a given ‘d’.
//
//        Note: We should allocate the cows in a greedy fashion such that the first stall is always occupied.
//
//        Time complexity: O(Nlog(max-min))
//        Space complexity: O(1)
//
//        Note: In case you are facing difficulty in finding the low and high, then you can also consider 0 and INT_MAX respectively.

        int[]  x = {1,2,4,8,9}; // if not sorted need to sort it in O(N*logN) time
        int i = PlaceTheCowsUsingBinarySearch(x, 3, 5);
        System.out.println("cows can be placed at : "+i+" distance apart");
    }

    private static int PlaceTheCowsUsingBinarySearch(int[] x, int c, int n) {
        int l = findLowerRange(x);
        int h = x[n-1] - x[0];

        while (l<=h){
            int m = (l+h)/2;
            boolean r = isPlacingCowPossible(x, m, c, n);
            if (!r){
                h = m-1;
            }else {
                boolean r1 = isPlacingCowPossible(x, m + 1, c, n);
                if (!r1){
                    return m;
                }else {
                    l = m+1;
                }
            }
        }
        return -1;
    }

    private static boolean isPlacingCowPossible(int[] arr, int m, int c, int n) {
        int count = 1, prev = arr[0]; // first cow place at index 0 and count inc to 1 and prev will track the last cow placed

        for (int i=1; i<n; i++){
            if (arr[i]-prev < m){
                continue;//distance is less than m
            }else {
                count++;
                prev = arr[i];
            }
        }
        return count>=c; // if count strictly less than c i.e we were not able to place all the cows
    }

    private static int findLowerRange(int[] x) {
        int minDist = Integer.MAX_VALUE;
        for (int i=0; i< x.length-1; i++){
            minDist = Math.min(x[i+1] - x[i], minDist);
        }
        return minDist;
    }
}
