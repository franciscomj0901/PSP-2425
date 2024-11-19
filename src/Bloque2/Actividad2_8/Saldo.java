package Bloque2.Actividad2_8;

public class Saldo {
    /* Esta clase maneja un saldo mediante el cuál tiene un valor incial obtenido por parámetros.
       Esta clase tiene un método para consultar el valor del saldo, uno para asignarle un valor
       y otro para incrementar el saldo, se le pasa por parámetros el nombre de quién lo incrementa y
       la cantidad a incrementar, este método muestra quén lo incrementa y en cuanto, el valor del saldo
       antes del incremento y el valor del saldo tras el incremento. Es un método sincronizado ya que
       estamos modificando la variable y lo ejecutarán varios hilos a la vez */

    int valorSaldo;

    public Saldo(int valorSaldo) {
        this.valorSaldo = valorSaldo;
    }

    public int getValorSaldo() throws InterruptedException {
        Thread.sleep((long) ((Math.random()+1)*100));
        return valorSaldo;

    }

    public void setValorSaldo(int valorSaldo) throws InterruptedException {
        Thread.sleep((long) ((Math.random()+1)*100));
        this.valorSaldo = valorSaldo;
    }

    public synchronized void incrementarSaldo(int incremento, String nombre) throws InterruptedException {
        System.out.println(nombre+" incrementa el saldo en "+incremento);
        System.out.println("Saldo antes de incrementar: "+getValorSaldo());
        setValorSaldo(getValorSaldo()+incremento);
        System.out.println("Saldo tras incrementar: "+getValorSaldo());
    }
}
