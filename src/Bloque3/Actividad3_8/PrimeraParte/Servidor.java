package Bloque3.Actividad3_8.PrimeraParte;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    public static void main(String[] args) {
        /* Clase Servidor que recibe un datagrama UDP con un objeto de tipo Persona, lo modifica y
            envía la versión modificada de vuelta al cliente. El servidor espera hasta recibir el datagrama,
            procesa el objeto y responde con el objeto modificado. */

        try {
            DatagramSocket socket=new DatagramSocket(6000);

            System.out.println("Servidor Esperando Datagrama...");
            DatagramPacket recibo;

            byte[] buffer=new byte[1024];
            recibo=new DatagramPacket(buffer,buffer.length);
            socket.receive(recibo);

            ByteArrayInputStream bis = new ByteArrayInputStream(recibo.getData());
            ObjectInputStream in = new ObjectInputStream(bis);
            Persona p = (Persona) in.readObject();
            in.close();

            System.out.println("PERSONA RECIBIDA: ");
            System.out.println("Nombre: "+p.getNombre()+", Apellidos: "+p.getApellido()+", Edad: "+p.getEdad());

            p.setNombre("Manuel");

            System.out.print("ENVIANDO PERSONA MODIFICADA AL CLIENTE: ");
            System.out.println("Nombre: "+p.getNombre()+", Apellidos: "+p.getApellido()+", Edad: "+p.getEdad());
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bs);
            out.writeObject(p);
            out.close();
            byte[] bytes = bs.toByteArray();


            InetAddress IPOrigen=recibo.getAddress();
            int puerto=recibo.getPort();

            DatagramPacket envio = new DatagramPacket(bytes, bytes.length, IPOrigen, puerto);
            socket.send(envio);

        } catch (IOException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
