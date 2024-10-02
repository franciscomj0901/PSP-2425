package Ejercicio1_1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        File directorio = new File("out/production/PSP-FranciscoMejias"); /*Creo un objeto file con la ruta relativa de la carpeta que
        contiene el paquete de la clase a ejecutar*/

        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio1_1.LeerNombre", "Javi"); /* Creo un nuevo proceso al cuál le paso como parámetros
        java para indicar que es un programa java lo que se va a ejecutar, el nombre del paquete seguido del nombre de la clase y a continuación un parámetro
        que será la primera posición del array de Strings "Args" que le pasaremos a dicha clase*/

        pb.directory(directorio); /*Indico el directorio del proceso el cuál será el objeto File creado anteriormente*/

        Process p=pb.start(); /*Inicio el proceso*/


        try{
            /*Leo carácter a carácter la salida del programa que hemos ejecutado y a la misma vez lo voy imprimiendo por pantalla*/
            InputStream in=p.getInputStream();
            int c;
            while ((c=in.read())!=-1){
                System.out.print((char)c);
            }
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        int valorSalida;
        try {
            /*Recojo mediante el método WaitFor la salida del proceso, en este caso será el exit indicado en la clase LeerNombre*/
            valorSalida = p.waitFor();
            System.out.println("Valor de salida: " + valorSalida);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
