package Bloque3.Actividad3_8.PrimeraParte;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    public static void main(String[] args) {
        try {
            DatagramSocket socket=new DatagramSocket(6000);

            System.out.println("Servidor Esperando Datagrama...");
            DatagramPacket recibo;

            byte[] buffer=new byte[1024];
            recibo=new DatagramPacket(buffer,buffer.length);
            socket.receive(recibo);

            ByteArrayInputStream bis = new ByteArrayInputStream(recibo.getData());
            ObjectInputStream in = new ObjectInputStream(bis);
            Persona pMod = (Persona) in.readObject();
            in.close();

            


        } catch (IOException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
