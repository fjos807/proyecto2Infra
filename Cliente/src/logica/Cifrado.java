/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.security.Key;
import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author vmagu
 */
public class Cifrado {
    public String cifrar(String password) throws Exception {
        String encriptada=Base64.getEncoder().encodeToString(password.getBytes("utf-8"));
        //System.out.println(encriptada);
        return encriptada;
        
    }
    public String descifrar(String password) throws Exception {
        byte[] decode = Base64.getDecoder().decode(password.getBytes());
        System.out.println(new String(decode, "utf-8"));
        return new String(decode, "utf-8");
    }
}

