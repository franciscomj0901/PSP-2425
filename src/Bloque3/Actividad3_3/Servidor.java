package Bloque3.Actividad3_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    /* Clase servidor que envía una cadena a un cliente y recibe otra
    desde el cliente, el resultado obtenido es la cadena enviada
    en minúsculas */

    public static void main(String[] args) throws IOException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        Socket cliente = null;
        System.out.println("Esperando al cliente...");
        cliente = servidor.accept();

        System.out.println("Cliente encontrado");
        String cadena="MENSAJE EN MAYUSCULAS EN EL CLIENTE";

        System.out.println("ESCRIBIENDO EN EL CLIENTE: "+cadena);
        OutputStream salida = cliente.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);
        flujoSalida.writeUTF(cadena);


        System.out.print("LEYENDO DEL CLIENTE: ");
        InputStream entrada = cliente.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        System.out.printf(flujoEntrada.readUTF());

        salida.close();
        flujoSalida.close();
        entrada.close();
        flujoEntrada.close();
        cliente.close();
        servidor.close();
    }
}
