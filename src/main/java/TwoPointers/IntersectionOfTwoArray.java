package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArray {
    public static void main(String[] args){
        //https://leetcode.com/problems/intersection-of-two-arrays/

        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] intersection = intersection(nums1, nums2);

        System.out.println(Arrays.toString(intersection));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length, n = nums2.length;
        List<Integer> ans = new ArrayList<>();
        int i=0, j=0, k=0;
        while (i< m && j< n){
            if (nums1[i] == nums2[j]){
                ans.add(k, nums1[i]);
                while (i < m && nums1[i] == ans.get(k)){
                    i++;
                }
                while (j < n && nums2[j] == ans.get(k)){
                    j++;
                }
                k++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            }else {
                j++;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
