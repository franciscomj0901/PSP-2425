package Bloque3.Actividad3_8.Ejercicio_3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {
    public static void main(String[] args) {
        /* Clase ServidorUDP que espera datagramas UDP con una solicitud de ID de alumno, busca el alumno correspondiente
            en una lista predefinida y envía la información del alumno al cliente. Si el alumno no se encuentra,
            envía un mensaje de error. El servidor sigue ejecutándose de manera indefinida. */

    try {
        DatagramSocket socket = new DatagramSocket(6000);

        Curso c1= new Curso("1", "1C");
        Curso c2= new Curso("2", "2B");
        Curso c3= new Curso("3", "1A");

        Alumno alumnos[]={
                new Alumno("1", "Juan", c1, 7),
                new Alumno("2", "Jose", c2, 5),
                new Alumno("3", "Manuela", c3, 9),
                new Alumno("4", "Pepe", c3, 8),
                new Alumno("5", "María", c2, 4)
        };

        System.out.println("SERVIDOR INICIADO, ESPERANDO DATAGRAMA...");
        while (true) {
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String idAlumnoSolicitado = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
            System.out.println("ID Alumno recibido: " + idAlumnoSolicitado);

            Alumno alumnoEncontrado = null;
            for (Alumno alumno : alumnos) {
                if (alumno.getIdalumno().equals(idAlumnoSolicitado)) {
                    alumnoEncontrado = alumno;
                    break;
                }
            }

            String respuesta;
            if (alumnoEncontrado != null) {
                respuesta = alumnoEncontrado.toString();
            } else {
                respuesta = "Alumno no encontrado";
            }

            byte[] sendData = respuesta.getBytes();
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            socket.send(sendPacket);

            System.out.println("Respuesta enviada: " + respuesta);
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }


    }
}
