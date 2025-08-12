import java.math.BigInteger;
import java.security.SecureRandom;

public class PruebaSolovayStrassen {


    private static final SecureRandom rnd = new SecureRandom();

    // calcula el símbolo de Jacobi (a/n), con n impar > 1
    public static int jacobi(BigInteger a, BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) <= 0 || n.mod(BigInteger.TWO).equals(BigInteger.ZERO))
            throw new IllegalArgumentException("n debe ser impar y > 0");

        a = a.mod(n);
        int result = 1;
        while (a.compareTo(BigInteger.ZERO) != 0) {
            while (a.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                a = a.shiftRight(1);
                BigInteger nMod8 = n.mod(BigInteger.valueOf(8));
                if (nMod8.equals(BigInteger.valueOf(3)) || nMod8.equals(BigInteger.valueOf(5))) {
                    result = -result;
                }
            }
            // intercambio a <-> n
            BigInteger tmp = a;
            a = n;
            n = tmp;
            if (a.mod(BigInteger.valueOf(4)).equals(BigInteger.valueOf(3)) &&
                    n.mod(BigInteger.valueOf(4)).equals(BigInteger.valueOf(3))) {
                result = -result;
            }
            a = a.mod(n);
        }
        return n.equals(BigInteger.ONE) ? result : 0;
    }

    public static boolean isProbablePrime(BigInteger n, int rounds) {
        if (n.compareTo(BigInteger.TWO) < 0) return false;
        if (n.equals(BigInteger.TWO)) return true;
        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) return false;

        for (int i = 0; i < rounds; i++) {
            BigInteger a;
            do {
                a = new BigInteger(n.bitLength(), rnd);
            } while (a.compareTo(BigInteger.TWO) < 0 || a.compareTo(n.subtract(BigInteger.TWO)) > 0);

            int x = jacobi(a, n);
            if (x == 0) return false;
            BigInteger modExp = a.modPow(n.subtract(BigInteger.ONE).shiftRight(1), n);
            BigInteger jacobiMod = BigInteger.valueOf(x == 1 ? 1 : n.subtract(BigInteger.ONE));

            if (!modExp.equals(jacobiMod)) return false;
        }
        return true;
    }
}
