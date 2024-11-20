package Bloque2.Actividad2_12;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actividad2_12 extends Applet implements ActionListener {
   /* Clase que extiende de Applet e implementa ActionListener para manejar un hilo que
   muestra en pantalla una "o" y que al pulsar un botón, se mueve horizontalmente de
   izquierda a derecha.
   El hilo arranca con un valor inicial en x de la "o" en 1 y lo incrementa o decrementa en run()
   siempre que esté en ejecución. Para comprobar si esta yendo de izquierda a derecha o de derecha a izquierda
   tenemos un booleano que empieza en true para indicar que la x se debe incrementar, cuando llega
   al valor máximo del ancho de la pantalla, el booleano se pone en false y empieza a decrementarse la x
   para que así vaya de derecha a izquierda.
   La interfaz se actualiza constantemente con el método repaint() para mostrar el nuevo valor
   de x en la "o".
   El boton permite iniciar, parar y reanudar el hilo, cambiando su etiqueta a "Finalizar" o "Reanudar"
   según sea conveniente.
   La velocidad de incremento de la x está controlada mediante un sleep(). */


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

        HiloContador(){}

        public void run(){
            Thread hilo = Thread.currentThread();
            while (true) {
                if (ejecucion) {
                    if (incremento) {
                        valorX++;
                        if (valorX >= getSize().getWidth()) {
                            incremento = false;
                        }
                    } else {
                        valorX--;
                        if (valorX <= 1) {
                            incremento = true;
                        }
                    }
                    repaint();
                }
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
