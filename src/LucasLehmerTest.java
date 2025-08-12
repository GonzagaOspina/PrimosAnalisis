import java.util.ArrayList;

public class LucasLehmerTest {

    // Function to find out
    // first n terms(considering
    // 4 as 0th term) of Lucas-
    // Lehmer series.
    static void LucasLehmer(int n)
    {

        // the 0th term of
        // the series is 4.
        long current_val = 4;

        // create an array
        // to store the terms.
        ArrayList<Long> series = new ArrayList<>();

        // compute each term
        // and add it to the array.
        series.add(current_val);
        for (int i = 0; i < n; i++)
        {
            current_val = current_val
                    * current_val - 2;
            series.add(current_val);
        }

        // print out the
        // terms one by one.
        for (int i = 0; i <= n; i++)
        {
            System.out.println("Term " + i
                    + ": " + series.get(i));
        }
    }

    // Driver Code
    public static void main(String[] args)
    {

        int n = 5;
        LucasLehmer(n);
    }

    //TOMADO DE: https://www.geeksforgeeks.org/dsa/primality-test-using-lucas-lehmer-series/
}

// This code has been contributed by 29AjayKumar