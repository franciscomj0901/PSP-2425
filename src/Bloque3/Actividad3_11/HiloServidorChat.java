package Bloque3.Actividad3_11;

import java.io.*;
import java.net.*;

public class HiloServidorChat extends Thread {
    /* La clase HiloServidorChat maneja la comunicación con un cliente en el servidor de chat.
     Cada hilo recibe los mensajes enviados por el cliente, los guarda en un objeto compartido
     y luego los distribuye a todos los clientes conectados. Si un cliente envía el mensaje "*",
     el hilo cierra la conexión con ese cliente. El hilo también controla el número de conexiones activas
     y asegura que los mensajes sean enviados correctamente a todos los demás clientes conectados.
*/

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
    }

    @Override
    public void run() {
        System.out.println("NÚMERO DE CONEXIONES ACTUALES: "+comun.getACTUALES());

        String texto = comun.getMensajes();
        EnviarMensajesaTodos(texto);

        while (true) {
            String cadena = "";
            try {
                cadena = fentrada.readUTF();
                if (cadena.trim().equals("*")) {
                    comun.setACTUALES(comun.getACTUALES() - 1);
                    System.out.println("NÚMERO DE CONEXIONES ACTUALES: "+comun.getACTUALES());
                    break;
                }
                comun.setMensajes(comun.getMensajes() + cadena + "\n");
                EnviarMensajesaTodos(comun.getMensajes());
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void EnviarMensajesaTodos(String texto) {
        int i;
        for (i = 0; i < comun.getCONEXIONES(); i++) {
            Socket s1 = comun.getElementoTabla(i);
            if (!s1.isClosed()){
                try {
                    DataOutputStream fsalida2 = new DataOutputStream(s1.getOutputStream());
                    fsalida2.writeUTF(texto);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
