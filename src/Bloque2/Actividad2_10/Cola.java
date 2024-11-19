package Bloque2.Actividad2_10;

public class Cola {
    /* Esta clase simula una Cola, con un método get() que devuelve la cadena que hay en
     la cola y un método put() que inserta una cadena a la cola. Tiene también una variable
     que indica si hay o no una cadena en la cola para obtener.
     Los métodos get() y put() son métodos sincronizados, de manera que en el get(), mientras que no haya nada disponible en la cola,
     el hilo que ejecute ese método estará esperando hasta recibir un notify() y así devolver el valor de la cola.
     En el método put(), si hay una cadena en la cola, el hilo que ejecute ese método esperará hasta que la cola esté vacía y se
     indique mediante un notify() en el get(). Una vez no haya nada en la cola, escribirá el valor leido por parámetros y enviará un notify()
     para indicar que la cola vuelve a estar llena*/

    private String cadena;
    private boolean disponible=false;

    public synchronized String get(){
        while (!disponible){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        disponible=false;
        notify();
        return cadena;
    }

    public synchronized void put(String valor){
        while (disponible){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        cadena=valor;
        disponible=true;
        notifyAll();
    }
}
