package Bloque2.Actividad2_10;

public class Consumidor extends Thread{
    /* Esta clase extiende de Thread, recibe un identificador n por parámetros y un objeto cola.
       En el método run() obtiene cadenas de la cola y las muestra en pantalla*/

    private Cola cola;
    private int n;

    public Consumidor(Cola c, int n){
        this.cola = c;
        this.n = n;
    }

    @Override
    public void run() {
        String valor = "";
        while (true) {
            valor = cola.get();
            System.out.println(valor);
        }
    }
}
