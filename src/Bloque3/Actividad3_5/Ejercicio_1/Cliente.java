package Bloque3.Actividad3_5.Ejercicio_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    /* Clase cliente que pide por teclado una cadena la cual le pasará al servidor y recibirá de él
    la longitud de dicha cadena. Esto se realizará hasta introducir la cadena '*', que entonces se
    cerrará la conexión con el servidor. */

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;



        System.out.println("PROGRAMA CLIENTE INICIADO");
        Socket Cliente = new Socket(host, puerto);

        DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
        DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());

        System.out.print("Introduce una cadena ('*' para parar): ");
        String cadena = new Scanner(System.in).nextLine();

        while (!cadena.equals("*")) {

            System.out.print("MANDANDO CADENA AL SERVIDOR: ");
            System.out.println(cadena);
            flujoSalida.writeUTF(cadena);

            System.out.print("LEYENDO DESDE EL SERVIDOR: ");
            int numCaracteres = flujoEntrada.readInt();
            System.out.println("La cadena enviada tiene "+numCaracteres+" caracteres");

            System.out.print("Introduce una cadena ('*' para parar): ");
            cadena = new Scanner(System.in).nextLine();
        }


        flujoSalida.close();
        flujoEntrada.close();
        Cliente.close();


    }
}
