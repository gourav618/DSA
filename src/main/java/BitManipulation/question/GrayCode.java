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
        List<String> grayCode = getGrayCode1(n);
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

    private static List<String> getGrayCode1(int n) {
        if (n ==1){
            List<String> baseResult = new ArrayList<>();
            baseResult.add("0");
            baseResult.add("1");
            return baseResult;
        }
        List<String> res = getGrayCode1(n - 1);
        List<String> mRes = new ArrayList<>();
        for (int i=0; i< res.size(); i++){
            String rStr = res.get(i);
            mRes.add("0"+rStr);
        }
        for (int i=res.size()-1; i >= 0; i--){
            String rStr = res.get(i);
            mRes.add("1"+rStr);
        }
        return mRes;
    }
}
