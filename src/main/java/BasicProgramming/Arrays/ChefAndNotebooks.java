package BasicProgramming.Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChefAndNotebooks {
    public static void main(String[] args){
        //https://www.codechef.com/problems/CNOTE

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();

        while (T > 0){
            List<Integer> xykn = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            int X = xykn.get(0), Y = xykn.get(1), K = xykn.get(2), N = xykn.get(3), flag=0;
            for (int i=0; i< N; i++){
                List<Integer> noteBooks = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                if (noteBooks.get(0) >= (X-Y) && noteBooks.get(1) <= K){
                    flag = 1;
                }
            }
            System.out.println(flag == 0 ? "UnluckyChef" : "LuckyChef");
            T--;
        }
    }
}
