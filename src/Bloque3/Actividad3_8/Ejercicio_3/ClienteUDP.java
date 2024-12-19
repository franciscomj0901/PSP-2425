package Bloque3.Actividad3_8.Ejercicio_3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) {
        /* Clase ClienteUDP que se conecta a un servidor mediante datagramas UDP, envía una solicitud con el ID de un alumno
            y recibe la información del alumno correspondiente. El cliente repite el proceso hasta que se ingresa '*' para salir. */

        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 6000;

            Scanner scanner = new Scanner(System.in);
            String idAlumno;

            while (true) {
                System.out.print("Ingrese el ID del alumno a consultar (* para salir): ");
                idAlumno = scanner.nextLine().trim();

                if (idAlumno.equals("*")) {
                    System.out.println("Saliendo del cliente...");
                    break;
                }

                byte[] sendData = idAlumno.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                socket.send(sendPacket);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String respuesta = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
                System.out.println("Respuesta del servidor: " + respuesta);
            }

            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
