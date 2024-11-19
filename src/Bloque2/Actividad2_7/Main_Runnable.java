package Bloque2.Actividad2_7;

public class Main_Runnable {
    public static void main(String[] args) {
        /* Esta clase instancia 5 que implementan la interfaz runnable.
        Los 5 hilos tiene un contador compartido sincronizado, el cuál incrementan mediante run hasta llegar a 5000.
        Cómo podemos ver, el orden de ejecución no sigue un patrón al igual que los incrementos, cada hilo no incrementa 1000 veces
        el contador, podría darse el caso de que un hilo no incrementara el contador ni una sola vez ya que, no se incrementa de manera ordenada. */


        // Contador compartido entre los hilos
        ContadorCompartido contador_runnable = new ContadorCompartido();

        // Crear y empezar los hilos
        HiloContador_Runnable h1 = new HiloContador_Runnable("Hilo 1", contador_runnable);
        HiloContador_Runnable h2 = new HiloContador_Runnable("Hilo 2", contador_runnable);
        HiloContador_Runnable h3 = new HiloContador_Runnable("Hilo 3", contador_runnable);
        HiloContador_Runnable h4 = new HiloContador_Runnable("Hilo 4", contador_runnable);
        HiloContador_Runnable h5 = new HiloContador_Runnable("Hilo 5", contador_runnable);

        h1.run();
        h2.run();
        h3.run();
        h4.run();
        h5.run();

    }
}
