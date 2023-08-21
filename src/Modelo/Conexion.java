/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Stalin
 */
public class Conexion {
    Connection con;
    
    public Connection Conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/sistemaventa";
            con=DriverManager.getConnection(url,"root","1234");
            return con;
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
    }
}
