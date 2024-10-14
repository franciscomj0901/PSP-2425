package Bloque2.Actividad2_1.Ejercicio1;
/* Esta clase extiende de la clase Thread y sobreescribe el método run()
   imprimiendo "Hola Mundo" y el identificacior del hilo */


public class Hilo extends Thread {
    @Override
    public void run() {
        System.out.println("Hola Mundo "+Thread.currentThread().getId());
    }
}
