package Ejercicio1_3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        File directorio = new File("out/production/PSP-2425");

        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio1_3.EjecutarSuma");

        pb.directory(directorio);

        Process p=pb.start();



        OutputStream os = p.getOutputStream();
        os.write("10\n".getBytes());
        os.write("16\n".getBytes());
        os.flush();


        InputStream is=p.getInputStream();
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
        is.close();
    }
}
