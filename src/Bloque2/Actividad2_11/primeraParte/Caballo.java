/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bloque2.Actividad2_11.primeraParte;

/**
 *
 * @author antonioj
 */
import java.util.Observable;

public class Caballo extends Observable implements Runnable {

    private String nombre;

    public Caballo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {

        int porcentaje = 0;
        int numAleatorio;
        try {
            while (porcentaje < 100) {
                switch (getNombre()){
                    case "1":
                        numAleatorio = generaNumeroAleatorio(15, 20);
                        break;
                    case "2":
                        numAleatorio = generaNumeroAleatorio(10, 14);
                        break;
                    case "3":
                        numAleatorio = generaNumeroAleatorio(9, 5);
                        break;
                    case "4":
                        numAleatorio = generaNumeroAleatorio(4, 1);
                        break;
                    default:
                        numAleatorio = 1;
                }

                if (getNombre().equals("1")){
                }
                System.out.println("Caballo " + nombre + " ha aumentado en " + numAleatorio);
                porcentaje += numAleatorio;

                this.setChanged();
                this.notifyObservers(porcentaje);
                this.clearChanged();

                Thread.sleep(1000);

            }
        } catch (InterruptedException ex) {
            System.out.println("Hilo interrumpido");
        }

    }

    public static int generaNumeroAleatorio(int minimo, int maximo) {
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }

}

