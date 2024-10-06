package Ejercicio1_5;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File directorio = new File("out/production/PSP-2425");

        /* Crea un ProcessBuilder para ejecutar el programa Ejercicio1_5.EjemploLectura */
        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio1_5.EjemploLectura");

        /* Establece el directorio del proceso, donde se encuentra la clase */
        pb.directory(directorio);


        /* Archivos a los que se va a redirigir la salida estándar y los errores */
        File salida = new File("src/Ejercicio1_5/salida.txt"); /* Archivo que guardará salida */
        File errores = new File("src/Ejercicio1_5/errores.txt"); /* Archivo que guardará los errores */

        File entrada = new File("src/Ejercicio1_5/Ejercicio1_5.txt"); /* Archivo de texto el cuál leera el programa */


        pb.redirectInput(ProcessBuilder.Redirect.from(entrada)); /* Redirige la entrada para que sea desde archivo "Ejercicio1_5.txt", asociado al objeto File "entrada" */
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(salida)); /* Redirige la salida para que sea al archivo "salida.txt", asociado al objeto File "salida" */
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT); /* Redirige la salida a la misma que la clase que está ejecutando el proceso, es decir, la consola */
        pb.redirectError(ProcessBuilder.Redirect.to(errores)); /* Redirige los errores para que sea al archivo "errores.txt", asociado al objeto File "errores" */

        try {
            Process proceso = pb.start(); /* Inicia el proceso */

            int exitCode = proceso.waitFor(); /* Espera que el proceso termine y captura el código de salida mediante el método waitFor(). Luego lo imprime */
            System.out.println("Proceso finalizado con código de salida: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
