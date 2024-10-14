package Bloque2.Actividad2_2;
/* Esta clase crea un bucle que crea 1 hilo y lo inicia, su ejecución se hará 5 veces por lo que
creará 5 hilos diferentes */

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Hilo()).start();
        }
    }
}
