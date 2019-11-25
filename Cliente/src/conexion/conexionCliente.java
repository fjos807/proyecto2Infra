package conexion;
import java.net.*;
import java.io.*;


public class conexionCliente {  
    private Socket socket;

    public conexionCliente(String nombreServidor, int puerto) throws IOException {
        socket = new Socket(nombreServidor, puerto);
    }

    public String recepcionMensaje() throws IOException {
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        String res = entrada.readUTF();
        return res;
    }
    
    public void responder(String mensaje) throws IOException {
        OutputStream outToServer = socket.getOutputStream();
        outToServer = socket.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);
        out.writeUTF(mensaje);
    }


    public void terminarConexion() throws IOException {
        socket.close();
    }

}
