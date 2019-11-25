/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author vmagu
 */
public class Table {
    private static String nombre;
    private static ArrayList<ArrayList<String>> rows;
    public Table(String nombre, ArrayList rows){
        this.nombre=nombre;
        this.rows=rows;
    }
    public String getNombre(){
        return this.nombre;
    }
    public ArrayList getRows(){
        return this.rows;
    }
}
