package Bloque3.Actividad3_10;

import java.io.*;
import java.net.*;
import java.util.Random;

public class Servidor {

   /* Clase Servidor que crea un servidor TCP escuchando en el puerto 6000, que maneja las solicitudes de adivinación de un número.
    El servidor genera un número aleatorio entre 1 y 25 al iniciar. Luego, espera a que el cliente se conecte, y por cada intento
    de adivinación enviado por el cliente, el servidor responde indicando si el número es demasiado pequeño, demasiado grande o correcto.
    Si el cliente adivina el número, el servidor responde con un mensaje de felicitación indicando la cantidad de intentos que tomó.
    El servidor continúa esperando nuevas conexiones de clientes hasta que se cierre la aplicación. */

    public static void main(String[] args) {
        final int PORT = 6000;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor escuchando en el puerto " + PORT);

            // Generar un número aleatorio entre 1 y 25
            Random random = new Random();
            int numeroAdivinar = random.nextInt(25) + 1;
            System.out.println("Número a adivinar: " + numeroAdivinar);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado");

                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    int intentos = 0;
                    String entrada;
                    while ((entrada = in.readLine()) != null) {
                        int intento = Integer.parseInt(entrada);
                        intentos++;
                        System.out.println("Cliente intentó: " + intento);

                        if (intento < numeroAdivinar) {
                            out.println("Número demasiado pequeño");
                        } else if (intento > numeroAdivinar) {
                            out.println("Número demasiado grande");
                        } else {
                            out.println("¡Felicidades! Adivinaste en " + intentos + " intentos");
                            break;
                        }
                    }
                }
                clientSocket.close();
                System.out.println("Cliente desconectado");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

