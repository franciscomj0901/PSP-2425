package Bloque3.Actividad3_7;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        /* Clase Cliente que se conecta a un servidor mediante sockets, envía objetos de tipo Numeros
          y recibe los resultados procesados (cuadrado y cubo del número). El programa se ejecuta en
          un bucle hasta que se introduce un número no mayor a 0, momento en el que finaliza la comunicación. */

        try{
            String Host = "localhost";
            int Puerto = 6000;

            System.out.println("Programa cliente iniciado...");
            Socket cliente = new Socket(Host, Puerto);

            ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());

            System.out.print("Introduce un número mayor que 0: ");
            int num=new Scanner(System.in).nextInt();

            while (num>0){
                Numeros n = new Numeros(num, 0, 0);

                out.writeObject(n);

                n = (Numeros) in.readObject();
                System.out.println("Número: "+n.getNumero());
                System.out.println("Cuadrado: "+n.getCuadrado());
                System.out.println("Cubo: "+n.getCubo());

                System.out.print("Introduce un número mayor que 0: ");
                num=new Scanner(System.in).nextInt();
            }

            out.writeObject(new Numeros(num, 0, 0));

            System.out.println("Programa finalizado.");

            out.close();
            in.close();
            cliente.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
