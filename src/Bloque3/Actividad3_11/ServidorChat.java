package Bloque3.Actividad3_11;

import java.io.*;
import java.net.*;

public class ServidorChat {
    /* Clase ServidorChat que implementa un servidor de chat TCP multicliente.
   El servidor escucha en el puerto 6000 y acepta hasta un máximo de 10 conexiones de clientes simultáneamente.
   Cada cliente conectado es gestionado por un hilo independiente que utiliza un objeto compartido (de tipo ComunHilos)
   para coordinar las conexiones activas y permitir la comunicación entre clientes. */

    static final int MAXIMO = 10; // MÁXIMO DE CONEXIONES PERMITIDAS

    public static void main(String args[]) throws IOException {
        int PUERTO = 6000;
        ServerSocket servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado...");

        Socket tabla[] = new Socket[MAXIMO]; // control clientes
        ComunHilos comun = new ComunHilos(MAXIMO, 0, 0, tabla);

        while (comun.getCONEXIONES() < MAXIMO) {
            Socket socket = new Socket();
            socket = servidor.accept(); // esperando cliente
            // OBJETO COMPARTIDO POR LOS HILOS
            comun.addTabla(socket, comun.getCONEXIONES());
            comun.setACTUALES(comun.getACTUALES() + 1);
            comun.setCONEXIONES(comun.getCONEXIONES() + 1);
            HiloServidorChat hilo = new HiloServidorChat(socket, comun);
            hilo.start();
        }
        servidor.close();
    } // main
} // ServidorChat..
