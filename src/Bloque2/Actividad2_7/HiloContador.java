package Bloque2.Actividad2_7;

public class HiloContador extends Thread{
    private static int contador = 0;
    public HiloContador(String nombre){
        super(nombre);
    }
    public void run(){
        contador++;
        System.out.println(getName()+": "+contador);
    }
    public static int getContador(){
        return contador;
    }
}
