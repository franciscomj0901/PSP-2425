package Bloque2.Actividad2_4.Ejercicio8;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends Applet implements ActionListener {
   /* Clase que extiende de Applet e implementa ActionListener para manejar dos hilos que
   incrementan un contador y muestran su valor en pantalla una vez se inician con un boton comenzar.
   Cada hilo tiene un tiempo de espera entre incremento especificado en su constructor, un boton para suspenderlo y
   uno para reanudarlo. El boton finalizar para ambos hilos. */


    private MyHilo h1;
    private MyHilo h2;
    private Font fuente;
    private Label l1, l2, cont1, cont2;
    private Button c, r1, r2, s1, s2, f;

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

        add(r1=new Button("Reanudar hilo 1"));
        r1.addActionListener(this);

        add(r2=new Button("Reanudar hilo 2"));
        r2.addActionListener(this);

        add(s1=new Button("Suspender hilo 1"));
        s1.addActionListener(this);

        add(s2=new Button("Suspender hilo 2"));
        s2.addActionListener(this);

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
        }else if(e.getSource()==s1){
            l1.setText(h1.getName()+" Suspendido: ");
            h1.Suspende();
        }else if(e.getSource()==s2){
            l2.setText(h2.getName()+" Suspendido: ");
            h2.Suspende();
        }else if(e.getSource()==r1){
            l1.setText(h1.getName()+" Corriendo: ");
            h1.Reanuda();
        }else if(e.getSource()==r2){
            l2.setText(h2.getName()+" Corriendo: ");
            h2.Reanuda();
        }else if(e.getSource()==f){
            l1.setText(h1.getName()+" Finalizado: ");
            l2.setText(h2.getName()+" Finalizado: ");
            h1.Parar();
            h2.Parar();
            System.out.println("El valor final del hilo llamado "+h1.getName()+" es: "+h1.getCont());
            System.out.println("El valor final del hilo llamado "+h2.getName()+" es: "+h2.getCont());

        }
    }

    @Override
    public void stop() {
        l1.setText(h1.getName()+" Finalizado: ");
        l2.setText(h2.getName()+" Finalizado: ");
        h1.Parar();
        h2.Parar();
        System.out.println("El valor final del hilo llamado "+h1.getName()+" es: "+h1.getCont());
        System.out.println("El valor final del hilo llamado "+h2.getName()+" es: "+h2.getCont());
    }

}
