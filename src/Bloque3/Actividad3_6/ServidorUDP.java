package Bloque3.Actividad3_6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServidorUDP {
    /* Clase servidor que espera hasta que recibe un datagrama UDP, el cual
    lee y devuelve al cliente en mayúsculas. Esto se realiza en bucle hasta que
    la cadena obtenida es '*', entonces se cierra el socket de conexión.
     */

    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket(12345);

        System.out.println("Servidor Esperando Datagrama...");
        DatagramPacket recibo;

        byte[] buffer=new byte[1024];
        recibo=new DatagramPacket(buffer,buffer.length);
        socket.receive(recibo);

        String mensaje=new String(recibo.getData()).trim();
        System.out.println("Mensaje recibido: "+mensaje);



        while (!mensaje.equals("*")){
            InetAddress IPOrigen=recibo.getAddress();
            int puerto=recibo.getPort();

            System.out.println("Enviando mensaje en mayúsculas: "+mensaje.toUpperCase());
            byte[] enviado=new byte[1024];
            enviado=mensaje.toUpperCase().getBytes();

            DatagramPacket envio = new DatagramPacket(enviado, enviado.length, IPOrigen, puerto);
            socket.send(envio);

            System.out.println("Servidor Esperando Datagrama...");

            buffer=null;
            buffer=new byte[1024];
            recibo=new DatagramPacket(buffer,buffer.length);
            socket.receive(recibo);


            mensaje=new String(recibo.getData()).trim();
            System.out.println("Mensaje recibido: "+mensaje);
        }

        socket.close();
    }
}
