package Ejercicio1_1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        File directorio = new File("/home/usuario/Documentos/PSP-FranciscoMejias/out/production/PSP-FranciscoMejias"); //
        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio1_1.LeerNombre", "Javi");
        pb.directory(directorio);
        Process p=pb.start();


        try{
            InputStream in=p.getInputStream();
            int c;
            while ((c=in.read())!=-1){
                System.out.print((char)c);
            }
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        int valorSalida;
        try {
            valorSalida = p.waitFor();
            if (valorSalida == 255){
                System.out.println("Valor de salida: " + valorSalida);
            }else{
                System.out.println("Valor de salida: " + valorSalida);
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
