package Bloque3.Actividad3_7;

import java.io.Serializable;

public class Numeros implements Serializable {
    /* Clase número que contiene el numero, su cuadrado y su cubo. Tiene un constructor con sus atributos
     y otro vacío. También tiene getters y setters */

    int numero;
    long cuadrado;
    long cubo;

    public Numeros() {
    }

    public Numeros(int numero, long cuadrado, long cubo) {
        this.numero = numero;
        this.cuadrado = cuadrado;
        this.cubo = cubo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public long getCuadrado() {
        return cuadrado;
    }

    public void setCuadrado(long cuadrado) {
        this.cuadrado = cuadrado;
    }

    public long getCubo() {
        return cubo;
    }

    public void setCubo(long cubo) {
        this.cubo = cubo;
    }
}
