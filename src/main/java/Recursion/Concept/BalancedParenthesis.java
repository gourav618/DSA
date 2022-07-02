package Recursion.Concept;

public class BalancedParenthesis {
    public static void main(String[] args){
//       Balanced Parantheses
//        We have been given ‘N’ pairs of parentheses and we have to generate all the possible combinations of balanced parentheses.
//
//                Approach:
//
//        For N=3, 2*N=6
//        (   )                           For third position we have 1 choice i.e. ‘(‘
//        In  (   (                         For third position we have 2 choices i.e. ‘(‘ & ‘)’
//        In  (   (   (                            For fourth position we have 1 choice i.e. ‘)’
//        From the above example we can create the following cases:
//
//        Case I: Cnt(‘(‘) = Cnt(‘)’)
//        If the string is complete, do nothing
//        Otherwise, add a ‘(‘
//
//        Case II: Cnt(‘(‘) > Cnt(‘)’)
//        If Cnt(‘(‘) > N, add a ‘)’
//        Otherwise, add ‘(‘ and ‘)’
//        Recursion Tree:
//        Recursion Tree
//        Time complexity: O(2^N)
//        Space complexity: O(N)
        int N = 3;
        char[] s = new char[2*N];
        printBalancedParenthesis(N, 0, 0, 0,s);
    }

    private static void printBalancedParenthesis(int n, int l, int r, int i, char[] s) {
        //termination when no more space left in s
        if (i == 2*n){
            for (int q=0; q< s.length; q++){
                System.out.print(s[q]+" ");
            }
            System.out.println();
            return;
        }

        //if left braces == right braces
        if (l == r){
            s[i] = '(';
            printBalancedParenthesis(n, l+1, r, i+1, s);
        }
        else if (l > r){//left braces > right braces
            //all left braces used
            if (l == n){
                s[i] = ')';
                printBalancedParenthesis(n, l, r+1, i+1, s);
            }
            else {// all left braces not used and have 2 option i.e put ( or )
                s[i] = '(';
                printBalancedParenthesis(n, l+1, r, i+1, s);

                s[i] = ')';
                printBalancedParenthesis(n, l, r+1, i+1, s);
            }
        }
    }
}
