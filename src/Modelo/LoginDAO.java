/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public login log(String correo_u, String pass_u){
        login l = new login();
        String sql = "SELECT * FROM usuarios WHERE correo_u = ? AND pass_u = ?";
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo_u);
            ps.setString(2, pass_u);
            rs = ps.executeQuery();
            if (rs.next()){
                l.setId_u(rs.getInt("id_u"));
                l.setNombre_u(rs.getString("nombre_u"));
                l.setCorreo_u(rs.getString("correo_u"));
                l.setPass_u(rs.getString("pass_u"));
                l.setRol(rs.getString("rol"));
            }
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return l;
    }
    
    public boolean RegistrarUser(login user){
        String sql = "INSERT INTO USUARIOS (nombre_u, correo_u, pass_u, rol) VALUES (?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombre_u());
            ps.setString(2, user.getCorreo_u());
            ps.setString(3, user.getPass_u());
            ps.setString(4, user.getRol());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List ListarUsuarios(){
        List<login> Lista = new ArrayList();
        String sql = "SELECT * FROM usuarios";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                login lg = new login();
                lg.setId_u(rs.getInt("id_u"));
                lg.setNombre_u(rs.getString("nombre_u"));
                lg.setCorreo_u(rs.getString("correo_u"));
                lg.setRol(rs.getString("rol"));
                Lista.add(lg);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Lista;
    }
}
