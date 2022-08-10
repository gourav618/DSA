package BasicProgramming.loops;

import java.util.Scanner;

public class Receipt {
    public static void main(String[] args){
        //https://dashboard.programmingpathshala.com/practice/question?questionId=601&sectionId=1&moduleId=0&topicId=41&subtopicId=573&assignmentId=92

//        Tomya like a positive integer p, and now she wants to get a receipt of Ciels restaurant whose total price is exactly p.
//        The current menus of Ciels restaurant are shown the following table.
//
//        Name of Menu - Price
//
//        eel flavored water - 1
//        deep-fried eel bones - 2
//        clear soup made with eel livers - 4
//        grilled eel livers served with grated radish - 8
//        savory egg custard with eel - 16
//        eel fried rice (S) - 32
//        eel fried rice (L) - 64
//        grilled eel wrapped in cooked egg - 128
//        eel curry rice - 256
//        grilled eel over rice - 512
//        deluxe grilled eel over rice - 1024
//        eel full-course - 2048

//        4
//        10 ->2
//        256 ->1
//        255 ->8
//        4096 ->2

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        //solution 1
        recieptSolution(s, T);

        //another solution
        recieptAnotherSolution(s, T);
    }

    private static void recieptSolution(Scanner s, int T) {
        for (int i = 0; i< T; i++){
            int p = s.nextInt();
            int count = 0;

            if (p >= 2048){
                count += (p/2048);
                p %= 2048;
            }
            if (p >= 1024){
                count++;
                p -= 1024;
            }
            if (p >= 512){
                count++;
                p -= 512;
            }
            if (p >= 256){
                count++;
                p -= 256;
            }
            if (p >= 128){
                count++;
                p -= 128;
            }
            if (p >= 64){
                count++;
                p -= 64;
            }
            if (p >= 32){
                count++;
                p -= 32;
            }
            if (p >= 16){
                count++;
                p -= 16;
            }
            if (p >= 8){
                count++;
                p -= 8;
            }
            if (p >= 4){
                count++;
                p -= 4;
            }
            if (p >= 2){
                count++;
                p -= 2;
            }
            if (p == 1){
                count++;
                p -= 1;
            }
            System.out.println(count);
        }
    }

    private static void recieptAnotherSolution(Scanner s, int T) {
        for (int i = 0; i< T; i++){
            int p = s.nextInt();
            int count = 0;

            if (p>2048){
                while (p >= 2048){
                    p -= 2048;
                    count++;
                }
            }
            while (p!=0){
                int x=1;
                while (x <= p){
                    x *= 2;
                }
                x /= 2;
                p -= x;
                count++;
            }
            System.out.println(count);
        }
    }
}
