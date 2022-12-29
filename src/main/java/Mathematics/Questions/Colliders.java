package Mathematics.Questions;

import java.util.*;

public class Colliders {
    public static void main(String[] args) {
        //https://codeforces.com/contest/155/problem/D

        //approach1();
        //todo: optimize this algorithm
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] primeDivisors = new ArrayList[n + 1];
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            primeDivisors[i] = new ArrayList<>();
            isPrime[i] = true;
        }
        isPrime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primeDivisors[i].add(i);
                for (int j = 2 * i; j <= n; j += i) {
                    isPrime[j] = false;
                    primeDivisors[j].add(i);
                }
            }
        }
        int[] divisors = new int[n + 1];
        for (int i = 0; i < m; i++) {
            String op = sc.next();
            int collider = sc.nextInt();
            if (op.equals("+")) {
                if (divisors[collider] != 0 && divisors[collider] == collider) {
                    System.out.println("Already on");
                } else {
                    boolean conflict = false;
                    int conflictCollider = 0;
                    for (int d : primeDivisors[collider]) {
                        if (divisors[d] != 0) {
                            conflict = true;
                            conflictCollider = divisors[d];
                            break;
                        }
                    }
                    if (conflict) {
                        System.out.println("Conflict with " + conflictCollider);
                    } else {
                        for (int d : primeDivisors[collider]) {
                            divisors[d] = collider;
                        }
                        divisors[collider] = collider;
                        System.out.println("Success");
                    }
                }
            } else {  // op is "-"
                if (divisors[collider] == 0 || divisors[collider] != collider) {
                    System.out.println("Already off");
                } else {
                    for (int d : primeDivisors[collider]) {
                        divisors[d] = 0;
                    }
                    divisors[collider] = 0;
                    System.out.println("Success");
                }
            }
        }

    }

    private static void approach1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Precompute the prime factorization of all colliders using a sieve algorithm
        Map<Integer, List<Integer>> colliders = new HashMap<>();
        for (int i = 2; i <= n; i++) {
            if (!colliders.containsKey(i)) {  // i is prime
                for (int j = i; j <= n; j += i) {
                    List<Integer> factors = colliders.getOrDefault(j, new ArrayList<>());
                    factors.add(i);
                    colliders.put(j, factors);
                }
            }
        }
        colliders.put(1, List.of(1));

        int []status = new int[n+1];
        // Process the requests
        for (int i = 0; i < m; i++) {
            String request = sc.next();
            int collider = sc.nextInt();
            if (request.equals("+")) {  // Activate the collider
                if (i==0){
                    status[collider] = 1;
                    System.out.println("Success");
                }
                else if (status[collider] == 1) {
                    System.out.println("Already on");
                } else {
                    // Check for conflicts with other activated colliders
                    boolean conflict = false;
                    for (int j : colliders.keySet()) {
                        if (status[j] != 0) {
                            // Check if collider and j are relatively prime
                            boolean relativelyPrime = true;
                            for (int factor : colliders.get(collider)) {
                                if (colliders.get(j).contains(factor)) {
                                    relativelyPrime = false;
                                    break;
                                }
                            }
                            if (!relativelyPrime) {
                                System.out.println("Conflict with " + j);
                                conflict = true;
                                break;
                            }
                        }
                    }
                    if (!conflict) {
                        status[collider] = 1;
                        System.out.println("Success");
                    }
                }
            } else {  // request is "-", deactivate the collider
                if (status[collider] == 0) {
                    System.out.println("Already off");
                } else {
                    status[collider] = 0;
                    System.out.println("Success");
                }
            }
        }
    }
}
