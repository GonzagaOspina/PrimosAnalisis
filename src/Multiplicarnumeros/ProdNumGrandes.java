package Multiplicarnumeros;

import java.util.Arrays;

public class ProdNumGrandes {

    public static void main(String[] args) {
    int[] arr1= {1,5};
    int[] arr2= {2,2};

    System.out.print(Arrays.toString(americano(arr1, arr2)));
    }
    public static int[] americano ( int arreglo1[], int arreglo2[] )
    {

        int resultado []= new int [arreglo1.length + arreglo2.length];
        for ( int i = arreglo2.length-1 ; i >= 0; i-- )
        {

            for ( int j = arreglo1.length-1; j >= 0 ; j-- )
            {

                resultado [ i + j + 1 ] += arreglo1 [ j ] * arreglo2 [ i ];
                resultado [ i + j ] += (resultado [ i + j + 1 ] / 10);
                resultado [ i + j + 1 ] %= 10;

            }

        }
        return resultado;

    }
}
