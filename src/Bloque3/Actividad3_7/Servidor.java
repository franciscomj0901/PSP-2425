package Bloque3.Actividad3_7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        /* Clase Servidor que espera la conexión de un cliente mediante sockets, recibe objetos de tipo Numeros,
        calcula su cuadrado y cubo, y los envía de vuelta al cliente. El programa se ejecuta en un bucle
        hasta que el cliente envía un número no mayor a 0, momento en el que finaliza la comunicación. */
        try {
            int Puerto = 6000;

            ServerSocket servidor = new ServerSocket(Puerto);

            System.out.println("Esperando al cliente...");
            Socket cliente = servidor.accept();


            ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());

            System.out.println("Leyendo del cliente...");
            Numeros n = (Numeros) in.readObject();


            while (n.getNumero()>0){
                n.setCuadrado((long) Math.pow(n.getNumero(), 2));
                n.setCubo((long) Math.pow(n.getNumero(), 3));

                out.writeObject(n);

                System.out.println("OBJETO ENVIADO");
                System.out.println("Número: "+n.getNumero());
                System.out.println("Cuadrado: "+n.getCuadrado());
                System.out.println("Cubo: "+n.getCubo());

                System.out.println("Leyendo del cliente...");
                n = (Numeros) in.readObject();

            }

            System.out.println("Programa finalizado.");

            in.close();
            out.close();
            cliente.close();
            servidor.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
