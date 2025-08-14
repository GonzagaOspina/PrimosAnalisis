package NumeroPrimo;

import java.io.FileWriter;
import java.io.IOException;

public class PrimeNumbers {
    public static long contadorItr1 =0;
    public static long contadorItr2 =0;
    public static long contadorItr3 =0;
    public static long contadorItr4 =0;
    public static long contadorItr5 =0;
    public static boolean resultado1 ;
    public static boolean resultado2 ;
    public static boolean resultado3 ;
    public static boolean resultado4 ;
    public static boolean resultado5 ;
    public static void main(String[] args) {
        int numero = 12314123;
        int itr = 5;
// PRIMOS 1
        long sumaTiempos1=0;
        for (int i = 0; i < itr; i++) {
            long startTime1 = System.nanoTime(); // ⏱️ Start
            resultado1 = determinarNumeroPrimo1(numero);
            long endTime1 = System.nanoTime();   // ⏱️ End
            long duration1 = endTime1 - startTime1; // Total time in nanoseconds
            sumaTiempos1=sumaTiempos1+duration1;
        }
        long prom1=sumaTiempos1/itr;

        System.out.println("Tiempo de ejecución promedio: " + prom1 + " ns");
        System.out.println("Iteraciones: " + contadorItr1/itr);
        guardarTiempoEnArchivo("Algoritmo1", prom1, contadorItr1/itr, resultado1);

        // PRIMOS 2
        long sumaTiempos2=0;
        for (int i = 0; i < itr; i++) {
            long startTime2 = System.nanoTime(); // ⏱️ Start
            resultado2 = determinarNumeroPrimo2(numero); // 🔁 Function call
            long endTime2 = System.nanoTime();   // ⏱️ End
            long duration2 = endTime2 - startTime2; // Total time in nanoseconds
            sumaTiempos2=sumaTiempos2+duration2;
        }
        long prom2=sumaTiempos2/itr;
        System.out.println("Tiempo de ejecución promedio: " + prom2 + " ns");
        System.out.println("Iteraciones: " + contadorItr2/itr);
        guardarTiempoEnArchivo("Algoritmo2", prom2, contadorItr2/itr, resultado2);

// PRIMOS 3
        long sumaTiempos3=0;
        for (int i = 0; i < itr; i++) {
            long startTime3 = System.nanoTime(); // ⏱️ Start
            resultado3 = determinarNumeroPrimo3(numero); // 🔁 Function call
            long endTime3 = System.nanoTime();   // ⏱️ End
            long duration3 = endTime3 - startTime3; // Total time in nanoseconds
            sumaTiempos3=sumaTiempos3+duration3;
        }
        long prom3=sumaTiempos3/itr;
        System.out.println("Tiempo de ejecución promedio: " + prom3 + " ns");
        System.out.println("Iteraciones: " + contadorItr3/itr);
        guardarTiempoEnArchivo("Algoritmo3", prom3, contadorItr3/itr, resultado3);

        // PRIMO 4
        long sumaTiempos4=0;
        for (int i = 0; i < itr; i++) {

            long startTime4 = System.nanoTime(); // ⏱️ Start
            resultado4 = determinarNumeroPrimo4(numero); // 🔁 Function call
            long endTime4 = System.nanoTime();   // ⏱️ End

            long duration4 = endTime4 - startTime4; // Total time in nanoseconds

            sumaTiempos4=sumaTiempos4+duration4;
        }
        long prom4=sumaTiempos4/itr;
        System.out.println("Tiempo de ejecución promedio: " + prom4 + " ns");
        System.out.println("Iteraciones: " + contadorItr4/itr);
        guardarTiempoEnArchivo("Algoritmo4", prom4, contadorItr4/itr, resultado4);

        // PRIMO 5
        long sumaTiempos5=0;
        for (int i=0; i<itr; i++){
            long startTime5 = System.nanoTime(); // ⏱️ Start
        resultado5 = determinarNumeroPrimo5(numero);
        long endTime5 = System.nanoTime();   // ⏱️ End

        long duration5 = endTime5 - startTime5; // Total time in nanoseconds

        sumaTiempos5=sumaTiempos3+duration5;

    }

        long prom5=sumaTiempos5/itr;
        System.out.println("Tiempo de ejecución promedio: " + prom5 + " ns");
        System.out.println("Iteraciones: " + contadorItr5/itr);
        guardarTiempoEnArchivo("Algoritmo5", prom5, contadorItr5/itr, resultado5);
    }


    public static boolean determinarNumeroPrimo1 (int numero)
    {

        int resultado = 0;
        for(int i = 2; i < numero; i++ )
        {
            contadorItr1++;
            if (numero % i == 0)
            {
                resultado = 1;
            }
        }
        if (resultado == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean determinarNumeroPrimo2 (int numero)
    {
        boolean centi=true;
        for (int i=2; i <= numero / 2 && centi; i++)
        {
            contadorItr2++;
            if (numero % i == 0)
            {
                centi = false;
            }
        }
        return centi;
    }
    public static boolean determinarNumeroPrimo3 (int numero)
    {
        int i;
        for (i = 2 ; i <= numero / 2 ; i++ )
        {
            contadorItr3++;
            if ( numero % i == 0 )
            {
                break;
            }
        }
        if ( numero / 2 < i )
        {
            return true;
        }else{
            return false;
        }
    }
    public static boolean determinarNumeroPrimo4 (int numero)
    {
        for (int i = 2; i <= (int)Math.sqrt(numero); i++)
        {
            contadorItr4++;
            if (numero % i == 0)
            {
                return false;
            }
        }
        return true;
    }
    public static boolean determinarNumeroPrimo5 (int numero)
    {
        if (numero < 2)
        {
            return false;
        }
        for (int i = 2; i * i <= numero; i++)
        {
            contadorItr5++;
            if (numero % i == 0)
            {
                return false;
            }
        }
        return true;
    }


    public static void guardarTiempoEnArchivo(String nombreAlgoritmo, long tiempoPromedio, long iteracionesPromedio, boolean esPrimo) {
        try (FileWriter fw = new FileWriter("tiempos.csv", true)) { // true para añadir sin borrar
            fw.write(nombreAlgoritmo + "," + tiempoPromedio + "," + iteracionesPromedio + "," + esPrimo + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }


}
