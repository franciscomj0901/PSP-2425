package Bloque3.Actividad3_1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Actividad3_1 {
    public static void main(String[] args) {
        System.out.print("Introduce una dirección IP o el nombre de una máquina (Para cancelar introduce 'c'): ");
        String direccion= new Scanner(System.in).next();
        while (!direccion.equals("c") && !direccion.equals("C")) {
            try {
                mostrarInformacion(InetAddress.getByName(direccion));

            }catch (UnknownHostException e) {
                e.printStackTrace();
            }

            System.out.print("Introduce una dirección IP o el nombre de una máquina (Para cancelar introduce 'c'): ");
            direccion= new Scanner(System.in).next();
        }
    }

    private static void mostrarInformacion(InetAddress dir){
        try {
            System.out.println("\tDIRECCIONES IP PARA: "+dir.getHostName());
            InetAddress[] direcciones= InetAddress.getAllByName(dir.getHostName());
            for (int i = 0; i < direcciones.length; i++) {
                System.out.println("\t\t"+direcciones[i].toString());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        System.out.println("\tHost Name: "+dir.getHostName());
        System.out.println("\tHost Address: "+dir.getHostAddress());
        System.out.println("\tDirección completa: "+dir.toString());
        System.out.println("\tCanonical Host Name: "+dir.getCanonicalHostName());


    }

}
