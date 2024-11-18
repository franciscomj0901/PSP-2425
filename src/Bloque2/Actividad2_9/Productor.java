package Bloque2.Actividad2_9;

public class Productor extends Thread{
    /* Esta clase extiende de Thread, recibe un número n por parámetros y un objeto cola
       en el cuál en su método run() inserta números en la cola y los muestra en pantalla */
    private Cola cola;
    private int n;

    public Productor(Cola c, int n){
        this.cola = c;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            cola.put(i);
            System.out.println(i + "=>Productor : "+n+", produce: "+i);
        }
    }
}
