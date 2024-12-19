package Bloque3.Actividad3_11;

import java.io.*;
import java.net.*;

public class HiloServidorChat extends Thread {
    DataInputStream fentrada;
    Socket socket = null;
    ComunHilos comun;

    public HiloServidorChat(Socket s, ComunHilos comun) {
        this.socket = s;
        this.comun = comun;
        try {
            // CREO FLUJO DE entrada para leer los mensajes
            fentrada = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("ERROR DE E/S");
            e.printStackTrace();
        }
        //..
    }
}
