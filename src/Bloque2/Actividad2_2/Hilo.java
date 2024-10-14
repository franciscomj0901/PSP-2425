package Bloque2.Actividad2_2;
/* Esta clase implementa la interfaz Runnable y sobreescribe el método run()
   imprimiendo "Hola Mundo" y el identificacior del hilo */


public class Hilo implements Runnable {
    @Override
    public void run() {
        System.out.println("Hola Mundo "+Thread.currentThread().getId());
    }
}
