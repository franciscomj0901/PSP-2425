package Bloque3.Actividad3_8.SegundaParte;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        /* Clase Cliente que se conecta a un servidor mediante datagramas UDP, envía objetos de tipo Numeros,
            recibe la respuesta con el cuadrado y cubo del número enviado, y continúa en un bucle hasta que se introduce
            un número no mayor a 0, momento en el que finaliza la comunicación. */

        try {
            String Host = "localhost";
            int Puerto = 6000;
            DatagramSocket socket = new DatagramSocket();

            System.out.println("Programa cliente iniciado...");

            Scanner scanner = new Scanner(System.in);

            System.out.print("Introduce un número mayor que 0: ");
            int num = scanner.nextInt();

            while (num > 0) {
                Numeros n = new Numeros(num, 0, 0);

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(n);
                byte[] datos = byteArrayOutputStream.toByteArray();

                DatagramPacket packet = new DatagramPacket(datos, datos.length, InetAddress.getByName(Host), Puerto);
                socket.send(packet);

                byte[] buffer = new byte[1024];
                DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                socket.receive(response);

                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(response.getData(), 0, response.getLength());
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                Numeros respuesta = (Numeros) objectInputStream.readObject();

                System.out.println("Número: " + respuesta.getNumero());
                System.out.println("Cuadrado: " + respuesta.getCuadrado());
                System.out.println("Cubo: " + respuesta.getCubo());

                System.out.print("Introduce un número mayor que 0: ");
                num = scanner.nextInt();
            }

            Numeros fin = new Numeros(0, 0, 0);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(fin);
            byte[] finDatos = byteArrayOutputStream.toByteArray();
            DatagramPacket finPacket = new DatagramPacket(finDatos, finDatos.length, InetAddress.getByName(Host), Puerto);
            socket.send(finPacket);

            System.out.println("Programa finalizado.");

            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}