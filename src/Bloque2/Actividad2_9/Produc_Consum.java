package Bloque2.Actividad2_9;

public class Produc_Consum {
    public static void main(String[] args) {
        /* Esta clase instancia un objeto Cola, uno Productor y uno Consumidor.
           Para el Productor y el Consumidor les asigna la misma cola.

           Al eliminar el sleep() del Productor tampoco obtenemos el resultado esperado,
           ya que los hilos se ejecutan en el procesador de forma independiente, no ordenada.

           Si añado ahora el sleep() al Consumidor, este consume más lento de lo que se produce
           por lo que solamente va a consumir el último número generado por el productor, es decir,
           el consumidor consume la última iteración del productor y el resto de veces que consume,
           consume -1, ya que no hay nada más que consumir.
         */

        Cola cola = new Cola();
        Productor p = new Productor(cola, 1);
        Consumidor c = new Consumidor(cola, 1);
        p.start();
        c.start();
    }
}
