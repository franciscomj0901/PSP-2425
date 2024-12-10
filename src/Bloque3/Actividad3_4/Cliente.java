package Bloque3.Actividad3_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    /* Clase cliente que envía al servidor un número entero y que lee su cuadrado,
    el cual es enviado desde el servidor.*/

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;

        System.out.println("PROGRAMA CLIENTE INICIADO");
        Socket Cliente = new Socket(host, puerto);

        System.out.print("Introduce un número: ");
        int num = new Scanner(System.in).nextInt();

        System.out.print("MANDANDO NÚMERO AL SERVIDOR: ");
        System.out.println(num);
        DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
        flujoSalida.writeInt(num);


        System.out.print("LEYENDO DESDE EL SERVIDOR: ");
        DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
        int cuadrado = flujoEntrada.readInt();
        System.out.println(cuadrado);

        flujoSalida.close();
        flujoEntrada.close();
        Cliente.close();


    }
}
