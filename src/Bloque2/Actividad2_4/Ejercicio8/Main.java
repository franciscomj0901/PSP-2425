package Bloque2.Actividad2_4.Ejercicio8;

import java.util.Scanner;

public class Main {
    /* Esta clase instancia un objeto Myhilo llamado hlo el cuál inicia. Mediante un Scanner lee por pantalla lo
    que introduzca el usuario, si el usuario introduce * el hilo se parará, si introduce cualquier otro carácter
    su ejecución seguirá. Si el usuario introduce s o S el hilo se suspenderá, mostrará un mensaje y quedará a esperas
     de que el usuario introduzca los carácteres r o R, con los cuáles se mostrará un mensaje y se reanudará el hilo.
     Al finalizar el hilo con el carácter * obtenemos el contador final mediante un método llamado getCont() que contiene
     el hilo. */


    public static void main(String[] args) {
        MyHilo hilo = new MyHilo();
        hilo.start();

        String c="";
        Scanner sc = new Scanner(System.in);
        while (!c.equals("*")){ //Mientras que no sea *
            c=sc.next();
            if (c.equals("s") || c.equals("S")){ //Si introduce s o S se suspende el hilo
                hilo.Suspende();
                System.out.println("Hilo Suspendido");
            }

            if (c.equals("r") || c.equals("R")){ //Si introduce r o R se reanuda el hilo
                hilo.Reanuda();
                System.out.println("Hilo reanudado");
            }
        }

        hilo.Parar(); //Si llega aquí es que se ha introducido * por lo que para el hilo
        System.out.println("Hilo Terminado");
        System.out.println("El valor final del contador es "+hilo.getCont()); //Muestra el valor final del contador



    }
}
