package Bloque2.Actividad2_5.Ejercicio9;

import javax.swing.*;
import java.awt.*;

public class VentanaConApplet extends JFrame {
    /* Esta clase crea una ventana con JFrame y ejecuta la clase que contiene el applet */


    public VentanaConApplet() {
        setTitle("Ejercicio 8");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el applet y configurarlo
        Ventana applet = new Ventana();
        applet.init(); // Llamar a init para inicializar el applet
        applet.start(); // Llamar a start para iniciar el applet

        // Añadir el applet al JFrame
        getContentPane().add(applet, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaConApplet ventana = new VentanaConApplet();
            ventana.setVisible(true);
        });
    }
}
