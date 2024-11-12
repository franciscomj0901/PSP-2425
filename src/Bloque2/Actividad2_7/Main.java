package Bloque2.Actividad2_7;

public class Main {
    public static void main(String[] args) {
        HiloContador h1 = new HiloContador("Hilo 1");
        HiloContador h2 = new HiloContador("Hilo 2");
        HiloContador h3 = new HiloContador("Hilo 3");
        HiloContador h4 = new HiloContador("Hilo 4");
        HiloContador h5 = new HiloContador("Hilo 5");

        /* Atributo que se pasa por parametros y se ioncrementa, en el run se comprueba si es 5000*/

        for (int i = 0; i < 5000; i++) {
            h1.run();
            h2.run();
            h3.run();
            h4.run();
            h5.run();
        }
    }
}
