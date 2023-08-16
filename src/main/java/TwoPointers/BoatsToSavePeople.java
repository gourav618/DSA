package TwoPointers;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args){
        //https://leetcode.com/problems/boats-to-save-people/description/

        int[] people = {3,5,3,4};
        int limit = 5;

        System.out.println(numRescueBoats(people, limit));
    }

    private static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0, j= people.length-1;
        int count = 0;
        while (i<=j){
            int currWeight = people[i]+people[j];
            if (currWeight > limit){
                if (people[j] <= limit)
                    count++;
            } else {
                count++;
                i++;
            }
            j--;
        }
        return count;
    }
}
