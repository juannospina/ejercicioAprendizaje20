/*
Un cuadrado mágico 3 x 3 es una matriz 3 x 3 formada por números del 1 al 9 donde la
suma de sus filas, sus columnas y sus diagonales son idénticas. Crear un programa que
permita introducir un cuadrado por teclado y determine si este cuadrado es mágico o no.
El programa deberá comprobar que los números introducidos son correctos, es decir,
están entre el 1 y el 9.
 */
package ejercicioaprendizaje20;

import java.util.Scanner;

public class EjercicioAprendizaje20 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int [][] matriz = new int[3][3];
       
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Ingresa un número entre 1 y 9 para la posición " + "[" + i + "]" + "[" + j + "]: ");
                matriz[i][j] = entrada.nextInt();
                if (matriz[i][j] < 1 || matriz[i][j] > 9) {
                    System.out.print("Error, solo se permite ingrese números entre 1 y 9, vuelve a intentarlo: ");
                    matriz[i][j] = entrada.nextInt();
                }
            }        
        }
        System.out.println("");
        llenarMatriz(matriz, entrada);
        matrizMagica(matriz);
                
    }
    public static void llenarMatriz(int [][] matriz, Scanner entrada){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("["+matriz[i][j]+"]");
            }
            System.out.println("");
        }
    }
    public static void matrizMagica(int [][] matriz){
        int fila0 = 0;
        int fila1 = 0;
        int fila2 = 0;
        int columna0 = 0;
        int columna1 = 0;
        int columna2 = 0;
        int diagonalPrincipal = 0;
        int diagonalInversa = 0;
        boolean magico = false;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fila0 += matriz[0][j];//primer fila
                fila1 += matriz[1][j];//segunda fila
                fila2 += matriz[2][j];//tercer fila
                columna0 += matriz[i][0];//primer columna
                columna1 += matriz[i][1];//segunda columna
                columna2 += matriz[i][2];//tercer columna
                diagonalPrincipal += matriz[i][i];//diagonal principal
                diagonalInversa += matriz[i][3-j-1];//diagonal inversa
                if(fila1 == fila0 && fila2 == fila0 && columna0 == fila0 && columna1 == fila0 && columna2 == fila0 && diagonalPrincipal == fila0 && diagonalInversa == fila0){//si todo es igual, entonces true
                    magico = true;
                } 
            }
        }
        System.out.println("¿Es matriz mágica:? "+magico);
    }
}
