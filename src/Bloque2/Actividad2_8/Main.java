package Bloque2.Actividad2_8;

public class Main {
    /* Esta clase instancia un objeto de la clase saldo y 2 contadores a los cuales les asigna el mismo objeto saldo y un nombre.
    Realiza un bucle para que cada hilo se ejecute 3 veces. Al estar sincronizado el incremento, no se pisan por lo tanto hay una coherencia en los datos
    ya que uno no puede insertar si otro está insertando*/
    public static void main(String[] args) {
        Saldo saldo = new Saldo(0);
        Hilo h1 = new Hilo(saldo, "Javier", 10);
        Hilo h2 = new Hilo(saldo, "Luna", 15);

        for (int i = 0; i < 3; i++) {
            h1.run();
            h2.run();
        }
    }
}
