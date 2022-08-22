package BasicProgramming.Arrays;


import java.util.*;
import java.util.stream.Collectors;

public class ChefAndRainbow {
    public static void main(String []args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=608&sectionId=1&moduleId=0&topicId=42&subtopicId=585&assignmentId=93

        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        s.nextLine();

        for (int i=0; i<T; i++){
            int N = s.nextInt();    s.nextLine();
            List<Integer> arr = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            boolean rainbowArrayOrNot = checkIfRainbowArrayOrNot(arr, N);
            System.out.println(rainbowArrayOrNot ? "yes" : "no");
        }
    }

    private static boolean checkIfRainbowArrayOrNot(List<Integer> arr, int n) {
        int p = 0, q = n-1;
        boolean flag = true;
        //check palindromic property
        while (p<q){
            if (arr.get(0) > 1 || arr.get(p) == 0) {
                flag = false;
                break;
            }
            if (Objects.equals(arr.get(p), arr.get(q))) {
                p++;
                q--;
            } else {
                flag = false;
                break;
            }
        }
        //check 1-7 and 1st increasing
        int prev = arr.get(0);
        Set<Integer> elem = new HashSet<>();
        elem.add(prev);
        int j = (n % 2) == 0 ? (n / 2) - 1 : (n / 2);
        for (int i=1; i<=j && flag; i++){
            elem.add(arr.get(i));
            if (arr.get(i) == prev){
                continue;
            }
            else if (arr.get(i) > prev && (arr.get(i)-prev) == 1 && arr.get(i)<=7){
                prev = arr.get(i);
            }else {
                flag = false;
                break;
            }
        }
        return flag && elem.size()==7;
    }
}