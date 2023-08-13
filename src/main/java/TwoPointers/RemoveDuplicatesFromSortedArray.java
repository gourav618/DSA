package TwoPointers;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args){
        //https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

        int[] nums = {1,1,2};

        System.out.println(removeDuplicates(nums));
    }

    private static int removeDuplicates(int[] nums) {
        int i=0, j=0;
        while (j< nums.length){
            int curr = nums[j];
            while (j < nums.length && nums[j] == curr){
                j++;
            }
            if (i != 0){
                nums[i] = curr;
            }
            i++;
        }
        return i;
    }
}
