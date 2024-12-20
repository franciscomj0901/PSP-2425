package Bloque3.Actividad3_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    /* Clase Cliente que recibe una cadena desde el servidor y que devuelve al servidor
    en minúsculas con el uso del método toLoweCase(). */

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;

        System.out.println("PROGRAMA CLIENTE INICIADO");
        Socket Cliente = new Socket(host, puerto);

        System.out.print("LEYENDO DESDE EL SERVIDOR: ");
        DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
        String cadena = flujoEntrada.readUTF();
        System.out.println(cadena);

        cadena=cadena.toLowerCase();

        System.out.print("MANDANDO MENSAJE AL SERVIDOR: ");
        System.out.println(cadena);
        DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
        flujoSalida.writeUTF(cadena);


        flujoEntrada.close();
        flujoSalida.close();
        Cliente.close();


    }
}
