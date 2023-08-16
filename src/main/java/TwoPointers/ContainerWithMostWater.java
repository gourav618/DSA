package TwoPointers;

public class ContainerWithMostWater {
    public static void main(String[] args){
        //https://leetcode.com/problems/container-with-most-water/description/

        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int i=0, j = height.length-1;
        int max = Integer.MIN_VALUE;
        while (i<j){
            max = Math.max(max, Math.min(height[i], height[j])*(j-i));
            if (height[i] < height[j]){
                i++;
            } else if (height[i] > height[j]) {
                j--;
            }else {
                i++;
                j--;
            }
        }
        return max;
    }
}
