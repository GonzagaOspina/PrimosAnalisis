public class WilsonPrimalityTest {

    // Function to calculate the factorial
    public static long fact(int p) {
        if (p <= 1) {
            return 1;
        }
        return p * fact(p - 1);
    }

    // Function to check if the number is prime or not
    public static boolean isPrime(int p) {
        if (p == 1) {
            return false;
        }
        return fact(p - 1) % p == p - 1;
    }

    // Driver code
    public static void main(String[] args) {
        System.out.println(isPrime(17));
    }

    // tomado de https://www.geeksforgeeks.org/dsa/implementation-of-wilson-primality-test/
}