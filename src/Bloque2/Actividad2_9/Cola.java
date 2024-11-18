package Bloque2.Actividad2_9;

public class Cola {
    /* Esta clase simula una Cola, con un método get() que devuelve el número que hay en
     la cola y un método put() que inserta un número a la cola. Tiene también una variable
     que indica si hay o no un número en la cola para obtener, si no hay y se ejecuta el
     get(), devuelve -1 */
    private int numero;
    private boolean disponible=false;

    public int get(){
        if(disponible){
            disponible=false;
            return numero;
        }
        return -1;
    }

    public void put(int valor){
        numero=valor;
        disponible=true;
    }
}
