package Bloque2.Actividad2_2.Ejercicio2;
/* Esta clase crea e inicia 5 hilos pasándole una palabra por parámetros */

public class Main {
    public static void main(String[] args) {
        new Thread(new Hilo("Uno")).start();
        new Thread(new Hilo("Dos")).start();
        new Thread(new Hilo("Tres")).start();
        new Thread(new Hilo("Cuatro")).start();
        new Thread(new Hilo("Cinco")).start();

    }
}
