package Bloque3.Actividad3_8.Ejercicio_3;

import java.io.Serializable;

public class Curso implements Serializable {
    /* Clase Curso que representa un curso con un identificador (id) y una descripción.
        Implementa la interfaz Serializable. */

    String id;
    String descripcion;

    public Curso(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
