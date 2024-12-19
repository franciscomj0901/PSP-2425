package Bloque3.Actividad3_8.PrimeraParte;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            System.out.println("PROGRAMA CLIENTE INICIADO");
            DatagramSocket Cliente = new DatagramSocket();

            Persona p = new Persona("Javier", "Jota Ruiz", 20);

            System.out.print("ENVIANDO PERSONA AL SERVIDOR: ");
            System.out.println("Nombre: "+p.getNombre()+", Apellidos: "+p.getApellido()+", Edad: "+p.getEdad());
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bs);
            out.writeObject(p);
            out.close();
            byte[] bytes = bs.toByteArray();

            DatagramPacket paquete = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"), 6000);
            Cliente.send(paquete);

            byte[] recibo = new byte[1024];
            DatagramPacket recibido = new DatagramPacket(recibo, recibo.length);
            System.out.println("Esperando persona...");
            Cliente.receive(recibido);

            ByteArrayInputStream bis = new ByteArrayInputStream(recibo);
            ObjectInputStream in = new ObjectInputStream(bis);
            Persona pMod = (Persona) in.readObject();
            in.close();

            System.out.println("PERSONA MODIFICADA RECIBIDA");
            System.out.println("Nombre: "+pMod.getNombre()+", Apellidos: "+pMod.getApellido()+", Edad: "+pMod.getEdad());


            Cliente.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
