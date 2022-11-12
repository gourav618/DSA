package Arrays.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BestTimeToBuyAndSellStock3 {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=6&sectionId=1&moduleId=1&topicId=1&subtopicId=6&homeworkId=1

        //calculate the prefixMin and suffixMax arrays,
        //Now that done you need to calculate the max transaction that you can make till now,
        //-> prefixMaxTransaction = max(prefixMaxTransaction, arr[i]-prefixMin[i]),
        //and the max transaction you can make by buying the current arr[i] and selling in future
        //-> cur = suffixMax[i] - arr[i]
        //Now the final answer can be calculated by: ans = max(ans, prefixMaxTransaction + cur)

        //See prefixMaxTransaction is the maximum transaction that could occur till now
        //say the array is 2 3 1 4 5 3 1 5
        //
        //now assume 0 based indexing for this array and say you are index 4, i.e., arr[i]=5
        //
        //now the maximum profit transaction till this point will be, 5-1 that is buying the stock when it had price 1
        // and selling it when it had price 5, this can be calculated using the formula:
        //
        //prefixMaxTransaction = max(prefixMaxTransaction, arr[i]-prefixMin[i])
        //Now prefixMaxtransaction will remain 4 till we reach i=6, you can see this by dry running the code, now here cur will be
        //cur= suffixMax[6]-arr[6] = 5  - 1 = 4
        //and hence ans = max(ans, prefixMaxTransaction + cur ) = max(ans, 4+ 4) =8
        //which gives the answer

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        //suffix max
        int[] sMax = new int[n];
        sMax[n-1] = arr.get(n-1);
        for (int i=n-2; i>=0; i--){
            sMax[i] = Math.max(sMax[i+1], arr.get(i));
        }

        //prefix min
        int[] pMin = new int[n];
        pMin[0] = arr.get(0);
        for (int i=1; i<n; i++){
            pMin[i] = Math.min(pMin[i-1], arr.get(i));
        }

        int ans = Integer.MIN_VALUE, prefixMaxTran = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            prefixMaxTran = Math.max(prefixMaxTran, arr.get(i) - pMin[i]);
            int curr = sMax[i] - arr.get(i);
            ans = Math.max(ans, prefixMaxTran + curr);
        }
        System.out.println(ans);
    }
}
