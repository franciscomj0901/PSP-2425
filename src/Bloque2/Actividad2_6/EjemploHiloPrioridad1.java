package Bloque2.Actividad2_6;

public class EjemploHiloPrioridad1 {
    public static void main(String[] args) {
        HiloPrioridad1 h1 = new HiloPrioridad1("Hilo 1");
        HiloPrioridad1 h2 = new HiloPrioridad1("Hilo 2");
        HiloPrioridad1 h3 = new HiloPrioridad1("Hilo 3");

        h1.setPriority(Thread.NORM_PRIORITY);
        h2.setPriority(Thread.MAX_PRIORITY);
        h3.setPriority(Thread.MIN_PRIORITY);

        h1.start();
        h2.start();
        h3.start();

        try {
            Thread.sleep(10000);
        } catch (Exception e) {}
        
    }
}
