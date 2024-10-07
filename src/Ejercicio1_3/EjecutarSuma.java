/* Esta clase realiza la suma de dos números que obtiene mediante un BufferedReader e imprime por
   pantalla su resultado. */
package Ejercicio1_3;

import java.io.*;

public class EjecutarSuma {
    public static void main(String[] args) {
        /* Con el BufferedReader obtiene una cadena de texto que convierte en un entero
        mediante un cast con el método Integer.parseInt(). Si al hacer el cast salta una excepción que indica
        que no se ha introducido un número muestra un mensaje por pantalla, si no, continúa con la ejecución */

        int suma = 0;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Ingrese el primer numero");
            String input1 = br.readLine();
            int num1 = Integer.parseInt(input1);
            System.out.println("El primer número es: "+num1);

            System.out.println("Ingrese el segundo numero");
            String input2 = br.readLine();
            int num2 = Integer.parseInt(input2);
            System.out.println("El segundo número es: "+num2);


            suma = num1 + num2;
            System.out.println("La suma de los numeros es: " + suma);
        } catch (NumberFormatException | IOException e) {
            System.out.println("El carácter introducido no es un número");
        }
    }
}
