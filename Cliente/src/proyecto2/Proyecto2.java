
package proyecto2;

import Interfaz.*;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JFrame;

/**
 *
 * @author GRD
 */
public class Proyecto2 {
    public static void main(String[] args) throws IOException {
        
        Socket socket = new Socket("127.0.0.1", 8067);
        
        Inicio inicio = new Inicio(socket);
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    
}
