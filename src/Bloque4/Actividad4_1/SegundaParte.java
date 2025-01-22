package Bloque4.Actividad4_1;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

public class SegundaParte {
    /* Este programa conecta a un servidor FTP local montado con FileZilla Server utilizando un usuario específico definido en el servidor.
     Muestra el directorio actual del servidor, enumera los directorios disponibles y accede a ellos para listar su contenido.
     Si intenta acceder a un directorio al que el usuario no tiene permisos, indica que no se puede acceder, reflejando las restricciones
     configuradas en los permisos del servidor.*/


    public static void conexionServidor(String servFTP, String usuario, String password) {
        try {
            //Conexión al servidor
            FTPClient cliente = new FTPClient();
            cliente.connect(servFTP);
            cliente.enterLocalPassiveMode();
            System.out.println("Conectando al sevidor: "+servFTP);
            boolean login = cliente.login(usuario, password);
            if (login) {
                System.out.println("Login correcto...");
            }else {
                System.out.println("Login incorrecto...");
                cliente.disconnect();
                System.exit(1);
            }

            //Se muestra el directorio actual y los directorios que contiene
            System.out.println("Directorio actual: "+cliente.printWorkingDirectory());
            FTPFile[] directorios = cliente.listDirectories();
            System.out.println("Directorios que contiene:");
            for (int i = 0; i < directorios.length; i++) {
                System.out.println("\t =>"+directorios[i].getName());
            }

            //Se entra en cada uno de los directorios y se muestra el contenido de cada uno de ellos
            for (FTPFile directorio : directorios) {
                if (cliente.changeWorkingDirectory("/"+directorio.getName())) {
                    System.out.println("Contenido de "+directorio.getName());
                    FTPFile[] files = cliente.listFiles();
                    String[] tipos = {"Fichero", "Directorio", "Enlace simb."};
                    for (int i = 0; i < files.length; i++) {
                        System.out.println("\t"+files[i].getName()+" => "+tipos[files[i].getType()]);
                    }
                }else {
                    System.out.println("No se puede acceder al directorio \""+directorio.getName()+"\"");
                }
            }

            //Desconexión
            boolean logout = cliente.logout();
            if (logout) {
                System.out.println("Logout correcto...");
            } else {
                System.out.println("Logout incorrecto...");
            }
            cliente.disconnect();
            System.out.println("Desconectado\n");


        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        conexionServidor("localhost", "juanmacazorla34", "usuario");
    }
}
