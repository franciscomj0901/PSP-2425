package Ejercicio1_3;

import java.io.*;
import java.util.Scanner;

public class EjecutarSuma {
    public static void main(String[] args) {
        int suma = 0;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Ingrese el primer numero");
            String input1 = br.readLine();
            int num1 = Integer.parseInt(input1);

            System.out.println("Ingrese el segundo numero");
            String input2 = br.readLine();
            int num2 = Integer.parseInt(input2);

            suma = num1 + num2;
            System.out.println("La suma de los numeros es: " + suma);
        } catch (NumberFormatException | IOException e) {
            System.out.println("El carácter introducido no es un número");
        }
    }
}
