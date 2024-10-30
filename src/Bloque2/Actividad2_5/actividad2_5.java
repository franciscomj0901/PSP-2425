package Bloque2.Actividad2_5;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actividad2_5 extends Applet implements ActionListener {
   /* COMENTARIO SOBRE LA CLASE EN EL EJERCICIO 2.3
   Lo nuevo de esta clase con respecto a la del ejercicio 2.3 es que ahora no detengo los hilos con el método
   stop(), ahora la clase HiloContador tiene un método interrumpir() que lanza el método interrupt(). La ejecución
   de hilo se realiza mientras el hilo no se haya interrumpido. Ahora cuando se pulse el botón, se ejecutará el método
   interrumpir() del hilo correspondiente */


    private HiloContador h1;
    private HiloContador h2;
    private Font fuente;
    private Button b1,b2;

    @Override
    public void start() {
        if (h1 == null){
            h1 = new HiloContador(100);
            h1.start();

        }
        if (h2 == null){
            h2 = new HiloContador(120);
            h2.start();

        }
    }

    @Override
    public void init() {
        setBackground(Color.yellow);
        add(b1=new Button("Finalizar Hilo 1"));
        b1.addActionListener(this);
        add(b2=new Button("Finalizar Hilo 2"));
        b2.addActionListener(this);
        fuente = new Font("Verdana", Font.BOLD, 26);

    }



    @Override
    public void paint(Graphics g) {
        g.clearRect(0,0,400,400);
        g.setFont(fuente);

        g.drawString("Hilo 1: "+ h1.getCONTADOR(),80,100);
        g.drawString("Hilo 2: "+ h2.getCONTADOR(),80,140);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            b1.setLabel("Finalizado Hilo 1");
            h1.interrumpir();
        }else if(e.getSource()==b2){
            b2.setLabel("Finalizado Hilo 2");
            h2.interrumpir();
        }
    }

    @Override
    public void stop() {
        h1.interrumpir();
        h2.interrumpir();
    }

    public class HiloContador extends Thread{

        private long CONTADOR;

        HiloContador(long CONTADOR){
            this.CONTADOR = CONTADOR;
        }

        public long getCONTADOR() {
            return CONTADOR;
        }

        public void run(){
            Thread hilo = Thread.currentThread();

            while(!isInterrupted()){
                try {
                    Thread.sleep(300);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                repaint();
                CONTADOR++;
            }
        }

        public void interrumpir(){
            interrupt();
        }
    }
}
