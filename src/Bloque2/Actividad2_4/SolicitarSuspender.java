package Bloque2.Actividad2_4;

public class SolicitarSuspender {
    /* Esta clase contiene un booleano que si su valor es true y se ejecuta el método esperandoParaSuspender()
    ejecuta un wait que espera a que su valor vuelva a ser false y se realize un notify() o un notifyAll() */

    private boolean suspender;

    public synchronized void set(boolean b){
        suspender = b;
        notifyAll();
    }

    public synchronized boolean get(){
        return suspender;
    }

    public synchronized void esperandoParaSuspender() throws InterruptedException {
        while(suspender){
            wait();
        }
    }
}
