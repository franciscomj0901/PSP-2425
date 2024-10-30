package Bloque2.Actividad2_4;

public class MyHilo extends Thread{
    /* Esta clase extiende de Thread y su función es incrementar un contador de 1 en 1 cada 300 ms.
    En cada incremento del contador se llama al método esperandoParaSuspender de un objeto que hemos
    instanciado de la clase SolicitarSuspender que lo que comprueba es si el hilo se ha suspendido o no mediante
    los métodos Suspende() o Reanuda(). También posee un booleano que indica si se detiene el hilo o no. */


    private SolicitarSuspender suspender = new SolicitarSuspender();
    boolean stopHilo = false;
    Integer cont = 0;

    public void Suspende(){suspender.set(true);}

    public void Reanuda(){suspender.set(false);}

    public void Parar(){stopHilo = true;}

    public void run(){
        try {
            while (!suspender.get() && !stopHilo) {
                System.out.println(cont);
                cont++;
                Thread.sleep(300);
                suspender.esperandoParaSuspender();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCont(){return cont;}

}
