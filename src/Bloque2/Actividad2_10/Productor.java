package Bloque2.Actividad2_10;

public class Productor extends Thread{
    /* Esta clase extiende de Thread, recibe un identificador n por parámetros y un objeto cola.
       En el método run() se inserta infinitamente en la cola la cadena "PING" o "PONG" según sea un número de iteración par o impar */

    private Cola cola;
    private int n;

    public Productor(Cola c, int n){
        this.cola = c;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 1; i > 0; i++) {
            if (i%2==0){
                cola.put("PONG");
            }else {
                cola.put("PING");
            }
            try {
                sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("FIN PRODUCTOR...");
    }
}
