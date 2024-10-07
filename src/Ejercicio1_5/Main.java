/* Este programa ejecuta un proceso el cuál lee un fichero de texto y lo imprime por pantalla.
   También toma el mismo fichero de entrada y escribe salida a otro fichero */

package Ejercicio1_5;

import java.io.*;

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
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT); /* Redirige la salida a la consola */
        pb.redirectError(ProcessBuilder.Redirect.to(errores)); /* Redirige los errores para que sea al archivo "errores.txt", asociado al objeto File "errores" */

        try {
            Process proceso = pb.start(); /* Inicia el proceso */

            int exitCode = proceso.waitFor(); /* Espera que el proceso termine y captura el código de salida mediante el método waitFor(). Luego lo imprime */
            System.out.println("Proceso finalizado con código de salida: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        try(BufferedReader br = new BufferedReader(new FileReader(entrada)); BufferedWriter bw = new BufferedWriter(new FileWriter(salida))){
            /* Abro el archivo de entrada para leerlo y el archivo de salida para escribir la salida  */
            String texto;
            while ((texto = br.readLine()) != null) {  /* Mientras que la línea que lee con el método readLine del BufferedReader no sea nula sigue ejecutando */
                bw.write(texto+"\n"); /* Escribe la línea leída */
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
