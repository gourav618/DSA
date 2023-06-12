package Searching.Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Hamburgers {
    public static void main(String[] args){
        //https://codeforces.com/problemset/problem/371/C

        Scanner s = new Scanner(System.in);
        String recipe = s.nextLine();
        List<Integer> stock = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> prices = Arrays.stream(s.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        long rubles = s.nextLong();

        System.out.println(getMaxBurgers(recipe, stock, prices, rubles));

    }

    private static long getMaxBurgers(String recipe, List<Integer> stock, List<Integer> prices, long rubles) {
        long low=0, high = (long)(1e13);
        while (low<=high){
            long mid = low + (high-low)/2;
            boolean r = canMake(recipe, stock, prices, rubles, mid);
            if (!r){
                high = mid-1;
            }else {
                boolean r1 = canMake(recipe, stock, prices, rubles, mid + 1);
                if (!r1){
                    return mid;
                }else {
                    low = mid+1;
                }
            }
        }
        return 0L;
    }

    private static boolean canMake(String recipe, List<Integer> stock, List<Integer> prices, long rubles, long mid) {
        long reqBread=0, reqSausage=0, reqCheese=0;
        for (int i=0;i<recipe.length(); i++){
            if (recipe.charAt(i) == 'B'){
                reqBread++;
            }
            if (recipe.charAt(i) == 'S'){
                reqSausage++;
            }
            if (recipe.charAt(i) == 'C'){
                reqCheese++;
            }
        }
        long totalBreadReq = Math.max(0L, mid * reqBread - stock.get(0));
        long totalSausageReq = Math.max(0L, mid * reqSausage - stock.get(1));
        long totalCheeseReq = Math.max(0L, mid * reqCheese - stock.get(2));
        long moneyReq = totalBreadReq*prices.get(0) + totalSausageReq*prices.get(1) + totalCheeseReq*prices.get(2);
        return rubles >= moneyReq;
    }
}
