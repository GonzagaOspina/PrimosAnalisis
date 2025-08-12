import java.io.FileWriter;
import java.io.IOException;

public class PrimeNumbers {

    public static void main(String[] args) {
        int numero = 5749;
        int itr = 100;
// PRIMOS 1
        long sumaTiempos1=0;
        for (int i = 0; i < itr; i++) {
            long startTime1 = System.nanoTime(); // ⏱️ Start
            boolean resultado1 = determinarNumeroPrimo1(numero); // 🔁 Function call
            long endTime1 = System.nanoTime();   // ⏱️ End

            long duration1 = endTime1 - startTime1; // Total time in nanoseconds


            sumaTiempos1=sumaTiempos1+duration1;
        }
        long prom1=sumaTiempos1/itr;
        System.out.println("Tiempo de ejecución promedio: " + prom1 + " ns");
// PRIMOS 2
//        long sumaTiempos2=0;
//        for (int i = 0; i < itr; i++) {
//
//            long startTime2 = System.nanoTime(); // ⏱️ Start
//            boolean resultado2 = determinarNumeroPrimo2(numero); // 🔁 Function call
//            long endTime2 = System.nanoTime();   // ⏱️ End
//
//            long duration2 = endTime2 - startTime2; // Total time in nanoseconds
//
//            sumaTiempos2=sumaTiempos2+duration2;
//        }
//        long prom2=sumaTiempos2/itr;
//        System.out.println("Tiempo de ejecución promedio: " + prom2 + " ns");
// PRIMOS 3
//        long sumaTiempos3=0;
//        for (int i = 0; i < itr; i++) {
//
//            long startTime3 = System.nanoTime(); // ⏱️ Start
//            boolean resultado3 = determinarNumeroPrimo3(numero); // 🔁 Function call
//            long endTime3 = System.nanoTime();   // ⏱️ End
//
//            long duration3 = endTime3 - startTime3; // Total time in nanoseconds
//            sumaTiempos3=sumaTiempos3+duration3;
//        }
//        long prom3=sumaTiempos3/itr;
//        System.out.println("Tiempo de ejecución promedio: " + prom3 + " ns");
        // PRIMO 4
//        long sumaTiempos4=0;
//        for (int i = 0; i < itr; i++) {
//
//            long startTime4 = System.nanoTime(); // ⏱️ Start
//            boolean resultado4 = determinarNumeroPrimo4(numero); // 🔁 Function call
//            long endTime4 = System.nanoTime();   // ⏱️ End
//
//            long duration4 = endTime4 - startTime4; // Total time in nanoseconds
//
//            sumaTiempos4=sumaTiempos4+duration4;
//        }
//        long prom4=sumaTiempos4/itr;
//        System.out.println("Tiempo de ejecución promedio: " + prom4 + " ns");
// PRIMO 5
//        long sumaTiempos5=0;
//        for (int i=0; i<itr; i++){
//            long startTime5 = System.nanoTime(); // ⏱️ Start
//        boolean resultado5 = determinarNumeroPrimo5(numero);
//        long endTime5 = System.nanoTime();   // ⏱️ End
//
//        long duration5 = endTime5 - startTime5; // Total time in nanoseconds
//
//        sumaTiempos5=sumaTiempos3+duration5;
//
//    }
//        long prom5=sumaTiempos5/itr;
//        System.out.println("Tiempo de ejecución promedio: " + prom5 + " ns");
    }


    public static boolean determinarNumeroPrimo1 (int numero)
    {
        int resultado = 0;
        for(int i = 2; i < numero; i++ )
        {
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
            if (numero % i == 0)
            {
                return false;
            }
        }
        return true;
    }


    public static void guardarTiempoEnArchivo(long tiempo) {
        try (FileWriter fw = new FileWriter("tiempos.csv", true)) { // true para añadir sin borrar
            fw.write(tiempo + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

}
