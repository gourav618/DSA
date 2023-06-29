package Sorting.Questions;

import java.util.*;

public class AdvantageShuffle {
    public static void main(String[] args){
        int[] nums1 = {15777,7355,6475,15448,18412};
        int[] nums2 = {986,13574,14234,18412,19893};
//        int[] nums1 = {2,0,4,1,2};
//        int[] nums2 = {1,3,0,0,2};

        int[] ints = advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int n = nums1.length;
        List<Pair> arr2 = new ArrayList<>();
        for (int i=0; i<n; i++){
            Pair p = new Pair();
            p.elem = nums2[i];
            p.index = i;
            arr2.add(p);
        }
        arr2.sort(Comparator.comparingInt(e -> e.elem));

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int[] visited = new int[n];
        for (int i=0; i<n; i++){
            Pair pair = arr2.get(i);
            int upperBoundInNums1 = findUpperBoundInNums1(nums1, pair.elem);
            if (upperBoundInNums1 < n ) {
                if (visited[upperBoundInNums1] == 1){
                    while (upperBoundInNums1 < n && visited[upperBoundInNums1] != 0){
                        upperBoundInNums1++;
                    }
                }
                if(upperBoundInNums1 < n) {
                    ans[pair.index] = nums1[upperBoundInNums1];
                    visited[upperBoundInNums1] = 1;
                }
            }
        }
        for (int i=0; i<n; i++){
            if (visited[i] != 1){
                int j=0;
                while (j<n && ans[j] != -1){
                    j++;
                }
                ans[j] = nums1[i];
            }
        }
        return ans;
    }

    private static int findUpperBoundInNums1(int[] nums1, int elem) {
        int l=0, h=nums1.length-1;
        while (l<=h){
            int mid = l +(h-l)/2;
            if (nums1[mid] <= elem){
                l = mid+1;
            }else {
                h = mid-1;
            }
        }
        return l;
    }

    static class Pair {
        int elem;
        int index;
    }
}
