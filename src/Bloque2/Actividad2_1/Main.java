package Bloque2.Actividad2_1;
    /* Esta clase instancia 2 hilos pasándole a cada uno por parámetros una palabra la cuál se
    imprimirá infinitamente al iniciar el hilos. El objetivo es que se imprima por pantalla la
     sucesión "TIC TAC" infinitamente y ver si aparece de manera ordenada o no, en este caso
     no aparece de forma ordenada ya que los hilos no se ejecutan en el orden que se instancian*/
public class Main {
    public static void main(String[] args) {
        Hilos h1 = new Hilos("TIC");
        Hilos h2 = new Hilos("TAC");

        h1.start();
        h2.start();

    }
}
