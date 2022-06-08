package Mathematics.Concept;

public class CatalanNumbers {
    public static void main(String[] args){
//        interesting set of numbers called Catalan Numbers and see how they can help us in solving the Balanced parenthesis problem.
//        Q. Print the count of distinct Balanced parentheses consisting of ‘N’ pairs of braces
//        For N=3
//        (( ))( ) - Balanced
//        ( ))(( ) - Unbalanced
//
//        Approach:
//        We can find the number of balanced parentheses for lower values of N.
//        For N=0 → Empty
//        cnt[0] = 1
//
//        For N=1 → ( )
//        cnt[1] = 1
//
//        For N=2 → ( )( ), (( ))
//        cnt[2] = 2
//
//        For N=3 → ( )( )( ), ( )(( )), (( ))( ), (( )( )), ((( )))
//        cnt[3] = 5
//        In a balanced parentheses, for any prefix string cnt( ‘(‘ ) > = cnt( ‘)‘ ). Let us see how we can use this property together with the Product Rule to find out the number of balanced parentheses for higher values of N.
//        For N=5, the balanced parentheses can be represented as
//        (Inside[I]) Outside[O]
//
//        We can analyze it by putting all possible bracket combinations in the inside & outside area.
//        (0 I ) 4 O  = cnt[0]*cnt[4]
//        (1 I ) 3 O = cnt[1]*cnt[3]
//        (2 I ) 2 O = cnt[2]*cnt[2]
//        (3 I ) 1 O = cnt[3]*cnt[1]
//        (4 I ) 0 O = cnt[4]*cnt[0]
//        cnt[5] = cnt[0]*cnt[4] + cnt[1]*cnt[3] + cnt[2]*cnt[2] + cnt[3]*cnt[1] + cnt[4]*cnt[0]
//
//        The above pattern makes an important family of numbers known as Catalan numbers. We can create an array cnt[N+1] to store the answers for different values of N.
//
//        Catalan Family of Numbers
//        Time complexity: O(N^2)
//        Space complexity: O(N)
        int countOfBalancedParenthesis = getCountOfBalancedParenthesis(6);
        System.out.println(countOfBalancedParenthesis);

        System.out.println(getCountOfBalancedParenthesis(2));
        System.out.println(getCountOfBalancedParenthesis(3));

    }

    private static int getCountOfBalancedParenthesis(int n) {
        int[] cnt = new int[n+1];
        cnt[0] = 1;
        cnt[1] = 1;
        for (int i=2; i<=n;i++){
            cnt[i] = 0;
            for (int j=0;j<=i-1;j++){
                cnt[i] += cnt[j]+cnt[i-1-j];
            }
        }
        return cnt[n];
    }
}
