package Bloque2.Actividad2_8.Ejercicio11;

public class Arbitro {
    /* Esta clase crea un objeto arbitro que tiene como atributos el número de jugadores de la partida, el turno
       el número a adivinar y si el juego está o no terminado. En su constructor recibe el número de jugadores de la partida,
       genera de quién es el turno aleatoriamente y el número a adivinar. Tiene un método para obtener el turno y otro para indicar si el
       juego esta o no terminado. También tiene un método llamado comprobarJugada() que recibe por parámetros el id del jugador que juega
       y el número que juega, en él se comprueba si el número jugado es o no el número a adivinar, si es se muestra por pantalla un mensaje
       y se indica en la variable correspondiente que el juego se ha terminado. Si el número jugado no es el número a adivinar, se muestra un mensaje
       en pantalla, se genera aleatoriamente otro turno y se indica por pantalla a quien le toca. */

    int numJugadores;
    int turno;
    int numAdininar;
    boolean terminado;

    public Arbitro(int numJugadores) {
        this.numJugadores = numJugadores;
        this.turno = (int) (1+ (numJugadores* Math.random()));
        this.numAdininar = (int) (1 + (10* Math.random()));
        this.terminado = false;
    }

    public int getTurno() {
        return turno;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public synchronized void compruebaJugada(int idJugador, int numJugado) {
        if (!terminado){
            System.out.println("El Jugador "+idJugador+" juega el número " + numJugado);
            if (numJugado == numAdininar){
                terminado = true;
                System.out.println("El Jugador "+idJugador+" gana!!");
                System.out.println("Partida finalizada.");
            }else {
                System.out.println("Número incorrecto.");
                this.turno = (int) (1+ (numJugadores* Math.random()));
                System.out.println("-------------------------------------------");
                System.out.println("Le toca a Jugador "+turno);
            }
        }

    }
}
