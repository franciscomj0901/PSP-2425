package Bloque2.Actividad2_1;
/* Esta clase crea una clase que extiende de Thread la cuál recibe en el constructor un String
 y la asocia como nombre del hilo. Sobreescribe el método run haciendo un bucle infinito en el
 que imprime el nombre del hilo (String pasado por parámetros en el constructor) y se usa el método
 sleep para hacer una pausa en el bucle y que nos de tiempo a leer la salida */


public class Hilos extends Thread {
    public Hilos(String palabra){
        super(palabra);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 1; i--) {
                System.out.println(getName());
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
        }

    }
}
