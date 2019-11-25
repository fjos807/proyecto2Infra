/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
//import java.util.*

import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author vmagu
 */
public class User {
    private static String username;
    private static String password;
    public User(String username, String password){
        
        try {
            String encrypt=cifrar(password);
            this.username=username;
            this.password=encrypt;
        } catch (Exception ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ërror");
        }

    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String cifrar(String password) throws Exception {
        String encriptada=Base64.getEncoder().encodeToString(password.getBytes("utf-8"));
        //System.out.println(encriptada);
        return encriptada;
        
    }
    public String validarUsuario(String usuario, String password) throws Exception{
        String encrypt=cifrar(password);
        return (usuario+","+encrypt);
    }
}
