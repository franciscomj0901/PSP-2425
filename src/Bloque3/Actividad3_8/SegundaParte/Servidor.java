package Bloque3.Actividad3_8.SegundaParte;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        /* Clase Servidor que espera la conexión de un cliente mediante datagramas UDP, recibe objetos de tipo Numeros,
            calcula el cuadrado y cubo del número recibido, y responde con el objeto modificado. El servidor sigue procesando
            hasta que recibe un número no mayor a 0, momento en el que termina la ejecución. */

        try {
            int Puerto = 6000;
            DatagramSocket socket = new DatagramSocket(Puerto);

            System.out.println("Esperando al cliente...");

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                socket.receive(packet);

                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packet.getData(), 0, packet.getLength());
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                Numeros n = (Numeros) objectInputStream.readObject();

                if (n.getNumero() <= 0) {
                    System.out.println("Programa finalizado por el cliente.");
                    break;
                }

                n.setCuadrado((long) Math.pow(n.getNumero(), 2));
                n.setCubo((long) Math.pow(n.getNumero(), 3));

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(n);
                byte[] respuestaDatos = byteArrayOutputStream.toByteArray();

                DatagramPacket responsePacket = new DatagramPacket(respuestaDatos, respuestaDatos.length, packet.getAddress(), packet.getPort());
                socket.send(responsePacket);

                System.out.println("Número: " + n.getNumero());
                System.out.println("Cuadrado: " + n.getCuadrado());
                System.out.println("Cubo: " + n.getCubo());
            }

            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
