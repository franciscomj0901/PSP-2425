package Bloque2.Actividad2_12;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actividad2_12 extends Applet implements ActionListener {
   /* Clase que extiende de Applet e implementa ActionListener para manejar dos hilos que
   incrementan un contador y muestrab su valor en pantalla.
   Cada hilo arranca con un valor inicial y lo incrementa en run() cada 0.3 s.
   La interfaz se actualiza constantemente con el método repaint() para mostrar el valor de cada hilo.
   Los botones permiten finalizar cada hilo de forma individual, cambiando su etiqueta a "Finalizado".
   Sin un retraso en run(), los hilos se ejecutarían de manera desordenada, pero con una pausa,
   vemos una actualización ordenada. */


    private HiloContador h;
    private int valorX;
    private Font fuente;
    private Button b;
    private boolean ejecucion;
    private boolean incremento;


    @Override
    public void start() {
        if (h == null){
            h = new HiloContador();
            h.start();

        }
    }

    @Override
    public void init() {
        setBackground(Color.white);
        add(b=new Button("Iniciar Hilo"));
        b.addActionListener(this);
        fuente = new Font("Verdana", Font.BOLD, 26);
        ejecucion=false;
        valorX=1;
    }



    @Override
    public void paint(Graphics g) {
        g.clearRect(0,0,400,400);
        g.setFont(fuente);
        g.drawString("o",valorX,100);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b && !ejecucion){
            b.setLabel("Finalizar Hilo");
            ejecucion=true;
        }else if(e.getSource()==b && ejecucion) {
            b.setLabel("Reanudar Hilo");
            ejecucion = false;
        }
    }

    @Override
    public void stop() {
        h=null;
    }

    public int getValorX() {
        return valorX;
    }

    public void setValorX(int valorX) {
        this.valorX = valorX;
    }

    public boolean isEjecucion() {
        return ejecucion;
    }

    public class HiloContador extends Thread{

        private long CONTADOR;

        HiloContador(){}

        public long getCONTADOR() {
            return CONTADOR;
        }

        public void run(){
            Thread hilo = Thread.currentThread();

            while(isEjecucion()){
                if (getValorX()>=0 && getValorX()<getSize().width){
                    setValorX(getValorX()+1);
                }else{

                }
                repaint();
                CONTADOR++;
            }
        }
    }
}
