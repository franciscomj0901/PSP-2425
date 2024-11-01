package Bloque2.Actividad2_5.Ejercicio9;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends Applet implements ActionListener {
   /* Clase que extiende de Applet e implementa ActionListener para manejar dos hilos que
   incrementan un contador y muestran su valor en pantalla una vez se inician con un boton comenzar.
   Cada hilo tiene un tiempo de espera entre incremento especificado en su constructor y un botón
   que interrumpe el hilo. El boton finalizar interrumpe ambos hilos. */


    private MyHilo h1;
    private MyHilo h2;
    private Font fuente;
    private Label l1, l2, cont1, cont2;
    private Button c, f1, f2, f;

    @Override
    public void start() {
        if (h1 == null){
            h1 = new MyHilo("Hilo 1",300, this);
        }
        if (h2 == null){
            h2 = new MyHilo("Hilo 2",600, this);
        }
    }

    @Override
    public void init() {
        setBackground(Color.white);

        add(c=new Button("Comenzar Proceso"));
        c.addActionListener(this);
        l1=new Label("Hilo 1");
        l2=new Label("Hilo 2");

        add(f1=new Button("Interrrumpir hilo 1"));
        f1.addActionListener(this);

        add(f2=new Button("Interrrumpir hilo 2"));
        f2.addActionListener(this);


        add(f=new Button("Finalizar Proceso"));
        f.addActionListener(this);

        fuente = new Font("Verdana", Font.BOLD, 20);

    }



    @Override
    public void paint(Graphics g) {
        g.clearRect(0,0,400,400);
        g.setFont(fuente);

        g.drawString(l1.getText()+": "+h1.getCont(),80,100);
        g.drawString(l2.getText()+": "+h2.getCont(),80,140);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==c){
            l1.setText(h1.getName()+" Corriendo: ");
            l2.setText(h2.getName()+" Corriendo: ");
            h1.start();
            h2.start();
        }else if(e.getSource()==f1){
            l1.setText(h1.getName()+" Interrumpido: ");
            h1.interrupt();
        }else if(e.getSource()==f2){
            l2.setText(h2.getName()+" Interrumpido: ");
            h2.interrupt();
        }else if(e.getSource()==f){
            l1.setText(h1.getName()+" Interrumpido: ");
            l2.setText(h2.getName()+" Interrumpido: ");
            h1.interrupt();
            h2.interrupt();
            System.out.println("El valor final del hilo llamado "+h1.getName()+" es: "+h1.getCont());
            System.out.println("El valor final del hilo llamado "+h2.getName()+" es: "+h2.getCont());

        }
    }

    @Override
    public void stop() {
        l1.setText(h1.getName()+" Interrumpido: ");
        l2.setText(h2.getName()+" Interrumpido: ");
        h1.interrupt();
        h2.interrupt();
        System.out.println("El valor final del hilo llamado "+h1.getName()+" es: "+h1.getCont());
        System.out.println("El valor final del hilo llamado "+h2.getName()+" es: "+h2.getCont());
    }

}
