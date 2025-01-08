package Bloque3.Actividad3_11;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClienteChat extends JFrame implements ActionListener, Runnable{
    /* Esta clase ClienteChat implementa la interfaz gráfica de un cliente para un chat en tiempo real.
    El cliente se conecta a un servidor en el puerto 6000 y permite a los usuarios enviar y recibir mensajes en un chat compartido. */

    private static final long serialVersionUID = 1L;
    Socket socket;

    DataInputStream fentrada;
    DataOutputStream fsalida;

    String nombre;
    static JTextField mensaje = new JTextField();

    private JScrollPane scrollPane;
    static JTextArea textarea1;
    JButton botonEnviar = new JButton("Enviar");
    JButton botonSalir = new JButton("Salir");
    boolean repetir = true;

    public ClienteChat(Socket s, String nombre) {
        super("CONEXIÓN DEL CLIENTE CHAT: "+nombre);
        setLayout(null);
        mensaje.setBounds(10, 20, 400, 30);
        add(mensaje);

        textarea1 = new JTextArea();
        scrollPane = new JScrollPane(textarea1);
        scrollPane.setBounds(10, 50, 400, 300);
        add(scrollPane);

        botonEnviar.setBounds(420, 10, 100, 30);
        add(botonEnviar);
        botonSalir.setBounds(420, 50, 100, 30);
        add(botonSalir);

        textarea1.setEditable(false);
        botonEnviar.addActionListener(this);
        botonSalir.addActionListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        socket = s;
        this.nombre = nombre;
        try {
            fentrada = new DataInputStream(socket.getInputStream());
            fsalida = new DataOutputStream(socket.getOutputStream());
            String texto = " > Entra en el Chat ..." + nombre;
            fsalida.writeUTF(texto);
        } catch (IOException e) {
            System.out.println("ERROR DE E/S");
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonEnviar) {
            if (mensaje.getText().trim().length() == 0) {
                return;
            }
            String texto = nombre + "> " + mensaje.getText();

            try {
                mensaje.setText("");
                fsalida.writeUTF(texto);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getSource() == botonSalir) {
            String texto = " > Abandona el Chat ..." + nombre;
            try {
                fsalida.writeUTF(texto);
                fsalida.writeUTF("*");
                repetir = false;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        String texto = "";
        while (repetir) {
            try {
                texto = fentrada.readUTF();
                textarea1.setText(texto);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "IMPOSIBLE CONECTAR CON EL SERVIDOR\n"+e.getMessage(), "<<MENSAJE DE ERROR:2>>", JOptionPane.ERROR_MESSAGE);
                repetir = false;
            }
        }

        try {
            socket.close();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int puerto = 6000;
        Socket s = null;

        String nombre = JOptionPane.showInputDialog("Introduce tu nombre o nick:");

        if (nombre.trim().length() == 0) {
            System.out.println("El nombre está vacío....");
            return;
        }

        try {
            s = new Socket("localhost", puerto);
            ClienteChat cliente = new ClienteChat(s, nombre);
            cliente.setBounds(0, 0, 540, 400);
            cliente.setVisible(true);
            new Thread(cliente).start();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IMPOSIBLE CONECTAR CON EL SERVIDOR\n"+e.getMessage(), "<<MENSAJE DE ERROR:1>>", JOptionPane.ERROR_MESSAGE);
        }
    }
}
