package Bloque2.Actividad2_7;

public class HiloContador extends Thread{
    private static int contador ;
    public HiloContador(String nombre, int contador){
        super(nombre);
        this.contador = contador;
    }
    public void run(){
        if (contador < 5000){
            contador++;
            System.out.println(getName()+": "+contador);
        }else {
            interrupt();
        }
    }
    public static int getContador(){
        return contador;
    }
}
