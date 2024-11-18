package Bloque2.Actividad2_8.Ejercicio11;

import Bloque2.Actividad2_8.Hilo;

public class Main {
    /* Esta clase inicializa un objeto árbitro y se lo asigna a 3 Jugadores (hilo) por su constructor. Luego inicia los 3 hilos */

    public static void main(String[] args) {
        Arbitro arbitro = new Arbitro(3);
        Jugador j1=new Jugador(1, arbitro);
        Jugador j2=new Jugador(2, arbitro);
        Jugador j3=new Jugador(3, arbitro);

        System.out.println("EMPIEZA LA PARTIDA");
        j1.start();
        j2.start();
        j3.start();
    }
}
