package Bloque3.Actividad3_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    /* Clase Cliente que crea una interfaz gráfica utilizando Swing, donde el usuario puede escribir un mensaje, enviarlo al servidor y recibir una respuesta.
        Además, incluye botones para limpiar la ventana o salir del cliente. Se conecta a un servidor en el puerto 44444.
        Los mensajes se envían al servidor, el cual responde con el texto en mayúsculas. Si el cliente envía el mensaje "*", se cierra la conexión y se finaliza el programa. */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaCliente());
    }
}

class VentanaCliente extends JFrame {
    private JTextField textoEntrada;
    private JTextArea textoSalida;
    private Socket socket;
    private PrintWriter salida;
    private BufferedReader entrada;

    public VentanaCliente() {
        setTitle("VENTANA DEL CLIENTE - EJERCICIO 5");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textoEntrada = new JTextField();
        textoSalida = new JTextArea();
        textoSalida.setEditable(false);

        JButton btnEnviar = new JButton("Enviar");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnSalir = new JButton("Salir");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnEnviar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnSalir);

        add(textoEntrada, BorderLayout.NORTH);
        add(new JScrollPane(textoSalida), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        try {
            socket = new Socket("localhost", 44444);
            salida = new PrintWriter(socket.getOutputStream(), true);
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            textoSalida.append("Error conectando al servidor\n");
            e.printStackTrace();
        }

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textoEntrada.getText();
                if (!texto.isEmpty()) {
                    salida.println(texto);
                    try {
                        String respuesta = entrada.readLine();
                        if (respuesta != null) {
                            textoSalida.append("Servidor: " + respuesta + "\n");
                        }
                    } catch (IOException ex) {
                        textoSalida.append("Error al leer la respuesta del servidor\n");
                        ex.printStackTrace();
                    }
                }
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoEntrada.setText("");
                textoSalida.setText("");
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salida.println("*");
                try {
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });

        setVisible(true);
    }
}
