package Bloque4.Actividad4_2;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Actividad4_2 {
    /* Este programa conecta a un servidor FTP local montado con FileZilla Server utilizando un usuario específico definido en el servidor.
     Una vez conectado, accede al directorio del usuario indicado y permite seleccionar un archivo local a través de un cuadro de diálogo gráfico.
     El archivo seleccionado se sube al servidor en el directorio correspondiente al usuario. Tras la subida, se muestra un cuadro de diálogo de éxito y
     el contenido del directorio en el servidor.*/

    public static void addArchivo(String servFTP, String usuario, String password) {
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

            //Nos movemos al directorio del usuario
            cliente.changeWorkingDirectory("/"+usuario);

            //Selección del archivo y subida al servidor FTP
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());

                String archivo = selectedFile.getAbsolutePath();
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(archivo));
                if (cliente.storeFile(selectedFile.getName(), in)) {
                    JOptionPane.showMessageDialog(
                            null,
                            selectedFile.getName()+"=> Subido correctamente",
                            "Mensaje",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }else {
                    JOptionPane.showMessageDialog(
                            null,
                            selectedFile.getName()+"=> No se ha podido subir",
                            "ERROR",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
                in.close();
            } else {
                System.out.println("No se seleccionó ningún archivo.");
            }

            //Se muestra el contenido del directorio actual
            System.out.println("Directorio actual: "+cliente.printWorkingDirectory());
            FTPFile[] directorios = cliente.listFiles();
            System.out.println("Contenido: ");
            for (int i = 0; i < directorios.length; i++) {
                System.out.println("\t =>"+directorios[i].getName());
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
        addArchivo("localhost", "juanmacazorla34", "usuario");
    }
}
