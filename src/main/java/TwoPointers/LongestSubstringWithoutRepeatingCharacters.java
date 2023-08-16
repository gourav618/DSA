package TwoPointers;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        //https://leetcode.com/problems/longest-substring-without-repeating-characters/

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int i=0, j=0, ans=1;
        int[] freq = new int[256];
        freq[s.charAt(0)]++;
        while (j<s.length()-1){
            if (freq[s.charAt(j+1)] == 0){
                j++;
                freq[s.charAt(j)]++;
            }else {
                freq[s.charAt(i)]--;
                i++;
            }
            ans = Math.max(ans, j-i+1);
        }
        return ans;
    }
}
