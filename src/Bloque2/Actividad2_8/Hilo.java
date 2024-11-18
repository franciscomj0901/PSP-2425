package Bloque2.Actividad2_8;

public class Hilo extends Thread {
    /* Esta clase tinen un objeto saldo, un nombre y un número de incremento, valores que recibe por parámetros.
     En su método run() incrementan el saldo pasándole el nombre de quién lo incrementa y la cantidad*/
    Saldo saldo;
    String nombre;
    int incremento;

    public Hilo(Saldo saldo, String nombre, int incremento) {
        this.saldo = saldo;
        this.nombre = nombre;
        this.incremento = incremento;
    }

    @Override
    public void run() {
        try {
            saldo.incrementarSaldo(incremento, nombre);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
