package BasicProgramming.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MinimumMoves {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=607&sectionId=1&moduleId=0&topicId=42&subtopicId=585&assignmentId=93

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        List<Integer> salaries = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> salaries1 = new ArrayList<>(salaries);
        add1UntilAllElemAreSame(N, salaries1);

//        You could think as if in each operation instead of increasing n-1 elements by 1 is equivalent to decreasing the
//        chosen element by 1. So, the brute force solution will be to decrease the maximum element by 1 till all the elements become equal.
//        And since constraints are small, so it should work.
        List<Integer> salaries2 = new ArrayList<>(salaries);
        decrMaxElemUntilAllElemAreSame(N, salaries2);


        //        The optimal solution will be be the sum of the difference of all the elements of the array with a minimum element
//        not with the maximum element since, in each operation, we will be decreasing an element and for minimum steps ,
//        we will make all elements equal to minimum element of the array.

        //So let's say S is the sum of the numbers of array before we perform any operation and X is the final value of array
        // elements after we have performed all the operation. Let's also assume the number of operation performed before all
        // elements became equal were M. So can I say S + (N-1)*M = X * N holds true? (N-1) is the value that will be added
        // during each operation to the sum of array elements because we are adding 1 to all the elements except the largest
        // (therefore total elements who have 1 added to them are N-1, where N is the number of total elements in array and
        // we subtract 1 because we leave the largest)  in the Array during operation. Also minimum element at the start will
        // be the element we can definitely say will have 1 added to it in each operation as it will never be largest except
        // when all elements become equal. So we can also say minimumElementAtStart + (1*M) = X.  We can now use this info to calculate M .

        List<Integer> salaries3 = new ArrayList<>(salaries);
        sumOfDiffOfAllElements(salaries3, N);
    }

    private static void sumOfDiffOfAllElements(List<Integer> salaries, int n) {
        Integer minElem = salaries.stream().min(Integer::compare).get();
        int sum = 0;
        for (Integer salary: salaries){
            sum += (salary-minElem);
        }
        System.out.println(sum);
    }

    private static void decrMaxElemUntilAllElemAreSame(int n, List<Integer> salaries) {
        int count = 0,max, maxIndex = 0;
        Integer min = salaries.stream().min(Integer::compare).get();
        do {
            max = Integer.MIN_VALUE;
            for (int i=0; i<n; i++){
                if (salaries.get(i) >= max){
                    max = salaries.get(i);
                    maxIndex = i;
                }
            }
            if (min < max) {
                salaries.set(maxIndex, salaries.get(maxIndex) - 1);
                count++;
            }
        }while (min < max);
        System.out.println(count);
    }

    private static void add1UntilAllElemAreSame(int N, List<Integer> salaries) {
        int count = 0;
        if (salaries.stream().distinct().count() <= 1){
            System.out.println(0);
        }
        else {
            while (!(salaries.stream().distinct().count() <= 1)){
                int i = findMaxIndex(salaries);
                incrementOtherWorkers(salaries, i);
                count++;
            }
            System.out.println(count);
        }
    }

    private static int findMaxIndex(List<Integer> salaries) {
        int maxElem = salaries.get(0), maxElemIndex = 0;
        for(int i=1; i<salaries.size(); i++){
            if (salaries.get(i) > maxElem){
                maxElem = salaries.get(i);
                maxElemIndex = i;
            }
        }
        return maxElemIndex;
    }

    private static void incrementOtherWorkers(List<Integer> salaries, int n) {
        for (int i=0; i<salaries.size(); i++){
            if (i != n){//update all index except the selected done
                salaries.set(i, salaries.get(i)+1);
            }
        }
    }
}
