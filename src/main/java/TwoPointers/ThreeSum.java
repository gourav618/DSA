package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args){
        //https://leetcode.com/problems/3sum/

        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> lists = threeSum(nums);

        System.out.println(lists.toString());
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }else {
                int rem = -1*(nums[i]);
                int p1 = i+1, p2 = nums.length-1;
                while (p1<p2){
                    int curr = nums[p1]+nums[p2];
                    if (curr < rem){
                        p1++;
                    } else if (curr > rem) {
                        p2--;
                    } else {
                        List<Integer> triplet = List.of(nums[i], nums[p1], nums[p2]);
                        triplets.add(triplet);
                        if (nums[p1] == nums[p2]){
                            break;
                        }else {
                            int x = nums[p1], y = nums[p2];
                            while (nums[p1] == x){
                                p1++;
                            }
                            while (nums[p2] == y){
                                p2--;
                            }
                        }
                    }
                }
            }
        }
        return triplets;
    }
}
