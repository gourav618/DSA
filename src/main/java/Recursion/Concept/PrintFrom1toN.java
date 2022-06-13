package Recursion.Concept;

public class PrintFrom1toN {
    public static void main(String[] args){
        //how to print the natural numbers from 1 to N with the help of recursion.

        printUsingExtraVariable(1, 4);
        System.out.println();

        printReverseSeries(4);
        System.out.println();

        printWithoutUsingExtraVar(4);
    }

    private static void printWithoutUsingExtraVar(int n) {
        if (n<1){
            return;
        }
        printWithoutUsingExtraVar(n-1);
        System.out.print(n+" ");
    }

    private static void printReverseSeries(int n) {
        if (n<1)
            return;
        System.out.print(n+" ");
        printReverseSeries(n-1);
    }

    private static void printUsingExtraVariable(int x, int n) {
        if (x>n){
            return;
        }
        System.out.print(x+" ");
        printUsingExtraVariable(x+1, n);
    }
}
