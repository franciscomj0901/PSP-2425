package Bloque3.Actividad3_10.borrar;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class JugadorAdivina {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String Host = "localhost";
        int Puerto = 6001; // puerto remoto
        Socket Cliente = new Socket(Host, Puerto);

        ObjectOutputStream fsalida = new ObjectOutputStream(Cliente.getOutputStream());
        ObjectInputStream fentrada = new ObjectInputStream(Cliente.getInputStream());

        // FLUJO PARA ENTRADA ESTANDAR
        Scanner sc = new Scanner(System.in);
        String cadena = "";

        // OBTENER PRIMER OBJETO ENVIADO POR EL SERVIDOR
        Datos datos = (Datos) fentrada.readObject();
        int identificador = datos.getIdentificador();
        System.out.println("Id jugador: " + identificador);
        System.out.println(datos.getCadena());

        if (!datos.isJuega()) {
            cadena = "*";
        }

        while (datos.isJuega() && !cadena.trim().equals("*")) {
            System.out.print("Intento: " + (datos.getIntentos() + 1) + " => Introduce número: ");
            cadena = sc.nextLine();
            Datos d = new Datos();

            if (!validarCadena(cadena)) {
                continue; // comprobar si es no
            }

            d.setCadena(cadena);

            // ENVIAR DATOS AL SERVIDOR, el número leído por teclado
            fsalida.reset();
            fsalida.writeObject(d);

            // RECIBIR DATOS DEL SERVIDOR
            datos = (Datos) fentrada.readObject();
            System.out.println("\t" + datos.getCadena());

            if (datos.getIntentos() >= 5) {
                System.out.println("\t<<JUEGO FINALIZADO, NO HAY MÁS} INTENTOS>>");
                cadena = "*";
            }
            if (datos.isGana()) {
                System.out.println("<<HAS GANADO!! EL JUEGO HA TERMINADO >> ");
                cadena = " * ";
            } else if (!(datos.isJuega())) {
                System.out.println("<<EL JUEGO HA TERMINADO, HAN ADIVINADO EL NUMERO >> ");
                cadena = "*";
            }

        }//fin while
        fsalida.close();
        fentrada.close();
        System.out.println("Fin de proceso...");
        sc.close();
        Cliente.close();
    }//main

    private static boolean validarCadena(String cadena) {
        //comprueba si la cadena es numérica
        boolean valor = false;
        try {
            Integer.parseInt(cadena);
            valor = true;
        } catch (NumberFormatException e) {
        }
        return valor;
    }//validarCadena
}//JugadorAdivina..
