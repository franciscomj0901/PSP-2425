package Bloque2.Actividad2_3;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actividad2_3 extends Applet implements ActionListener {
   /* Clase que extiende de Applet e implementa ActionListener para manejar dos hilos que
   incrementan un contador y muestrab su valor en pantalla.
   Cada hilo arranca con un valor inicial y lo incrementa en run() cada 0.3 s.
   La interfaz se actualiza constantemente con el método repaint() para mostrar el valor de cada hilo.
   Los botones permiten finalizar cada hilo de forma individual, cambiando su etiqueta a "Finalizado".
   Sin un retraso en run(), los hilos se ejecutarían de manera desordenada, pero con una pausa,
   vemos una actualización ordenada. */


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
            h1.stop();
        }else if(e.getSource()==b2){
            b2.setLabel("Finalizado Hilo 2");
            h2.stop();
        }
    }

    @Override
    public void stop() {
        h1=null;
        h2=null;
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
            boolean parar;
            parar = false;
            Thread hilo = Thread.currentThread();

            while(!parar){
                try {
                    Thread.sleep(300);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                repaint();
                CONTADOR++;
            }
        }
    }
}
