package Sorting.Questions;

import java.util.Arrays;

public class KClosestPointsToOrigin {
    public static void main(String[] args){
        //https://leetcode.com/problems/k-closest-points-to-origin/
        int[][] points = {{1,3},{-2,2}};
        int k=1;
        int[][] ints = kClosest(points, k);
        for (int i=0; i<ints.length; i++){
            System.out.println(ints[i][0]+", "+ints[i][1]);
        }
    }

    private static int[][] kClosest(int[][] points, int k) {
        int[][] kClosest = new int[k][2];

        Arrays.sort(points, (o1, o2) -> {
            int d1 = o1[0]*o1[0] + o1[1]*o1[1];
            int d2 = o2[0]*o2[0] + o2[1]*o2[1];
            return Integer.compare(d1, d2);
        });

        for (int i=0; i<k; i++){
            kClosest[i] = points[i];
        }
        return kClosest;
    }
}
