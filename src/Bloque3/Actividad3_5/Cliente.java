package Bloque3.Actividad3_5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    /*Clase cliente que se conecta al servidor y recibe desde él el número de cliente
    asignado por el servidor */
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;

        System.out.println("PROGRAMA CLIENTE INICIADO");
        Socket Cliente = new Socket(host, puerto);


        System.out.print("LEYENDO DESDE EL SERVIDOR: ");
        DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
        int numeroCliente = flujoEntrada.readInt();
        System.out.println("Número de cliente asignado: " + numeroCliente);

        flujoEntrada.close();
        Cliente.close();


    }
}
