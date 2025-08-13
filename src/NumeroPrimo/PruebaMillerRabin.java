package NumeroPrimo;

import java.util.Random;

public class PruebaMillerRabin {

    // Miller=-Rabin

    public static boolean PrimosMR(long n, int k) {
        // Casos triviales
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;

        // Escribimos n-1 como d * 2^r
        long r = 0;
        long d = n - 1;
        while ((d & 1) == 0) { // mientras d sea par
            d >>= 1;
            r++;
        }
        Random rand = new Random();

        // Repetimos k veces para mejorar la precisión
        for (int i = 0; i < k; i++) {
            // Elegimos un "testigo" aleatorio a en [2, n-2]
            long a = 2 + Math.abs(rand.nextLong()) % (n - 3);

            // Calculamos x = a^d mod n
            long x = binpower(a, d, n);

            // Si x es 1 o n-1, este test pasa
            if (x == 1 || x == n - 1) continue;

            boolean pasa = false;
            for (int j = 1; j < r; j++) {
                x = (x * x) % n; // x = x^2 mod n
                if (x == n - 1) {
                    pasa = true;
                    break;
                }
            }

            // Si nunca llegó a n-1, es compuesto
            if (!pasa) return false;
        }

        // Si pasa todos los tests, es probablemente primo
        return true;
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

        int n1 = 31;
        int n2 = 5749;

        long startTime1 = System.nanoTime(); // ⏱️ Start
        System.out.println(n2 + " es primo? " + PrimosMR(n2, 178686));
        long endTime1 = System.nanoTime();   // ⏱️ End
        long duration1 = endTime1 - startTime1; // Total time in nanoseconds
        System.out.println("Tiempo de ejecución: " + duration1 + " ns");

    }
// INFORMARCION TOMADA DE https://cp-algorithms.com/algebra/primality_tests.html
}
