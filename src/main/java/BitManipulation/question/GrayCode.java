package BitManipulation.question;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args){
        //https://leetcode.com/problems/gray-code/
        int n = 3;

        List<Integer> grayCode = grayCode(n);
        System.out.println(grayCode);
    }

    private static List<Integer> grayCode(int n) {
        List<String> grayCode = getGrayCode(n);
        List<Integer> res = new ArrayList<>();
        for (String l : grayCode){
            res.add(Integer.parseInt(l, 2));
        }
        return res;
    }

    private static List<String> getGrayCode(int n) {
        List<String> res = new ArrayList<>();
        if (n == 1){
            res.add("0");
            res.add("1");
            return res;
        }
        res = getGrayCode(n - 1);
        int originalSize = res.size();
        int idx = originalSize - 1;
        while (idx >=0){
            res.add(res.get(idx));
            idx--;
        }
        idx = 0;
        while (idx < originalSize){
            res.set(idx, res.get(idx) + "0");
            idx++;
        }
        while (idx < res.size()){
            res.set(idx, res.get(idx) + "1");
            idx++;
        }
        return res;
    }
}
