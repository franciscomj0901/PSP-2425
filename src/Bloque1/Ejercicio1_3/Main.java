/* Este programa ejecuta un proceso que realiza a suma entre dos números e imprime por pantalla
   su resultado */

package Bloque1.Ejercicio1_3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        File directorio = new File("out/production/PSP-2425");
        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio1_3.EjecutarSuma");
        pb.directory(directorio);
        Process p=pb.start();
        /*Creamos un proceso que ejecute el programa EjecutarSuma el cuál ejecutará la suma entre 2 números*/


        OutputStream os = p.getOutputStream();
        os.write("10\n".getBytes());
        os.write("16\n".getBytes());
        os.flush();
        /*El programa EjecutarSuma recibe 2 números que pide por pantalla por lo que se los pasaremos mediante un
        OutputStream el cuál tiene un método llamado write() que nos permite pasar parámetros al proceso que estamos ejecutando
        Utilizamos el método flush() después de pasar ambos números para asegurarnos de que los escribe*/

        InputStream is=p.getInputStream();
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
        is.close();
        os.close();

        /*Leemos la salida del proceso, en este caso, el resultado de la suma si se ha introducido dos números, y un mensaje de error
        si se ha introducido algún carácter no numérico. La lectura la realizamos mediante un InputStream que va leyendo carácter a carácter
        e imprimiéndolos por pantalla hasta que no haya más*/
    }
}
