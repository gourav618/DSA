package BitManipulation.question;

import java.util.Arrays;

public class StepToReduceTo1 {
    public static void main(String[] args){
        //https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/

        String s = "1111110011101010110011100100101110010100101110111010111110110010";
        int steps = numSteps(s);
        System.out.println(steps);
    }

    private static int numSteps(String s) {
        if (s.length() ==1 && s.charAt(0) == '1'){
            return 0;
        }
        char[] chars = s.toCharArray();
        int start=0, end=s.length()-1, ans=0;
        while (start != end){
            if (chars[start] == '0')
                start++;

            //if even divide the number by 2 i.e >> 1
            if (chars[end] == '0'){
                end--;
            }else {
                //if odd we add 1
                //to add 1 we toggle the bit until we find first 0 from end
                int temp = end;
                while (temp >= 0){
                    if (chars[temp] == '0'){
                        chars[temp] = '1';
                        break;
                    }else {
                        chars[temp] = '0';
                    }
                    temp--;
                }
                //if all bits are 1 then start should point to start-1
                if (temp < start){
                    chars = new char[end+2];
                    Arrays.fill(chars, '0');
                    chars[0] = '1';
                    end++;
                }
            }
            ans++;
        }
        return ans;
    }

    //throws number format exception when is quite long
//    private static int numSteps(String s) {
//        long n = Long.parseLong(s, 2);
//
//        int count=0;
//        while (n > 1){
//            if ((n&1) == 1){
//                n += 1;
//            }else {
//                n = (n>>1);
//            }
//            count++;
//        }
//        return count;
//    }
}
