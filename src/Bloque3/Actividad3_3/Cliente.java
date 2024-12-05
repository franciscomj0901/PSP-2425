package Bloque3.Actividad3_3;

import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;

        System.out.println("PROGRAMA CLIENTE INICIADO");
        Socket Cliente = new Socket(host, puerto);


    }
}
