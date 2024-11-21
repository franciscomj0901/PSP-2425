/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bloque2.Actividad2_11.segundaParte;

/**
 *
 * @author antonioj
 */
import java.util.Observable;

public class Caballo extends Observable implements Runnable {

    private String nombre;
    private static String turno = ""; // Almacena el caballo que tiene el turno

    public Caballo(String nombre) {
        this.nombre = nombre;
        this.turno = String.valueOf(generaNumeroAleatorio(1, 4));

    }

    public String getNombre() {
        return nombre;
    }


    @Override
    public void run() {
        int porcentaje = 0;
        int numAleatorio;
        try {
            while (true) { // Cada caballo sigue corriendo hasta llegar al 100%
                synchronized (Caballo.class) {
                    while (!turno.equals(nombre)) {
                        Caballo.class.wait(); // Espera hasta que sea su turno
                    }
                    if (porcentaje < 100) {
                        // Incremento del porcentaje
                        numAleatorio = generaNumeroAleatorio(1, 15);
                        System.out.println("Caballo " + nombre + " ha aumentado en " + numAleatorio);
                        porcentaje += numAleatorio;

                        // Notifica el avance
                        this.setChanged();
                        this.notifyObservers(porcentaje);
                        this.clearChanged();
                        Thread.sleep(1000);

                    }
                    // Cambia el turno aleatoriamente
                    turno = String.valueOf(generaNumeroAleatorio(1, 4));
                    Caballo.class.notifyAll(); // Notifica a los otros hilos

                }

                // Simula un tiempo de espera antes del próximo turno
            }

            // Cuando el caballo llega al 100%, sale del ciclo
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido: " + nombre);
        }
    }

    public static int generaNumeroAleatorio(int minimo, int maximo) {
        return (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
    }
}

