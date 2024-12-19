package Bloque3.Actividad3_9;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        /* Clase Servidor que escucha en un puerto específico (44444) y acepta conexiones entrantes de clientes.
            Para cada cliente, se crea un nuevo hilo (ManejadorCliente) para gestionar la comunicación. */

        final int PUERTO = 44444;
        System.out.println("Servidor iniciado...");

        try (ServerSocket servidor = new ServerSocket(PUERTO)) {
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("=>Conecta IP " + cliente.getInetAddress() + ", Puerto remoto: " + cliente.getPort());
                new Thread(new ManejadorCliente(cliente)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
