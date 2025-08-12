import java.util.BitSet;

public class BailliePSWForJava {

    public static boolean baillie_psw(long candidate){
        //Perform the Baillie-PSW probabilistic primality test on candidateS

        //Check divisibility by a short list of primes less than 50
        for (long known_prime : new long []{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47}){
            if (candidate == known_prime)
                return true;
            else if (candidate % known_prime == 0)
                return false;
        }

        //Now perform the Miller-Rabin primality test base 2
        if (!millerRabinBase2(candidate))
            return false;

        //Check that the number isn't a square number, as this will throw out
        //calculating the correct value of D later on (and means we have a
        //composite number)

        double sr = Math.sqrt(candidate);

        // If square root is an integer 
        boolean perfectSquare = ((sr - Math.floor(sr)) == 0);

        if (perfectSquare) return false;

        //Finally perform the Lucas primality test
        long D = DChooser(candidate);
        if (!lucas_pp(candidate, D, 1, (long)(1-D)/4))
            return false;

        //You've probably got a prime!
        return true;
    }

    static long DChooser(long candidate){
        //Choose a D value suitable for the Baillie-PSW test
        long D = 5;
        while (jacobiSymbol(D, candidate) != -1){
            D += ( D > 0 ? 2 : -2);
            D *= -1;
        }

        return D;
    }


    //Perform the Miller Rabin primality test base 2
    static public boolean millerRabinBase2(long number){
        long d = number - 1;
        long s = 0;

        while(d % 2 == 0){
            d = d >> 1;
            s += 1;
        }

        long x = powerModulus(2, d, number);

        if (x == 1 || x== number -1) return  true;

        for (int i = 0; i < s - 1; i++) {
            x = powerModulus(x, 2, number);
            if (x == 1) return  false;
            else if (x == number -1) return true;
        }
        return false;
    }




    //Emulating Python's efficient pow(x,y,z)
    static long powerModulus(long base, long exponent, long modulus)
    {
        // Initialize result 
        long res = 1;

        // Update x if it is more   
        // than or equal to p 
        base = base % modulus;

        while (exponent > 0)
        {
            // If y is odd, multiply x 
            // with result 
            if((exponent & 1)==1)
                res = (res * base) % modulus;

            // y must be even now 
            // y = y / 2 
            exponent = exponent >> 1;
            base = (base * base) % modulus;
        }
        return res;
    }


    //Calculate the Jacobi symbol (a/n)
    static long jacobiSymbol(long a, long n){
        if (n == 1) return 1;
        else if (a == 0) return 0;
        else if (a == 1) return 1;
        else if (a == 2){
            if (n % 8 >= 3 && n % 8 <= 5) return -1;
            else if (n % 8 >= 1 && n % 8 <= 7) return 1;
        }
        else if (a < 0)
            return (long) Math.pow(-1, ((n-1)/2)) * jacobiSymbol(-1 * a, n);

        if (a % 2 == 0)
            return (long)jacobiSymbol(2, n) * jacobiSymbol((a / 2), n);
        else if (a % n != a)
            return jacobiSymbol(a % n, n);
        else{
            if (a % 4 == 3 && n % 4 == 3)
                return -1 * jacobiSymbol(n, a);
            else
                return jacobiSymbol(n, a);
        }
    }

    public static BitSet convert(long value) {
        BitSet bits = new BitSet();
        int index = 0;
        while (value != 0L) {
            if (value % 2L != 0) {
                bits.set(index);
            }
            ++index;
            value = value >>> 1;
        }
        return bits;
    }

    static long[] UVSubscript(long k, long n, long U, long V, long P, long Q, long D){
        BitSet bitDigits = convert(k);
        long subscript = 1;
        long oldU;
        for (int i = bitDigits.length()-2; i >= 0; i--) {
            U = U*V % n;
            V = (powerModulus(V, 2, n) - 2*powerModulus(Q, subscript, n)) % n;

            subscript *= 2;

            if (bitDigits.get(i)){


                if (((P * U + V) & 1) == 0){
                    if (((D*U + P*V) & 1) == 0){
                        oldU = U;
                        U = (P*U + V) >> 1;
                        V = (D*oldU + P*V) >> 1;
                    }else{
                        oldU = U;
                        U = (P*U + V) >> 1;
                        V = (D*oldU + P*V + n) >> 1;
                    }
                } else if (((D * U + P * V) & 1) == 0){
                    oldU = U;
                    U = (P*U + V + n) >> 1;
                    V = (D*oldU + P*V) >> 1;
                }else{
                    oldU = U;
                    U = (P*U + V + n) >> 1;
                    V = (D*oldU + P*V + n) >> 1;
                }

                subscript += 1;
                U = U % n;
                V = V % n;

            }
        }
        return new long[]{U, V};
    }

    static boolean lucas_pp(long number, long D, long P, long Q){

        long[] UV = UVSubscript(number+1, number, 1, P, P, Q, D);

        if (UV[0] != 0) return false;

        long d = number + 1;
        long s = 0;

        while ((d & 1) == 0){
            d = d >> 1;
            s += 1;
        }

        UV = UVSubscript(number + 1, number , 1, P, P, Q, D);

        if (UV[0] == 0 || UV[1] == 0) return true;

        for (int i = 0; i < s - 1 ; i++) {
            UV[0] = (UV[0]*UV[1]) % number;
            UV[1] = (powerModulus(UV[1], 2, number) - 2*powerModulus(Q, d*((long)Math.pow(2, i)), number)) % number;
            if (UV[1] == 0) return true;
        }
        return false;
    }
//Tomado de: https://gist.github.com/andersonaddo/b16e9288758b2968758cba82391f90bd
}