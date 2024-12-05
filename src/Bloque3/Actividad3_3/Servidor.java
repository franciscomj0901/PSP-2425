package Bloque3.Actividad3_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
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


        System.out.println("LEYENDO DEL CLIENTE: ");
        InputStream entrada = cliente.getInputStream();
        DataInputStream flujoSalida = new DataOutputStream(salida);
        flujoSalida.writeUTF(cadena);

        salida.close();
        flujoSalida.close();
        cliente.close();
        servidor.close();
    }
}
