package BitManipulation.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MissingAndRepeatingIntegers {
    public static void main(String[] args) throws IOException {
        //https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=222&sectionId=1&moduleId=2&topicId=9&subtopicId=141&homeworkId=32

        //idea is take xor of element in array -> xorArrayElem
        //then take xor of element from 1 to n -> xorOneToN
        //xorArrayElem ^ xorOneToN = n1 ^ n2 where n1 or n2 is the missing number and the repeating ones
        //then separate the number in 2 categories where the least significant bit is 1 and other 0
        //and find n1 and n2

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int xorOfAllArrayElement = 0;
        for (int i=0; i<n; i++){
            xorOfAllArrayElement ^= arr[i];
        }

        int xorOfElementOneToN = 0;
        for (int i=1; i<=n; i++){
            xorOfElementOneToN ^= i;
        }

        int requiredElement = (xorOfAllArrayElement ^ xorOfElementOneToN);

        int leastSetBit = 1;
        while ((leastSetBit & requiredElement) == 0){
            leastSetBit <<= 1;
        }

        int missingElement=0, repeatedElement=0;
        int val1=0, val2;
        for (int i=0; i<n; i++){
            //xor with array elem
            if ((arr[i] & leastSetBit) != 0){
                val1 ^= arr[i];
            }
            //xor from 1 to n
            if (((i+1) & leastSetBit) != 0){
                val1 ^= (i+1);
            }
        }
        val2 = (val1 ^ requiredElement);

        //check which number is repeating
        for (int i=0; i<n; i++){
            if (arr[i] == val1){
                repeatedElement = val1;
                missingElement = val2;
                break;
            } else if (arr[i] == val2) {
                repeatedElement = val2;
                missingElement = val1;
                break;
            }
        }
        System.out.println(repeatedElement+" "+missingElement);
    }
}
