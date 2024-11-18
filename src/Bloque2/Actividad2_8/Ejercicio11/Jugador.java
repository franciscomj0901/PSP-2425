package Bloque2.Actividad2_8.Ejercicio11;

public class Jugador extends Thread{
    /* Esta clase extiende de Thread y crea un objeto jugador que tiene un id y un arbitro, reccibidos por parámetros.
       En su método run comprueba si el juago ha acabado y si es su turno, si es su turno genera un número aleatorio entre 1 y 10
       y lo juega.
     */

    int id;
    Arbitro arbitro;

    public Jugador(int id, Arbitro arbitro) {
        this.id = id;
        this.arbitro = arbitro;
    }

    @Override
    public void run() {
        while (true){
            if (!arbitro.isTerminado()){
                if (arbitro.getTurno()==id){
                    int numJugado= (int) (1 + (10* Math.random()));
                    arbitro.compruebaJugada(id, numJugado);
                }
            }else {
                break;
            }

        }

    }
}
