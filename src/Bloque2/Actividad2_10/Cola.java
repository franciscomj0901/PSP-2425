package Bloque2.Actividad2_10;

public class Cola {
    /* Esta clase simula una Cola, con un método get() que devuelve el número que hay en
     la cola y un método put() que inserta un número a la cola. Tiene también una variable
     que indica si hay o no un número en la cola para obtener, si no hay y se ejecuta el
     get(), devuelve -1 */
    private int numero;
    private boolean disponible=false;

    public synchronized int get(){
        while (!disponible){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        disponible=false;
        notify();
        return numero;
    }

    public synchronized void put(int valor){
        while (disponible){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        numero=valor;
        disponible=true;
        notifyAll();
    }
}