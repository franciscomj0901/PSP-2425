package Bloque3.Actividad3_5.Ejercicio_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    /* Clase servidor que lee una cadena desde el cliente y que con el uso del método
    length(), devuelve al cliente la longitud de dicha cadena. Esto se realiza cíclicamente
    hasta que el cliente introduce la cadena '*', es entonces cuando se cierra la conexión */
    public static void main(String[] args) throws IOException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        Socket cliente = null;
        System.out.println("Esperando al cliente...");
        cliente = servidor.accept();

        System.out.println("Cliente encontrado");

        InputStream entrada = cliente.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);

        OutputStream salida = cliente.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);

        boolean continuar = true;

        while (continuar) {
            try {
                System.out.print("LEYENDO DEL CLIENTE: ");
                String cadena = flujoEntrada.readUTF(); // Leer la cadena enviada por el cliente
                System.out.println(cadena);

                // Verificar si la cadena es "*"
                if (cadena.equals("*")) {
                    System.out.println("El cliente ha solicitado terminar la conexión.");
                    continuar = false; // Salir del bucle estableciendo la variable a false
                } else {
                    // Enviar la longitud de la cadena al cliente
                    System.out.println("ESCRIBIENDO EN EL CLIENTE: " + cadena.length());
                    flujoSalida.writeInt(cadena.length());
                }
            } catch (EOFException e) {
                System.out.println("El cliente cerró la conexión.");
                continuar = false; // Salir del bucle estableciendo la variable a false
            }
        }

        entrada.close();
        flujoEntrada.close();
        salida.close();
        flujoSalida.close();
        cliente.close();
        servidor.close();

        System.out.println("Servidor cerrado.");
    }
}