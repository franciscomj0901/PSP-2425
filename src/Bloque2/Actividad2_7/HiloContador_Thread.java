package Bloque2.Actividad2_7;

public class HiloContador_Thread extends Thread {
    /* Clase que extiende de Thread e incrementa un contador recibido por parámetros.
        Se incrementa siempre que el valor de este contador no sea 5000 y se incrementa con acceso sincronizado */

    private ContadorCompartido contador;

    public HiloContador_Thread(String nombre, ContadorCompartido contador) {
        super(nombre);
        this.contador = contador;
    }

    @Override
    public void run() {
        while (true) {
            // Sincronizar acceso al contador
            synchronized (contador) {
                if (contador.getValor() < 5000) {
                    contador.incrementar();
                    System.out.println(getName() + ": " + contador.getValor());
                } else {
                    System.out.println(getName() + " finalizado");
                    break;
                }
            }
        }
    }
}
