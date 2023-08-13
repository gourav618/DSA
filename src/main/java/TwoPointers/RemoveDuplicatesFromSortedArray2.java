package TwoPointers;

public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String[] args){
        //https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

        int[] nums = {1,1,1,2,2,3};

        System.out.println(removeDuplicates(nums));
    }

    private static int removeDuplicates(int[] nums) {
        int i=0, j=0;
        while (j< nums.length){
            int curr = nums[j], count = 0;
            while (j < nums.length && nums[j] == curr){
                j++;
                count++;
            }
            if (i != 0){
                nums[i] = curr;
                if (count >=2){
                    nums[i+1] = curr;
                }
            }
            if (count >= 2){
                i += 2;
            }else {
                i++;
            }
        }
        return i;
    }
}
