package Bloque3.Actividad3_10.borrar;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorAdivina {
    public static void main(String args[]) throws IOException {
        ServerSocket servidor = new ServerSocket(6001);
        System.out.println("Servidor iniciado...");

        int numero = (int) (1 + 25 * Math.random());
        System.out.println("NUMERO A ADIVINAR=> " + numero);

        ObjetoCompartido objeto = new ObjetoCompartido(numero);

        int id = 0;

        while (true) {
            Socket cliente = new Socket();

            cliente = servidor.accept(); // esperando cliente

            id++; // identificador para el cliente

            HiloServidorAdivina hilo = new HiloServidorAdivina(cliente, objeto, id);

            hilo.start();
        }
    }
}
