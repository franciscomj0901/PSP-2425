package Bloque3.Actividad3_2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        String servidor = "localhost";
        int puerto = 6000;

        Socket cliente = new Socket(servidor,puerto);
        InetAddress i=cliente.getInetAddress();

        System.out.println("PUERTO LOCAL: "+cliente.getLocalPort());
        System.out.println("PUERTOS REMOTOS: "+cliente.getPort());
        System.out.println("DIRECCIÓN IP SERVIDOR: "+i.getHostAddress().toString());

        cliente.close();
    }
}
