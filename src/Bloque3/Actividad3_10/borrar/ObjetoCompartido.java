package Bloque3.Actividad3_10.borrar;

public class ObjetoCompartido {
    private int numero; // número a adivinar
    private boolean acabo; // true cuando se haya terminado el juego
    private int ganador; // jugador ganador
    public ObjetoCompartido (int numero) {
        this.numero = numero; // NUMERO A ADIVINAR
        this.acabo = false;
    }
    public boolean seAcabo() { return acabo; }
    public int getGanador() { return ganador; }
    public synchronized String nuevaJugada (int jugador, int suNumero) {
        String cad = "";
        if (!seAcabo()) {
            if (suNumero > numero) { // demasiado grande
                cad = "Numero demasiado grande";
            }
            if (suNumero < numero) { // demasiado pequeño
                cad = "Numero demasiado bajo";
            }
            if (suNumero == numero) { // ha acertado
                cad = "Jugador " + jugador + " gana, adivinó el número: " + numero;
                acabo = true;
                ganador = jugador;
            }
        } else {
            cad = "Jugador " + ganador + " adivinó el número: " + numero;
        }
        return cad;
    }
}
