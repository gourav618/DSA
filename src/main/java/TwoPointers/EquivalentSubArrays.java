package TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EquivalentSubArrays {
    public static void main(String[] args){
        //https://practice.geeksforgeeks.org/problems/equivalent-sub-arrays3731/1?difficulty%5B%5D=1&difficulty%5B%5D=2&page=1&category%5B%5D=two-pointer-algorithm&query=difficulty%5B%5D1difficulty%5B%5D2page1category%5B%5Dtwo-pointer-algorithm

        int n=5;
        int[] arr = {2, 4, 4, 2, 4};

        System.out.println(countDistinctSubarray(arr, n));
    }

    private static int countDistinctSubarray(int[] arr, int n) {
        //count of distinct element
        int countDistinctElem = (int) Arrays.stream(arr).distinct().count();
        //left =0 and right =1 and curr is 1
        int i=0,j=0, curr=0, ans = 0;
        Map<Integer, Integer> distinct = new HashMap<>();
        //put first element id distinct char map
        //distinct.put(arr[i], 1);
        while (j < n){
            //if element not in map add and update curr
            if (!distinct.containsKey(arr[j])){
                curr++;
                distinct.put(arr[j], 1);
            }else {//decrease the freq of existing element
                distinct.put(arr[j], distinct.get(arr[j])+1);
            }
            //if dist element count in curr sub array equals distinct element update ans and increment i
            // until the sub array has all distinct element
            if (curr == countDistinctElem){
                while (curr == countDistinctElem) {
                    ans += (n - j);
                    if (distinct.get(arr[i]) == 1) {
                        distinct.remove(arr[i]);
                        curr--;
                    } else {
                        distinct.put(arr[i], distinct.get(arr[i]) - 1);
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}
