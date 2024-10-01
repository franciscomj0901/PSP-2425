package Ejercicio1_1;


public class LeerNombre {
    public static void main(String[] args){
       if (args.length<=0){ //Si los argumentos son 0
           System.out.println("No se han introducido parametros"); //Se imprime un mensaje
           System.exit(-1); //Sale con el código -1
       }

       System.out.println("Nombre: "+args[0]); //Si llega aquí es que hay argumentos por lo que imprime el primer argumento
       System.exit(1); //Sale con el código 1
    }
}
