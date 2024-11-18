package Bloque2.Actividad2_7;

public class Main {
    public static void main(String[] args) {
        /* Esta clase instancia 10 hilos, 5 que extienden de thread y 5 que implementan la interfaz runnable.
        Cada grupo de hilos tiene un contador compartido sincronizado, el cuál incrementan mediante start o run respectivamente hasta llegar a 5000.
        Cómo podemos ver, el orden de ejecución no sigue un patrón al igual que los incrementos, cada hilo no incrementa 1000 veces
        el contador, podría darse el caso de que un hilo no incrementara el contador ni una sola vez ya que, no se incrementa de manera ordenada. */



        // Contador compartido entre los hilos
        ContadorCompartido contador_thread = new ContadorCompartido();

        // Crear y empezar los hilos
        HiloContador_Thread h1 = new HiloContador_Thread("Hilo 1", contador_thread);
        HiloContador_Thread h2 = new HiloContador_Thread("Hilo 2", contador_thread);
        HiloContador_Thread h3 = new HiloContador_Thread("Hilo 3", contador_thread);
        HiloContador_Thread h4 = new HiloContador_Thread("Hilo 4", contador_thread);
        HiloContador_Thread h5 = new HiloContador_Thread("Hilo 5", contador_thread);

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();


        // Contador compartido entre los hilos
        ContadorCompartido contador_runnable = new ContadorCompartido();

        // Crear y empezar los hilos
        HiloContador_Runnable h6 = new HiloContador_Runnable("Hilo 6", contador_runnable);
        HiloContador_Runnable h7 = new HiloContador_Runnable("Hilo 7", contador_runnable);
        HiloContador_Runnable h8 = new HiloContador_Runnable("Hilo 8", contador_runnable);
        HiloContador_Runnable h9 = new HiloContador_Runnable("Hilo 9", contador_runnable);
        HiloContador_Runnable h10 = new HiloContador_Runnable("Hilo 10", contador_runnable);

        h6.run();
        h7.run();
        h8.run();
        h9.run();
        h10.run();



<<<<<<< HEAD
=======
        //System.
>>>>>>> cc39d52baab4e4e67e83e0fd63afcfe06cb2ef36
    }
}
