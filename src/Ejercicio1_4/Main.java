/* Este programa ejecuta un proceso que lee un fichero y redirecciona la salida
   y los errores a dos archivos distintos usando redirectOutput y redirectError.
   El archivo de entrada del proceso también es redireccionado mediante redirectInput */

package Ejercicio1_4;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        File directorio = new File("out/production/PSP-2425");

        /* Crea un ProcessBuilder para ejecutar el programa Ejercicio1_4.EjemploLectura */
        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio1_4.EjemploLectura");

        /* Establece el directorio del proceso, donde se encuentra la clase */
        pb.directory(directorio);


        /* Archivos a los que se va a redirigir la salida estándar y los errores */
        File salida = new File("src/Ejercicio1_4/salida.txt"); /* Archivo que guardará salida */
        File errores = new File("src/Ejercicio1_4/errores.txt"); /* Archivo que guardará los errores */

        File entrada = new File("src/Ejercicio1_4/Ejercicio1_4.txt"); /* Archivo de texto el cuál leera el programa */


        pb.redirectInput(entrada); /* Redirige la entrada al archivo "Ejercicio1_4.txt", asociado al objeto File "salida" */
        pb.redirectOutput(salida); /* Redirige la salida al archivo "salida.txt", asociado al objeto File "salida" */
        pb.redirectError(errores); /* Redirige los errores al archivo "errores.txt", asociado al objeto File "errores" */

        try {
            Process proceso = pb.start(); /* Inicia el proceso */

            int exitCode = proceso.waitFor(); /* Espera que el proceso termine y captura el código de salida mediante el método waitFor(). Luego lo imprime */
            System.out.println("Proceso finalizado con código de salida: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
