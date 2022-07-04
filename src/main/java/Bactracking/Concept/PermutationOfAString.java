package Bactracking.Concept;

public class PermutationOfAString {
    public static void main(String[] args){
//        Permutations of a String - 1
//        Permutation of a string ‘S’ is the rearrangement of its elements such that there is a one-to-one correspondence with the string itself.
//        A string of length ‘N’ containing all distinct elements has ‘N!’ permutations.
//          In this lecture, we will learn the fundamentals of backtracking and will see how we can apply it to print all the permutations of a string.
//
//        Approach:
//
//        Recursion: We can place all the ‘N’ characters one by one at the zero index and then move on to the further indices to place the available characters respectively.
//
//        Disadvantage: Using call by value leads to enormous memory usage and if we use call by reference then the string changes during each function call. Because of this, we may not be able to print all the permutations.
//                Solution: Use backtracking & call by reference.
//
//        Backtracking: It states to -
//                Do something: If ‘i’ points to the current index, then perform the operation swap(s[i], s[j]) where i<=j<N to generate different permutations.
//                Recurse: Permute(s, i+1);  //make the recursive call for the next index
//        Undo that thing: Now we have to undo the previous swapping operation i.e. unswap(s[i], s[j]) where i<=j<N
//                Backtracking
//        Time complexity: O(N!) = O(N^N)
//
//        Note: A string ‘t’ is a permutation of a string ‘s’ if and only if ‘t’ contains all the characters of ‘s’.


        // mutable string in java -> StringBuffer, StringBuilder
        StringBuffer s = new StringBuffer("ABC");
        permuteString1(s, 0);
    }

    private static void permuteString1(StringBuffer s, int i) {
        if (i == s.length()){
            System.out.println(s);
            return;
        }
        for (int j=i; j<s.length(); j++){
            //change or do something
            swap(i, j, s);
            //calll
            permuteString1(s, i+1);
            //undo the changes
            swap(i, j, s);
        }
    }

    private static void swap(int i, int j, StringBuffer s) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }

}
