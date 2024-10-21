package Bloque2.Actividad2_2.Ejercicio2;
/* Esta clase implementa la interfaz Runnable y sobreescribe el método run()
   imprimiendo "Hola Mundo", una palabra que se le pasa por parámetros en el constructor
   y el identificacior del hilo. También usa el método sleep multiplicando por 100
   el identificador del hilo. Si no implementamos el método sleep o lo implementamos en una menor
   medida, no notaremos diferencia, se ejecutan los hilos sin orden ninguno pero si lo implementamos
   con un tiempo mayor, nos daremos cuenta que se ejecutan ordenadamente*/


public class Hilo implements Runnable {
    String cadena;
    public Hilo(String cadena){
        this.cadena=cadena;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Thread.currentThread().getId()*200);
            System.out.println("Hola Mundo "+cadena+" "+Thread.currentThread().getId());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


}
