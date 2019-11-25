/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Model.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComboBox;
import logica.Cifrado;

/**
 *
 * @author vmagu
 */
public class Files {
    
public void saveUserCredential(User login) throws Exception{
    String fileName="Users.csv";
    createUsersFile();
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
    if(!FileChecker("Users","")){
    
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
}

public Boolean isRegisted(String username, String password) throws IOException, Exception {
    String resultRow = null;
    BufferedReader br = new BufferedReader(new FileReader("Users.csv"));
    String line;
    Cifrado password_sin_cifrado=new Cifrado();
    String contrasenna=password_sin_cifrado.cifrar(password);
    while ( (line = br.readLine()) != null ) {
        
        String[] values = line.split(",");
        if(values[0].equals(username)) {
            if(values[1].equals(contrasenna)){
                return true;
            }
        }
    }
    br.close();
    return false;
}

public boolean FileChecker(String filename,String root) {
	  File f = new File(root+"\\"+filename+".csv");

	  if(f.exists()){
                System.out.println("File existed");
              return true;
		
	  }else{
              System.out.println("File not found!");
              return false;
	  }
}
public boolean FolderChecker(String foldername) {
	  File f = new File(foldername);

	  if(f.exists()){
                System.out.println("Folder existed");
              return true;
		
	  }else{
              System.out.println("Folder not found!");
              return false;
	  }
}
public void createFolder(String foldername){
    new File("Bases"+"\\"+foldername).mkdir();
    System.out.println("Folder creado");
}
public boolean createTable(String tableName, String db){
    if(!FileChecker(tableName,"Bases")){
        
        new File("Bases"+"\\"+db+"\\"+tableName).mkdir();
        System.out.println("Folder creado");
        return true;
    }
    return false;
}

public List<String> findAllDataBases() {
    String cwd = System.getProperty("user.dir");
    File directory = new File(cwd+"\\"+"Bases");
	
    FileFilter directoryFileFilter = new FileFilter() {
        public boolean accept(File file) {
            return file.isDirectory();
        }
    };
		
    File[] directoryListAsFile = directory.listFiles(directoryFileFilter);
    //System.out.println(directoryListAsFile);
    List<String> foldersInDirectory = new ArrayList<String>(directoryListAsFile.length);
    System.out.println(foldersInDirectory);
    for (File directoryAsFile : directoryListAsFile) {
        //System.out.println(foldersInDirectory.add(directoryAsFile.getName()));
        foldersInDirectory.add(directoryAsFile.getName());
    }
    System.out.println(foldersInDirectory);
    return foldersInDirectory;
}
//    public void Agregar (JComboBox jComboBox1){
//        //leerCSV leerArchivo=new leerCSV();
//        //ArrayList<ArrayList<String>> informacion=leerArchivo.leer();
//        
//        jComboBox1.addItem("Usuarios");
//        
//        for(int i=0;i<informacion.size();i++){
//            ArrayList<String> opc=informacion.get(i);
//            jComboBox1.addItem(opc.get(0));
//        }
//        
//    }
}

