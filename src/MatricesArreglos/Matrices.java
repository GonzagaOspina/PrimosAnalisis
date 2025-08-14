package MatricesArreglos;

public class Matrices {
    public static void main(String[] args) {
        double[][] matriz= new double[3][3];
        matriz[0][0] = 1;
        matriz[0][1] = 2;
        matriz[0][2] = 3;
        matriz[1][0] = 2;
        matriz[1][1] = 5;
        matriz[1][2] = 6;
        matriz[2][0] = 3;
        matriz[2][1] = 6;
        matriz[2][2] = 9;
        System.out.println(esSimetrica(matriz));
        System.out.println(esSimetrica2(matriz));
    }

    // Simetria Matrices 1
    public static boolean esSimetrica ( double[][] arreglo )
    {
        boolean aux = true;
        for (int i = 0; i < arreglo.length && aux==true; i++ )
        {
            for (int j = 0; j < arreglo[0].length && aux==true ; j++ )
            {
                if (arreglo[i][j]!= arreglo[j][i] && i!=j)
                {
                    aux=false;
                }
            }
        }
        return aux;
    }
    //Simetria Matrices 2
    public static boolean esSimetrica2(double[][] arreglo)
    {
        for (int i = 0; i < arreglo.length; i++)
        {
            for (int j = i + 1; j < arreglo.length; j++)
            {
                if (arreglo[i][j] != arreglo[j][i])
                {
                    return false;
                }
            }
        }
        return true;
    }
// producto matrices 1
public int[][] naivStandard(int [][] A, int [][] B)
{
    int [][] matriz = new int [A.length][B[0].length];
    int auxiliar;
    if (A[0].length == B.length)
    {
        for (int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < B[0].length; j++)
            {
                auxiliar = 0;
                for (int k = 0; k < B.length; k++){
                    auxiliar += (A[i][k] * B[k][j]);
                }
                matriz[i][j] = auxiliar;
            }
        }
    }
    return matriz;
}




}