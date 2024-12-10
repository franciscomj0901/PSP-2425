package Bloque3.Actividad3_4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    /* Clase servidor que lee desde el cliente un número entero
    y mediante el uso de Math.pow(), devuelve al cliente el cuadrado de dicho número. */

    public static void main(String[] args) throws IOException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        Socket cliente = null;
        System.out.println("Esperando al cliente...");
        cliente = servidor.accept();

        System.out.println("Cliente encontrado");


        System.out.print("LEYENDO DEL CLIENTE: ");
        InputStream entrada = cliente.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        int num=flujoEntrada.readInt();
        System.out.println(num);

        int cuadrado = (int) Math.pow(num, 2);

        System.out.println("ESCRIBIENDO EN EL CLIENTE: "+cuadrado);
        OutputStream salida = cliente.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);
        flujoSalida.writeInt(cuadrado);



        entrada.close();
        flujoEntrada.close();
        salida.close();
        flujoSalida.close();
        cliente.close();
        servidor.close();
    }
}
