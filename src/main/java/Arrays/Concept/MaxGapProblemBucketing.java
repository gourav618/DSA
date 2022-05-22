package Arrays.Concept;

public class MaxGapProblemBucketing {
    public static void main(String[] args){

        // Given int arr[N]
        // find maximum consecutive difference between 2 elements of array
        // ex: {3 6 9 1} -> after sort {1 3 6 9}  -> consecutive diff b/w elem is 2 (3-1), 3 (6-3), 3 (9-6) -> max of this is 3

        // naive solution
        // do as the question say sort the array (if we use efficient algorithm like quick sort it would take o(N*logN))
        // and then traverse through sorted array and find the consecutive diff and track max diff (o(N) ) -> total time ~ o(N*logN)

        //Max Gap Approach
        // here we have to find the minimum possible value of maximum consecutive diff
        // ex: arr[N=3] min = 1 , max = 7 {1, _ , 7} we have to find the 2nd elem such that we get the minimum possible value of maximum consecutive diff
        // if we select 2 then {1 (2-1), 5 (7-2)} -> max = 5 , select 3 then {2 (3-1), 4 (7-3)} -> max = 4, select 4 {3 (4-1), 3 (7-4)} -> max = 3
        //note the answer is 4 since the min val of diff is 3 , because if we increase the elem the left gap increases or when we decrease the selected elem the right gap increases
        // hence we can say that the answer will never be less than 3
        //no of gaps  = N-1 , min possible value of consecutive diff = (max-min)/(N-1) -> (7-1)/2 = 3 ,
        //if (max-min)/(N-1) is not perfectly divisible then (max-min)/(N-1) + 1 will give the required answer ex: {1, _ ,8} -> 8-1/3-1 +1 = 4 i.e   {1, 4, 8} or {1, 5, 8}

        //to leverage this fact to solve the original problem we need to create the buckets and group the item in these buckets, since most item won't contribute to max of consecutive diff
        // ex: min=20, max=70, N=6  gap = 70-20/6-1 = 10 i.e the value will be >=10 i.e {20 30 40 50 60 70} -> max(10, 10, 10, 10, 10) = 10
        // original array : {20, 25, 27, 33, 65, 70}
        // if we create a bucket [20 .. 29]  --> elem in this bucket = 20,25,27
        //                  i.e (min .. min+gap-1) -> value in this range will not contribute to max cons. diff since diff value < 10 , and all possible bucket is:
        //                       [30 .. 39]  --> 33  ->(min+gap .. min + 2*gap - 1)
        //                       [40 .. 49]  --> X   ->(min+2*gap .. min + 3*gap - 1)
        //                       [50 .. 59]  --> X
        //                       [60 .. 69]  --> 65
        //                       [70 .. 79]  --> 70

        //since the question is to find the max consecutive diff, the max elem of bucket 1 will come before min element of bucket 2
        // and elem which will contribute to answer since consec. diff -> min of bucket2 - max of bucket 1 [hence w ill only track max and min elem of each bucket]
        // bucket          elem in group      min  max
        // [20 .. 29]  --> 20,25,27       |    20   27
        // [30 .. 39]  --> 33             |    33   33
        // [40 .. 49]  --> X              |    X    X
        // [50 .. 59]  --> X              |    X    X
        // [60 .. 69]  --> 65             |    65   65
        // [70 .. 79]  --> 70             |    70   70
        //max consecutive diff -> max(6 {33-27}, 32 {65-33}, 5 {70-65}) -> 32 answer
        // we need to mantain the max and min array which would be size of N i.e no of gaps
        //for an elem arr[i] we need to figure out which bucket this elem is present i.e arr[i] - min/ gap -> bucket no
        int arr[] = {20, 25, 27, 33, 65, 70};
        int maximumConsecutiveDiff = getMaximumConsecutiveDiff(arr);
        System.out.println(maximumConsecutiveDiff);
    }

    // time -> o(N), space-> o(N) since array created to track max and min
    private static int getMaximumConsecutiveDiff(int[] arr) {
        int N = arr.length;
        //if array is having only 1 elem
        if (N < 2){
            return 0;
        }
        // find the min and max elem in arr
        int maxNum = Integer.MIN_VALUE, minNum = Integer.MAX_VALUE;
        //o(N)
        for (int i=0; i<=N-1;i++){
            maxNum = Math.max(maxNum, arr[i]);
            minNum = Math.min(minNum, arr[i]);
        }

        // find gap, edge case is when get bucket no of arr[i] -> arr[i]-min/gap == 0 i.e all them elem are equal and gap will be 0 and max consec diff would be 0
        if (minNum == maxNum){ // it will lead to gap == 0
            return 0;
        }
        int gap = (maxNum - minNum)/(N-1);
        if ((maxNum - minNum)%(N-1) != 0){ // when gap is not perfectly divisible
            gap++;
        }

        int[] minArr = new int[N], maxArr = new int[N];
        //o(N)
        for (int i=0; i<=N-1; i++){ // init all value to min and max value
            minArr[i] = Integer.MAX_VALUE;
            maxArr[i] = Integer.MIN_VALUE;
        }

        //o(N)
        for (int i=0; i<=N-1; i++){
            // find which bucket arr[i] belong
            int bkt = (arr[i] - minNum)/gap;
            //update min and max of that bucket
            minArr[bkt] = Math.min(minArr[bkt], arr[i]);
            maxArr[bkt] = Math.max(maxArr[bkt], arr[i]);
        }

        int ans = Integer.MIN_VALUE;
        int prev = Integer.MIN_VALUE;
        //o(N)
        for (int i=0; i<=N-1; i++){
            if (minArr[i] == Integer.MAX_VALUE){ // if no elem in that bucket continue
                continue;
            }
            if (prev == Integer.MIN_VALUE){ // first bucket found and update the prev to get max of current bucket
                prev = maxArr[i];
            }else {// find the consecutive diff of bucket and update ans to max of this diff
                ans = Math.max(ans, minArr[i]-prev);
                prev = maxArr[i];
            }
        }
        return ans;
    }
}
