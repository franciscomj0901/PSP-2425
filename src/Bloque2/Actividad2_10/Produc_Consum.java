package Bloque2.Actividad2_10;

public class Produc_Consum {
    public static void main(String[] args) {
        /* Esta clase instancia un objeto Cola, un Productor y dos Consumidores.
           Para el Productor y los Consumidores se les asigna la misma cola.
           Los consumidores consumirán infinitamente solo que uno consumirá los "PING" y otro los "PONG".
           El productor producirá infinitamente los "PING" y los "PONG"
         */

        Cola cola = new Cola();
        Productor p = new Productor(cola, 1);
        Consumidor c1 = new Consumidor(cola, 1);
        Consumidor c2 = new Consumidor(cola, 2);

        p.start();
        c1.start();
        c2.start();
    }
}
