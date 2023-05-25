package Searching.Questions;

public class FirstBadVersion {
    static int bad = 4;
    public static void main(String[] args){
        //https://leetcode.com/problems/first-bad-version/

        int n = 5, bad = 4;

        int i = firstBadVersion(n);
        System.out.print(i);

    }

    private static int firstBadVersion(int n) {
        int l=1, h=n;
        while (l<=h){
            int mid = l + (h-l)/2;
            if (!isBadVersion(mid)){
                l = mid+1;
            }else {
                if (isBadVersion(mid-1)){
                    h = mid-1;
                }else {
                    return mid;
                }
            }
        }
        return -1;
    }

    static boolean isBadVersion(int version){
        return version >= bad;
    }
}
