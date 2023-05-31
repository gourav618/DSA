package Searching.Questions;

public class FindInMountainArray {
    static class MountainArray{
        int[] arr = {3,5,3,2,0};
        public int get(int index){
            return this.arr[index];
        }
        public int length (){
            return this.arr.length;
        }
    }
    public static void main(String[] args){
        //https://leetcode.com/problems/find-in-mountain-array/

        int target = 0;
        MountainArray mountainArr = new MountainArray();
        if (mountainArr.length() >= 3) {
            int ans = -1;
            int peak = findPeak(mountainArr);
            ans = search(0, peak, mountainArr, target, true);
            if (ans == -1){
                ans = search(peak + 1, mountainArr.length() - 1, mountainArr, target, false);
            }
            System.out.println(ans);
        }else {
            System.out.println(-1);
        }
    }

    private static int search(int l, int h, MountainArray mountainArr, int target, boolean leftHalf) {
        while (l<=h){
            int mid = l + (h-l)/2;
            int elem = mountainArr.get(mid);
            if (elem == target){
                return mid;
            }else if (elem > target){
                if (leftHalf) {
                    h = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {
                if (leftHalf) {
                    l = mid + 1;
                }else {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }

    private static int findPeak(MountainArray mountainArr) {
        int N = mountainArr.length();
        int l=0 , h=N-1;
        while (l<=h){
            int mid = l + (h-l)/2;
            int elem = mountainArr.get(mid);
            if (mid == 0){
                if (elem > mountainArr.get(mid+1)){
                    return mid;
                }else {
                    l=mid + 1;
                }
            } else if (mid == N-1 && elem > mountainArr.get(mid-1)){
                return mid;
            } else if (elem > mountainArr.get(mid - 1) && elem > mountainArr.get(mid + 1)) {
                return mid;
            } else if (elem > mountainArr.get(mid + 1)) {
                h = mid-1;
            }else {
                l = mid+1;
            }
        }
        return -1;
    }
}
