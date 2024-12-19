package Bloque3.Actividad3_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;


   /* Clase Cliente que crea una interfaz gráfica utilizando Swing, donde el jugador puede adivinar un número entre 1 y 25.
    El jugador ingresa su intento en un campo de texto y lo envía al servidor. El servidor responde con un mensaje indicando
    si el número adivinado es correcto, demasiado bajo o demasiado alto. Además, muestra la cantidad de intentos realizados.
    Si el jugador adivina el número correcto, se muestra un mensaje de felicitación y el juego termina.
    Incluye botones para enviar el intento, salir del juego o reiniciar la interfaz. */

public class Cliente {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JuegoAdivinarNumero();
        });
    }
}

class JuegoAdivinarNumero extends JFrame {
    private JTextField campoNumero;
    private JLabel etiquetaIntentos;
    private JLabel etiquetaResultado;
    private int intentos = 0;

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public JuegoAdivinarNumero() {
        setTitle("Jugador - Adivina un Número");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLayout(new GridLayout(5, 1));

        // Componentes
        JLabel etiquetaIdJugador = new JLabel("ID JUGADOR: 1");
        etiquetaIntentos = new JLabel("INTENTOS: 0");
        JLabel etiquetaInstrucciones = new JLabel("Adivina un NÚMERO ENTRE 1 Y 25");
        campoNumero = new JTextField();
        JButton botonEnviar = new JButton("Enviar");
        JButton botonSalir = new JButton("Salir");
        etiquetaResultado = new JLabel("");

        // Agregar componentes al marco
        add(etiquetaIdJugador);
        add(etiquetaIntentos);
        add(etiquetaInstrucciones);
        add(campoNumero);
        add(botonEnviar);
        add(etiquetaResultado);
        add(botonSalir);

        // Conectar al servidor al iniciar
        conectarAlServidor();

        // Acción del botón Enviar
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = campoNumero.getText();
                if (!texto.isEmpty()) {
                    int numero = Integer.parseInt(texto);
                    enviarNumero(numero);
                }
            }
        });

        // Acción del botón Salir
        botonSalir.addActionListener(e -> {
            cerrarConexion();
            System.exit(0);
        });

        setVisible(true);
    }

    private void conectarAlServidor() {
        final String HOST = "127.0.0.1"; // Dirección del servidor
        final int PORT = 6000;          // Puerto del servidor

        try {
            socket = new Socket(HOST, PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            etiquetaResultado.setText("Conexión establecida con el servidor");
        } catch (IOException e) {
            etiquetaResultado.setText("Error al conectar con el servidor");
        }
    }

    private void enviarNumero(int numero) {
        try {
            // Enviar el número al servidor
            out.println(numero);
            intentos++;
            etiquetaIntentos.setText("INTENTOS: " + intentos);

            // Recibir la respuesta del servidor
            String respuesta = in.readLine();
            etiquetaResultado.setText(respuesta);

            // Verificar si el juego terminó
            if (respuesta.startsWith("¡Felicidades!")) {
                JOptionPane.showMessageDialog(this, respuesta);
                cerrarConexion();
                System.exit(0);
            }
        } catch (IOException e) {
            etiquetaResultado.setText("Error al enviar el número al servidor");
        }
    }

    private void cerrarConexion() {
        try {
            if (socket != null) socket.close();
            if (out != null) out.close();
            if (in != null) in.close();
        } catch (IOException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
