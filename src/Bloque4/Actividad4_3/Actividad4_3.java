package Bloque4.Actividad4_3;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class Actividad4_3 {

    /* Este programa permite conectarse a un servidor FTP local montado en FileZilla Server utilizando un usuario y contraseña proporcionados mediante cuadros de diálogo.
     Tras el inicio de sesión exitoso, el programa muestra una interfaz gráfica que lista los archivos disponibles en el directorio del usuario en el servidor FTP.
     Los usuarios pueden seleccionar un archivo de la lista para descargarlo a su equipo local, eligiendo la ubicación mediante un cuadro de diálogo.
     La aplicación también permite salir del programa, cerrando la sesión en el servidor y desconectándose. */

    public static void main(String[] args) {
        try {
            // Solicitar usuario y contraseña mediante cuadros de diálogo
            String servFTP = "localhost";
            String usuario = JOptionPane.showInputDialog(null, "Introduce el usuario:", "Conexión al servidor", JOptionPane.QUESTION_MESSAGE);
            String password = JOptionPane.showInputDialog(null, "Introduce la contraseña:", "Conexión al servidor", JOptionPane.QUESTION_MESSAGE);

            // Conexión al servidor
            FTPClient cliente = new FTPClient();
            cliente.connect(servFTP);
            cliente.enterLocalPassiveMode();
            System.out.println("Conectando al servidor: " + servFTP);
            boolean login = cliente.login(usuario, password);
            if (login) {
                JOptionPane.showMessageDialog(null, "Login correcto.", "Conexión exitosa", JOptionPane.INFORMATION_MESSAGE);
                cliente.changeWorkingDirectory("/"+usuario);
            } else {
                JOptionPane.showMessageDialog(null, "Login incorrecto. Verifica tus credenciales.", "ERROR", JOptionPane.ERROR_MESSAGE);
                cliente.disconnect();
                System.exit(1);
            }

            // Obtener la lista de archivos en el directorio actual
            FTPFile[] archivos = cliente.listFiles();
            String listaArchivos[]= new String[archivos.length];
            for (int i = 0; i < archivos.length; i++) {
                if (archivos[i].isFile()) { // Filtrar solo los archivos
                    listaArchivos[i] = archivos[i].getName();
                }
            }

            // Crear la interfaz gráfica
            JFrame ventana = new JFrame("Descargar Archivos");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(400, 300);

            JList<String> mostrarArchivos = new JList<>(listaArchivos);
            JScrollPane scrollPane = new JScrollPane(mostrarArchivos);
            JButton botonDescargar = new JButton("Descargar");
            JButton botonSalir = new JButton("Salir");

            JPanel panelBotones = new JPanel();
            panelBotones.add(botonDescargar);
            panelBotones.add(botonSalir);

            ventana.add(scrollPane, "Center");
            ventana.add(panelBotones, "South");
            ventana.setVisible(true);

            // Acción para descargar el archivo seleccionado
            botonDescargar.addActionListener(e -> {
                String archivoSeleccionado = mostrarArchivos.getSelectedValue();
                if (archivoSeleccionado != null) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Selecciona dónde guardar el archivo");
                    fileChooser.setSelectedFile(new java.io.File(archivoSeleccionado));

                    int userSelection = fileChooser.showSaveDialog(null);
                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        try (FileOutputStream fos = new FileOutputStream(fileChooser.getSelectedFile())) {
                            boolean exito = cliente.retrieveFile(archivoSeleccionado, fos);
                            if (exito) {
                                JOptionPane.showMessageDialog(null, "Archivo descargado correctamente: " + archivoSeleccionado, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "No se pudo descargar el archivo.", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un archivo de la lista.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            });

            // Acción para salir de la aplicación
            botonSalir.addActionListener(e -> {
                try {
                    cliente.logout();
                    cliente.disconnect();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

