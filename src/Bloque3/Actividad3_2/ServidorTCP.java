package Bloque3.Actividad3_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    /* Clase servidor que permite conectarse a dos clientes y que muestra el puerto
        local y remoto de cada uno */

    public static void main(String[] args) throws IOException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Servidor escuchando en puerto "+servidor.getLocalPort());

        Socket cliente1 = servidor.accept();
        System.out.println("PUERTO LOCAL CLIENTE 1: "+cliente1.getLocalPort());
        System.out.println("PUERTO REMOTO CLIENTE 1: "+cliente1.getPort());

        Socket cliente2 = servidor.accept();
        System.out.println("PUERTO LOCAL CLIENTE 2: "+cliente2.getLocalPort());
        System.out.println("PUERTO REMOTO CLIENTE 2: "+cliente2.getPort());


        servidor.close();
    }
}
