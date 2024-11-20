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
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Caballo extends Observable implements Runnable {

    private String nombre;

    private ArrayList<String> posiciones; // lista compartido

    public Caballo(String nombre, ArrayList<String> posiciones) {
        this.nombre = nombre;
        this.posiciones = posiciones;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        int porcentaje = 0;
        try {
            while (porcentaje < 100) {
                int numAleatorio = generaNumeroAleatorio(1, 15);
                porcentaje += numAleatorio;


                System.out.println("Caballo " + nombre + " ha aumentado en " + numAleatorio);

                // Notificar el progreso
                this.setChanged();
                this.notifyObservers(porcentaje);
                this.clearChanged();

                Thread.sleep(100);  // Simula el tiempo de progreso
            }

            // Registrar la posición final
            synchronized (posiciones) {
                posiciones.add(nombre);
            }

        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido: " + nombre);
        }
    }

    public static int generaNumeroAleatorio(int minimo, int maximo) {
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }

}

