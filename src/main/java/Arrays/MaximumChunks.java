package Arrays;

// we have an Array a[N] i.e a permutation of numbers from 0 to N-1
// ex: a[5] = {0,1,2,3,4} or {4,1,3,0,2} or {1,0,3,4,2} [i.e it contains elem from 0 to 4 in any form of contribution and every elem is unique]
// step 1: split the array into multiple chunks i.e subarray of continuous element [chunk1: {a0 a1 a2} chunk2 {a3 a4}] --> can be split into any no of chunk
// step 2: sort each chunk individually
// step 3: concat the sorted chunk
// exp:
// a[5] : {1 0 2 3 4 } step1 : {1} {0 2 3} {4}
// step 2: sort it {1} {0 2 3} {4}
// step 3 : {1 0 2 3 4}

// Required : Result must be a sorted array after all the 3 steps
// o/p : max no of chunks that array can be split into
// extreme cases arr sorted in dec order[ex: {5 4 3 2 1} o/p : 1 chunk] / arr sorted in asc order [ex: {1 2 3 4 5} o/p : 5 chunk]
public class MaximumChunks {
    public static void main(String [] args){

        int arr[] = {1,2,0,4,3,5};
        int i = byBruteForce(arr);
        System.out.println("No of chunks: "+i);

        // same thing can be solved by prefix max array since the point where index == greatest elem i.e all the elem smaller than this has been seen
        // and we can count it as 1 chunk and so on , this approach will only take 0(N)
        int chunksByPrefixMax = getChunksByPrefixMax(arr.clone());
        System.out.println("No of Chunks by prefix max method: " +chunksByPrefixMax);
    }

    private static int getChunksByPrefixMax(int[] arr) {
        int currentMax = Integer.MIN_VALUE, ans = 0;
        for (int i=0; i< arr.length; i++){
            // get current max at index i
            currentMax = Math.max(currentMax, arr[i]);
            // if currentMax is equal i that means we have seen all elem smaller than i (since no duplicate allowed) and we can make the chunk
            if (currentMax == i){
                ans++;
            }
        }
        return ans;
    }

    // in worst case when arr is traversed 1,2,3...N times by canBeChunked
    //N(N+!)/2 ~ o(N^2)
    private static int byBruteForce(int [] arr){
        int i=0, ans = 0;
        while(i < arr.length) {
            int j;
            for (j = i; j < arr.length; j++) {
                if (canBeChunked(i, j, arr))
                    break;
            }
            i = j + 1;
            ans++;
        }
        return ans;
    }

    private static boolean canBeChunked(int i, int j, int[] arr) {
        int count = 0;
        for (int k = i; k<=j; k++){
            // check if i to j is permutation of no from i to j
            if (arr[k] >= i && arr[k] <= j){
                count++;
            }
        }
        //check if count is equal to the no btw i to j
        if (count == (j-i+1)) return true;
        return false;
    }
}
