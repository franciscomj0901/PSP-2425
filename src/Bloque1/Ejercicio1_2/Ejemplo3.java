/* Este programa ejecuta un proceso con un programa que no existe y muestra los errores por pantalla */

package Bloque1.Ejercicio1_2;

import java.io.*;


public class Ejemplo3 {
    public static void main(String[] args) throws IOException {
        File directorio = new File("out/production/PSP-FranciscoMejias");
        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio1_1.LeerNombr", "Me llamo Fran");
        /*Al ejecutar un programa que no existe, simplemente la ejecución no se realiza,
        no saltará ninguna excepción*/
        pb.directory(directorio);
        System.out.println("Directorio de trabajo: \n" + pb.directory());
        Process p = pb.start();

        /* Para ver los errores necesitamos crear un objeto InputStream que obtenga los errores mediante el método getErrorStream
        Con un bucle y un BufferedReader vamos imprimiendo por pantalla las líneas recogidas con el InputStream las cuáles nos indican
        que no se puede encontrar la clase "Ejercicio1_1.LeerNombr"*/
        try {
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String linea = null;
            while ((linea = brer.readLine()) != null) {
                System.out.print(("ERROR: " + linea + "\n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
