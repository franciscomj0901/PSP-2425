package Bloque3.Actividad3_11;

import java.net.Socket;

public class ComunHilos {
    /* Esta clase ComunHilos es utilizada para gestionar la información compartida entre los hilos del servidor de chat.
    Permite llevar el conteo de las conexiones activas, el número máximo de conexiones permitidas,
    y gestionar un array de sockets que representan a los clientes conectados.
    Además, mantiene un historial de los mensajes enviados en el chat para enviarlos a todos los clientes.
    Incluye métodos sincronizados para actualizar las conexiones y mensajes de manera segura en un entorno multihilo. */

    int CONEXIONES;
    int ACTUALES;
    int MAXIMO;
    Socket tabla[] = new Socket[MAXIMO];
    String mensajes;

    public ComunHilos(int maximo, int ACTUALES, int conexiones, Socket[] tabla) {
        this.CONEXIONES = CONEXIONES;
        this.ACTUALES = ACTUALES;
        this.MAXIMO = MAXIMO;
        this.tabla = tabla;
        mensajes = "";
    }

    public ComunHilos() { super(); }

    public int getCONEXIONES() {
        return CONEXIONES;
    }
    public synchronized void setCONEXIONES(int CONEXIONES) {
        this.CONEXIONES = CONEXIONES;
    }

    public int getMAXIMO() {
        return MAXIMO;
    }
    public void setMAXIMO(int MAXIMO) {
        this.MAXIMO = MAXIMO;
    }

    public String getMensajes() {
        return mensajes;
    }
    public synchronized void setMensajes(String mensajes) {
        this.mensajes = mensajes;
    }

    public int getACTUALES() {
        return ACTUALES;
    }
    public synchronized void setACTUALES(int ACTUALES) {
        this.ACTUALES = ACTUALES;
    }

    public synchronized void addTabla(Socket s, int i){
        tabla[i] = s;
    }

    public Socket getElementoTabla(int i){ return tabla[i]; }
}
