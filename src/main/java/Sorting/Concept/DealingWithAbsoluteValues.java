package Sorting.Concept;

import java.util.Arrays;

public class DealingWithAbsoluteValues {
    public static void main(String [] args){
//        Dealing with Absolute Values
//        We have been given two arrays x[N] and y[N] containing the x and y coordinates of ‘N’ points lying on the
//        coordinate axis. We have to find the sum of the Manhattan distances between all pairs of points.
//
//        Manhattan distance between two points (x1,y1) and (x2,y2) is equal to |x2-x1| + |y2-y1|.
//
//        Approach:
//
//        Brute Force - Consider all the NC2 pairs and calculate the sum of the Manhattan distances between them.
//        Time complexity: O(N^2)
//        Space complexity: O(1)

        int [] x = {2,1,4,-3};
        int [] y = {3,-2,1,4};
        manhattanUsingBruteForce(x, y);

//        Using Sorting:
//        If we consider 5 points P0(x0, y0), P1(x1, y1), P2(x2, y2), P3(x3, y3), P4(x4,y4). Then the sum of Manhattan distance of point P0 from other points will be -
//                Sum(P0) = (|x1 - x0| + |y1 - y0|) + (|x2 - x0| + |y2 - y0|) + (|x3 - x0| + |y3 - y0|) + (|x4 - x0|     + |y4 - y0|)
//        We know that the sum of absolute differences of x coordinates is independent of the sum of absolute differences of y coordinates. Therefore, we can calculate them individually i.e.
//                SumP0 = Xdiff(P0) + Ydiff(P0) where,
//                Xdiff(P0) = |x1 - x0| + |x2 - x0| + |x3 - x0| + |x4 - x0|
//                Ydiff(P0) = |y1 - y0| + |y2 - y0| + |y3 - y0| + |y4 - y0|
//                But in the above expression, we do not know whether the mod operator will open with a positive or a negative sign, therefore we can sort x[N] and y[N] in ascending order to be able to process the mod operator.
//                Suppose the x coordinates are sorted in ascending order then,
//                Xdiff(P0) = (x1 + x2 + x3 + x4) - 4x0
//        Similarly, Xdiff(P1) = (x2 + x3 + x4) - 3x1
//
//        We can generalise it as Xdiff = ΣXdiff(Pi) = Σ(Σxi+1 - (N-i-1)*xi)
//        Ydiff = ΣYdiff(Pi) = Σ(Σyi+1 - (N-i-1)*yi)
//        Time complexity: O(Nlog2N)
//        Space complexity: O(1)
        manhattanUsingSorting(x, y);
    }

    private static void manhattanUsingSorting(int[] x, int[] y) {
        Arrays.sort(x);
        Arrays.sort(y);

        int xDiff=0, yDiff=0;
        int tot_x_sum = Arrays.stream(x).sum();
        int tot_y_sum = Arrays.stream(y).sum();

        xDiff = findManhattan(x, tot_x_sum);
        yDiff = findManhattan(y, tot_y_sum);

        System.out.println(xDiff+yDiff);
    }

    private static int findManhattan(int[] x, int tot_x_sum) {
        int xDiff = 0;
        for (int i=0; i<x.length; i++){
            tot_x_sum -= x[i]; //suffix sum
            xDiff += (tot_x_sum - ((x.length-1-i)*x[i]));
        }
        return xDiff;
    }

    private static void manhattanUsingBruteForce(int[] x, int[] y) {
        int ans = 0;
        for (int i=0; i<x.length; i++){
            for (int j=i+1; j<y.length; j++){//to ensure no duplicate pair considered
                ans += Math.abs(x[j]-x[i]) + Math.abs(y[j]-y[i]);
            }
        }
        System.out.println(ans);
    }
}
