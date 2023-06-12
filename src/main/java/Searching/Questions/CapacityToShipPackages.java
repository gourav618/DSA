package Searching.Questions;

import java.util.Scanner;

public class CapacityToShipPackages {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=122&sectionId=1&moduleId=2&topicId=6&subtopicId=82&homeworkId=17
        //https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] packages = new int[n];
        int min = Integer.MAX_VALUE, sum = 0;
        for (int i=0; i<n; i++){
            packages[i] = s.nextInt();
            min = Math.min(packages[i], min);
            sum += packages[i];
        }

        int t = s.nextInt();
        while (t-- > 0){
            int days = s.nextInt();
            System.out.println(findSmallestCapacityShip(packages, n, days, min, sum));
        }
    }

    private static int findSmallestCapacityShip(int[] packages, int n, int days, int min, int sum) {
        while (min <= sum){
            int mid = (min+sum)/2;
            boolean r = checkIfPossible(packages, n, days, mid);
            if (!r){
                min = mid+1;
            }else {
                boolean r1 = checkIfPossible(packages, n, days, mid - 1);
                if (!r1){
                    return mid;
                }else {
                    sum = mid-1;
                }
            }
        }
        return -1;
    }

    private static boolean checkIfPossible(int[] packages, int n, int days, int mid) {
        int count=1, sum=0;
        for (int i=0;i<n;i++){
            if (packages[i] > mid){
                return false;
            }
            if (packages[i]+sum > mid){
                count++;
                sum = packages[i];
            }else {
                sum += packages[i];
            }
        }
        return count <= days;
    }
}
