package TwoPointers;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args){
        //https://leetcode.com/problems/remove-element/

        int[] nums = {2};
        int val = 3;

        System.out.println(removeElement(nums, val));
    }

    private static int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int i=0, j= nums.length-1, k=0;
        while (i<=j){
            if (nums[i] == val){
                nums[i] = nums[j];
                nums[j] = val;
                j--;
            }
            if (nums[i] != val){
                k++;
            }
            i++;
        }
        return k;
    }
}
