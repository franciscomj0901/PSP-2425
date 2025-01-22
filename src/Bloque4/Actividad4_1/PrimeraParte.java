package Bloque4.Actividad4_1;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

public class PrimeraParte {

    /* Este programa establece conexión con un servidor FTP de manera anónima, muestra el directorio actual,
    lista los directorios disponibles, accede a cada directorio para mostrar su contenido. */

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
                    System.out.println("Directorio incorrecto...");
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
        conexionServidor("ftp.rediris.es", "anonymous", "anonymous");
        conexionServidor("ftp.freebsd.org", "anonymous", "anonymous");

    }
}
