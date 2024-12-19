package Bloque3.Actividad3_8.Ejercicio_3;

import java.io.Serializable;

public class Alumno implements Serializable {
    /* Clase Alumno que representa a un alumno con atributos como ID, nombre, curso y nota.
        Implementa la interfaz Serializable. */

    @Override
    public String toString() {
        return "Alumno{" +
                "idalumno='" + idalumno + '\'' +
                ", nombre='" + nombre + '\'' +
                ", curso=" + curso +
                ", nota=" + nota +
                '}';
    }

    String idalumno;
    String nombre;
    Curso curso;
    int nota;

    public Alumno(String idalumno, String nombre, Curso curso, int nota) {
        this.idalumno = idalumno;
        this.nombre = nombre;
        this.curso = curso;
        this.nota = nota;
    }

    public String getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(String idalumno) {
        this.idalumno = idalumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
