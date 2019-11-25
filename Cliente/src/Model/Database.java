/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author vmagu
 */
public class Database {
    private static String nombre;
    public Database(String nombre){
        this.nombre=nombre;
    }
    public String getName(){
        return this.nombre;
    }
}
