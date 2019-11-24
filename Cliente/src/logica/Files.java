/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Model.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cifrado;

/**
 *
 * @author vmagu
 */
public class Files {
    
public void saveUserCredential(User login) throws Exception{
    String fileName="Users.csv";
    //Delimiter used in CSV file
    String COMMA_DELIMITER = ",";
    String NEW_LINE_SEPARATOR = "\n";
        FileWriter fileWriter = null;
        Cifrado password_enciptada= new Cifrado();
       
        //password_encriptada.cifrar(login.getPassword());
        try {
            String password=password_enciptada.cifrar(login.getPassword());
            fileWriter = new FileWriter(fileName,true);
            //Add a new line separator after the header
            
            //Write a new student object list to the CSV file
                fileWriter.append(String.valueOf(login.getUsername()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(password);
                System.out.println("Cifrado:"+password);
                String sin_cifrar=password_enciptada.descifrar(login.getPassword());
                System.out.println("sin cifrar:"+sin_cifrar);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(NEW_LINE_SEPARATOR);
                                fileWriter.flush();
                fileWriter.close();
            //} 
            System.out.println("User save");
             
        } catch (IOException e) {
            System.out.println("Error");

    }
}
public void createUsersFile(){
    String FILE_HEADER = "username,password";
    FileWriter fileWriter;
    try {
        fileWriter = new FileWriter("Users.csv");
        fileWriter.append(FILE_HEADER);
        fileWriter.append("\n");
        fileWriter.flush();
        fileWriter.close();
    } catch (IOException ex) {
        Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public Boolean isRegisted(String username, String password) throws IOException, Exception {
    String resultRow = null;
    BufferedReader br = new BufferedReader(new FileReader("Users.csv"));
    String line;
    Cifrado password_sin_cifrado=new Cifrado();
    String contrasenna=password_sin_cifrado.descifrar(password);
    while ( (line = br.readLine()) != null ) {
        String[] values = line.split(",");
        System.out.println(contrasenna);
        if(values[0].equals(username)) {
            if(values[1].equals(password_sin_cifrado)){
                //System.out.println(values[0]);
                return true;
            }
        }
    }
    br.close();
    return false;
}
}
