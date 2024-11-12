package Bloque2.Actividad2_7;

public class Main {
    public static void main(String[] args) {
        Integer contador = 0;
        HiloContador h1 = new HiloContador("Hilo 1",contador);
        HiloContador h2 = new HiloContador("Hilo 2",contador);
        HiloContador h3 = new HiloContador("Hilo 3",contador);
        HiloContador h4 = new HiloContador("Hilo 4",contador);
        HiloContador h5 = new HiloContador("Hilo 5",contador);

        /* Atributo que se pasa por parametros y se ioncrementa, en el run se comprueba si es 5000*/
        while (true) {
            h1.run(); h2.run(); h3.run(); h4.run(); h5.run();
        }

        System.
    }
}
