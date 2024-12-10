package Bloque3.Actividad3_6;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClienteUDP {
    /* Clase cliente que envía datagramas UDP con una cadena obtenida por teclado
    al servidor y este le devuelve la cadena en mayúsculas. Esto se realiza en bucle
    hasta que se introduce un '*', entonces el cliente envia la cadena y cierra el socket.
    También se ha establecido un tiempo de 5000 ms en los que el socket espera la respuesta del servidor,
    si no se obtiene respuesta, se muestra un mensaje en pantalla mediante la captura de una excepción
    SocketTimeoutException. */

    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        clientSocket.setSoTimeout(5000);

        InetAddress IPServidor = InetAddress.getLocalHost();
        int puerto = 12345;

        System.out.print("Introduce una cadena: ");
        String cadena = entrada.nextLine();

        while (!cadena.equals("*")) {
            byte[] enviados = new byte[1024];
            enviados = cadena.getBytes();

            DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
            clientSocket.send(envio);

            byte[] recibo = new byte[1024];
            DatagramPacket recibido = new DatagramPacket(recibo, recibo.length);
            System.out.println("Esperando datagrama...");
            try {
                clientSocket.receive(recibido);

                String mensaje = new String(recibido.getData()).trim();
                System.out.println("Cadena en mayúsculas: " + mensaje);
            } catch (SocketTimeoutException e) {
                System.out.println("Tiempo de espera agotado. El paquete se ha perdido.");
            }

            System.out.print("Introduce una cadena: ");
            cadena = entrada.nextLine();
        }

        byte[] enviados = new byte[1024];
        enviados = cadena.getBytes();

        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
        clientSocket.send(envio);

        clientSocket.close();
    }

}
