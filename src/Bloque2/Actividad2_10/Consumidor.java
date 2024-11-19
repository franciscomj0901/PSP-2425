package Bloque2.Actividad2_10;

public class Consumidor extends Thread{
    /* Esta clase extiende de Thread, recibe un número n por parámetros y un objeto cola
       en el cuál en su método run() obtiene números de la cola y los muestra en pantalla,
       si no hay ningun objeto en la cola, muestra -1 */
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
