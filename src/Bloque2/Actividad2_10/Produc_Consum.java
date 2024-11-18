package Bloque2.Actividad2_10;

public class Produc_Consum {
    public static void main(String[] args) {
        /* Esta clase instancia un objeto Cola, uno Productor y uno Consumidor.
           Para el Productor y el Consumidor les asigna la misma cola.
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
