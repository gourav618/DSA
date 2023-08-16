package TwoPointers;

public class SmallestSubStringWithAllCharacters {
    public static void main(String[] args){
        //https://leetcode.com/problems/minimum-window-substring/

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    private static String minWindow(String s, String t) {
        if (t.length() == 0){
            return "";
        }
        int[] freqS = new int[256];
        int[] freqT = new int[256];
        int distinctChar=0;
        //update frequency array of t anf count of distinct char
        for (int i=0; i<t.length(); i++){
            if (freqT[t.charAt(i)] == 0)
                distinctChar++;
            freqT[t.charAt(i)]++;
        }
        //calculate first window
        int c=0, start=0, end = 0;
        for (int i=0; i<s.length(); i++){
            freqS[s.charAt(i)]++;
            if (freqS[s.charAt(i)] == freqT[s.charAt(i)])
                c++;
            if (c == distinctChar){
                end = i;
                break;
            }
        }
        if (c<distinctChar){
            return "";
        }
        //now apply 2 pointer approach to find min substring with t
        int ansS = start, ansE = end, min = end-start+1;
        while (end < s.length()){
            //try to remove extra char from start
            while (freqS[s.charAt(start)] > freqT[s.charAt(start)]){
                freqS[s.charAt(start)]--;
                start++;
            }
            //update min and start and end index for min substring
            if ((end-start+1) < min) {
                min = end-start+1;
                ansS = start;
                ansE = end;
            }
            //add char at end
            end++;
            if (end < s.length()){
                freqS[s.charAt(end)]++;
            }
        }
        return s.substring(ansS, ansE+1);
    }
}
