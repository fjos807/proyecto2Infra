
package proyecto2;

import Interfaz.*;
import java.util.List;
import javax.swing.JFrame;
import logica.Files;

/**
 *
 * @author GRD
 */
public class Proyecto2 {
    public static void main(String[] args) {
        Files archivo=new Files();
        //String cwd = System.getProperty("user.dir\\Bases");
        List<String> folders= archivo.findAllDataBases();
        System.out.println(folders.size());
//        System.out.println(folders.get(0));
//        System.out.println(folders.get(1));
        Inicio inicio = new Inicio();
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    
}// Gerald x keilin(amor de mi vida)
