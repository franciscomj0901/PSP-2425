package Bloque2.Actividad2_7;

public class HiloContador_Runnable implements Runnable {
    /* Clase que implementa Runnable e incrementa un contador recibido por parámetros.
        Se incrementa siempre que el valor de este contador no sea 5000 y se incrementa con acceso sincronizado */

    private ContadorCompartido contador;
    private String nombre;


    public HiloContador_Runnable(String nombre, ContadorCompartido contador) {
        this.nombre = nombre;
        this.contador = contador;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        while (true) {
            // Sincronizar acceso al contador
            synchronized (contador) {
                if (contador.getValor() < 5000) {
                    contador.incrementar();
                    System.out.println(getNombre() + ": " + contador.getValor());
                } else {
                    System.out.println(getNombre() + " finalizado");
                    break;
                }
            }
        }
    }


}
