package Searching.Concept;

public class AllocateTheBooks {
    /* Class Pair is used to return two values from getMinMax() */
    static class Pair {

        int max;
        int sumOfAllElement;
    }
    public static void main(String[] args){
//        Allocate the Books
//        We have been given ‘N’ books containing P[ ] = {P0, P1, P2,.., PN} pages respectively.
//        We have to allocate ‘N’ books to ‘M’ students such that:
//
//        Each student gets at least one book
//        All the books should be allotted
//        Allotment must be contiguous
//        We have to allocate them in such a manner that the maximum number of pages allocated to any student is minimum.
//        Given that no partial allocation of books is allowed.
//
//        Input: N = 4, M = 2, P[4] = {12, 24, 67, 90}
//        Output: 113
//        Explanation: Consider all valid combinations:
//
//        Case 1: S1 = 12 | S2 = (24+67+90) = 191
//        Maximum = 191
//        Case 2: S1 = (12+24) = 36 | S2 = (67+90) = 157
//        Maximum = 157
//        Case 3: S1 = (12+24+67) = 113 | S2 = 90
//        Maximum = 113
//
//        Answer = Minimum(Maximum in Case 1, Case 2, Case 3) = 113
//
//        Approach: Hint: Focus on the upper bound on the maximum number of pages(d) allocated to any student in a specific configuration.
//        If it is possible to allocate ‘N’ books to ‘M’ students such that the upper bound on the maximum number of pages(d) is 120 then, it is also possible for d>=120.
//        Similarly, if it is not possible to allocate ‘N’ books to ‘M’ students for d=95 then, it is also not possible for d<95.
//        Therefore, we have a monotonic function on which we can apply binary search to find the answer.
//        Where low = maximum number of pages a book contains
//        And high = total sum of pages of all the books
//        We can implement a function to check whether it is possible to allocate ‘N’ books to ‘M’ students or not, considering the provided constraints.
//        Note: We should allocate the books in a greedy fashion such that a student gets as many pages as possible, below the upper bound.
//        Time complexity: O(Nlog((i=0)Σ(i=N-1)(P[i] - max)))
//        Space complexity: O(1)
//        Note: In the problem statement, we have not been given any relation between N & M. Therefore we have to
//        account for cases where N<M since the allocation is not possible in such a case

        int[] pages = {12, 34, 67, 90};
        int minPages = allocateUsingBinarySearch(pages, pages.length, 2);
        System.out.println(minPages);
    }

    private static int allocateUsingBinarySearch(int[] pages, int N, int M) {
        if (M > N){//allocation not possible for all the student
            return -1;
        }
        Pair lowAndHigh = getLowAndHigh(pages, N);
        int l = lowAndHigh.max, h = lowAndHigh.sumOfAllElement;

        while (l<=h){
            int m = (l+h)/2;
            boolean r = isPossible(pages, m, M, N);
            if (!r){
                l = m+1;
            }else {
                boolean r1 = isPossible(pages, m - 1, M, N);
                if (!r1){
                    return m;
                }else {
                    h = m-1;
                }
            }
        }
        return -1;
    }

    private static boolean isPossible(int[] a, int mid, int m, int n) {
        int count = 1, sum = 0;//count to check book allocated to student and sum is the sum of pages

        for (int i=0; i<n; i++){
            if (sum+a[i] > mid){
                count++;
                sum = a[i];
            }else {
                sum += a[i];
            }
        }
        return count<=m;//if count>m i.e we need more student
        //if count<m we dont need to worry since there will be atleast 1 config for m<=n
    }

    private static Pair getLowAndHigh(int[] pages, int n) {
        Pair pair = new Pair();
        pair.max = pages[0];
        pair.sumOfAllElement = pages[0];

        for (int i=1; i<n; i++){
            pair.max = Math.max(pair.max, pages[i]);
            pair.sumOfAllElement += pages[i];
        }
        return pair;
    }
}
