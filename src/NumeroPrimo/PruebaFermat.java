package NumeroPrimo;

import java.util.Random;

public class PruebaFermat {
    public static boolean PrimosFermat(int n, int iter) {
        if (n < 4) {
            return n == 2 || n == 3;
        }

        Random rand = new Random();

        for (int i = 0; i < iter; i++) {
            int a = 2 + rand.nextInt(n - 3); // Entre 2 y n-2
            if (binpower(a, n - 1, n) != 1) {
                return false; // compuesto
            }
        }
        return true; // probablemente primo
    }

    private static long binpower(long base, long exp, long mod) {
        long result = 1;
        long b = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * b) % mod;
            }
            b = (b * b) % mod;
            exp >>= 1;
        }
        return (int) result;
    }

    public static void main(String[] args) {
// FERMAT
        int n1 = 31;
        int n2 = 5749;

        long startTime1 = System.nanoTime(); // ⏱️ Start
        System.out.println(n2 + " es primo? " + PrimosFermat(n2, 178686));
        long endTime1 = System.nanoTime();   // ⏱️ End
        long duration1 = endTime1 - startTime1; // Total time in nanoseconds
        System.out.println("Tiempo de ejecución: " + duration1 + " ns");

        }
// INFORMACION TOMADA DE: https://cp-algorithms.com/algebra/primality_tests.html
}



