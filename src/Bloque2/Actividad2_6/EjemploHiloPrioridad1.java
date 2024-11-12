package Bloque2.Actividad2_6;

/* En esta clase se instancian 3 hilos a los cuales se les asigna una prioridad
   e incrementan un contador, luego de 10000 ms se muestra su contador en pantalla.
   El orden de ejecución lo hacemos inversamente, es decir, de menor a mayor prioridad.
   Como podemos observar si ejecutamos el programa, el establecer prioridades con tan pocos
   hilos no sirve, no se respetan las prioridades, esto es debido a que los procesadores
   de hoy en día manejan cada hilo de manera independiente cuando hay tan pocos hilos en
   ejecución */

public class EjemploHiloPrioridad1 {
    public static void main(String[] args) {
        HiloPrioridad1 h1 = new HiloPrioridad1("Hilo 1");
        HiloPrioridad1 h2 = new HiloPrioridad1("Hilo 2");
        HiloPrioridad1 h3 = new HiloPrioridad1("Hilo 3");

        h1.setPriority(Thread.MAX_PRIORITY);
        h2.setPriority(Thread.MIN_PRIORITY);
        h3.setPriority(Thread.NORM_PRIORITY);

        h2.start();
        h3.start();
        h1.start();


        try {
            Thread.sleep(10000);
        } catch (Exception e) {}

        h2.pararHilo();
        h3.pararHilo();
        h1.pararHilo();


        System.out.println("h2 (Prioridad mínima): " + h2.getContador());
        System.out.println("h3 (Prioridad normal): " + h3.getContador());
        System.out.println("h1 (Prioridad máxima): "+ h1.getContador());


    }
}
