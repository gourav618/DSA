package Mathematics.Concept;

import java.util.Arrays;

public class OpenCloseProblems {
    public static void main(String[] args){

        //Given int N, there are N doors[1,2,..,N-1,N] , initial state is closed
        //rule: 1-> play N rounds , 2 -> in ith round , toggle the state of all those doors that are multiple of i

        //Naive solution
        //do as the question says and toggle doors which are multiple of i for each round
        int openDoorsByBruteForce = getOpenDoorsByBruteForce(5);
        System.out.println(openDoorsByBruteForce);

        //optimized
        //We know that a door will be toggled only if it is divisible by ‘i’. This implies that a door will be toggled as many times as the number of factors it has.
        //Since we know that a perfect square has an odd number of factors while an imperfect square has an even number of factors.
        // Therefore, only the state of those doors will change that are a perfect square or the doors having an odd number of factors.
        // answer = (int)sqrt(N)
        int openDoorsBySquareRootMethod = getOpenDoorsBySquareRootMethod(120);
        System.out.println(openDoorsBySquareRootMethod);
    }

    // time -> o(1)
    private static int getOpenDoorsBySquareRootMethod(int n) {
        return (int)Math.sqrt(n);
    }

    private static int getOpenDoorsByBruteForce(int n) {
        Boolean[] state = new Boolean[n+1];
        Arrays.fill(state, false);
        for (int i=1;i<=n; i++){ // for no of rounds
            for (int j=1;j<=n;j++){
                if (j%i == 0){
                    if (!state[j])
                        state[j] = true;
                    else
                        state[j] = false;
                }
            }
        }
        int count = 0;
        for (int i=1;i< state.length;i++){
            if (state[i] == true){
                count++;
            }
        }
        return count;
    }
}
