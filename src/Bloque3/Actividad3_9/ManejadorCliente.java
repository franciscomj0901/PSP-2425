package Bloque3.Actividad3_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejadorCliente implements Runnable {
    /* Clase ManejadorCliente que se ejecuta en un hilo para cada cliente conectado al servidor.
        Lee los mensajes enviados por el cliente, los convierte a mayúsculas y los envía de vuelta.
        Si recibe el mensaje "*", cierra la conexión con el cliente. */

    private Socket cliente;

    public ManejadorCliente(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try (
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true)
        ) {
            String mensaje;
            while ((mensaje = entrada.readLine()) != null) {
                if (mensaje.equals("*")) {
                    System.out.println("\t=>Desconecta IP " + cliente.getInetAddress() + ", Puerto remoto: " + cliente.getPort());
                    break;
                }
                salida.println(mensaje.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                cliente.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
