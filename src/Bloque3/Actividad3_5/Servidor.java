package Bloque3.Actividad3_5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    /* Clase servidor al cual se le pasa por teclado el número
    de clientes que van a conectarse a él. El servidor permite conectarse
    a tantos clientes como se han introducido, asignandoles a cada uno un número
    identificativo, en este caso, el orden en el que han llegado */

    public static void main(String[] args) throws IOException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);

        System.out.print("Introduce el número de clientes que se van a conectar al servidor: ");
        int numeroClientes= new Scanner(System.in).nextInt();


        for (int i = 1; i <= numeroClientes ; i++) {
            Socket cliente = null;
            System.out.println("Esperando al cliente...");
            cliente = servidor.accept();
            System.out.println("Cliente encontrado");

            System.out.println("ASIGNANDO NÚMERO DE CLIENTE: "+i);
            OutputStream salida = cliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            flujoSalida.writeInt(i);

            salida.close();
            flujoSalida.close();
            cliente.close();
        }

        servidor.close();
    }
}
