package Bloque2.Actividad2_6;

/* En esta clase se instancian 5 hilos a los cuales se les asigna una prioridad
   e incrementan un contador 5 veces, en cada incremento se muestra el nombre del hilo y
   el valor de su contador.
   El orden de ejecución lo hacemos inversamente, es decir, de menor a mayor prioridad.
   Como podemos observar si ejecutamos el programa, el establecer prioridades con tan pocos
   hilos no sirve, no se respetan las prioridades, esto es debido a que los procesadores
   de hoy en día manejan cada hilo de manera independiente cuando hay tan pocos hilos en
   ejecución */

public class EjemploHiloPrioridad2 extends Thread {
    EjemploHiloPrioridad2(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        System.out.println("Ejecutando ["+getName()+"]");
        for (int i = 0; i < 5; i++) {
            System.out.println("\t("+getName()+": "+i+")");
        }
    }

    public static void main(String[] args) {
        EjemploHiloPrioridad2 h1 = new EjemploHiloPrioridad2("Uno");
        EjemploHiloPrioridad2 h2 = new EjemploHiloPrioridad2("Dos");
        EjemploHiloPrioridad2 h3 = new EjemploHiloPrioridad2("Tres");
        EjemploHiloPrioridad2 h4 = new EjemploHiloPrioridad2("Cuatro");
        EjemploHiloPrioridad2 h5 = new EjemploHiloPrioridad2("Cinco");

        h1.setPriority(Thread.MAX_PRIORITY);
        h2.setPriority(Thread.MIN_PRIORITY);
        h3.setPriority(Thread.NORM_PRIORITY);
        h4.setPriority(3);
        h5.setPriority(7);

        h2.start();
        h4.start();
        h3.start();
        h5.start();
        h1.start();

    }
}
