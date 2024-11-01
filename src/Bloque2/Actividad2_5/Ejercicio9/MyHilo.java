package Bloque2.Actividad2_5.Ejercicio9;

public class MyHilo extends Thread{
     /* Esta clase extiende de Thread y su función es incrementar un contador de 1 en 1 en un intervalo
    de tiempo introducido en su constructor, en el cuál también se introducirá su nombre.
    En cada incremento del contador se llama al método esperandoParaSuspender de un objeto que hemos
    instanciado de la clase SolicitarSuspender que lo que comprueba es si el hilo se ha suspendido o no mediante
    los métodos Suspende() o Reanuda(). También posee un booleano que indica si se detiene el hilo o no.
     Este hilo contiene un objeto Ventana la cuál ejecuta el método repaint() cada vez que se incrementa
     el valor del contador.*/

    int n;
    Ventana ventana;

    public MyHilo(String nombre, int n, Ventana ventana){
        super(nombre);
        this.ventana = ventana;
        this.n = n;
    }

    private SolicitarSuspender suspender = new SolicitarSuspender();
    boolean stopHilo = false;
    Integer cont = 0;

    public void Suspende(){suspender.set(true);}

    public void Reanuda(){suspender.set(false);}

    public void Parar(){stopHilo = true;}

    public void run(){
        try {
            while (!suspender.get() && !stopHilo) {
                cont++;
                ventana.repaint();
                Thread.sleep(n);
                suspender.esperandoParaSuspender();
            }
        } catch (InterruptedException e) {

        }
    }

    public int getCont(){return cont;}

}
