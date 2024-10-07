/* Este programa lee un fichero de texto y lo devuelve por pantalla */

package Ejercicio1_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EjemploLectura {
    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        /* Inicializa un InputStreamReader y un BufferedReader que toma como entrada el InputStreamReader */

        String texto; /*Instancia un String llamado texto */
        try{
            System.out.println("Introduce una cadena... ");
            while ((texto = br.readLine()) != null) {  /* Mientras que la línea que lee con el método readLine del BufferedReader no sea nula sigue ejecutando */
                System.out.println(texto); /* Imprime la línea leída */
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
