/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Stalin
 */
public class proveedorDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    public boolean RegistrarProveedor(proveedor pr){
        String sql = "INSERT INTO proveedor(ruc, nombre_pv, telefono_pv, direccion_pv) values (?,?,?,?)";
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getRuc());
            ps.setString(2, pr.getNombre_pv());
            ps.setInt(3, pr.getTelefono_pv());
            ps.setString(4, pr.getDireccion_pv());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch(Exception e){
                System.out.println(e.toString());
            }
        }
    }
    
    public List listarProveedor(){
        List<proveedor> Listarpr = new ArrayList();
        String sql = "SELECT * FROM proveedor";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                proveedor pr = new proveedor();
                pr.setId_prov(rs.getInt("id_prov"));
                pr.setRuc(rs.getInt("ruc"));
                pr.setNombre_pv(rs.getString("nombre_pv"));
                pr.setTelefono_pv(rs.getInt("telefono_pv"));
                pr.setDireccion_pv(rs.getString("direccion_pv"));
                Listarpr.add(pr);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return Listarpr;
    }
    
    public boolean EliminarProveedor(int ruc){
        String sql = "DELETE FROM proveedor WHERE ruc = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ruc);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public boolean ModificarProveedor(proveedor pr){
        String sql = "UPDATE proveedor SET ruc=?, nombre_pv=?, telefono_pv=?, direccion_pv=? WHERE id_prov=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getRuc());
            ps.setString(2, pr.getNombre_pv());
            ps.setInt(3, pr.getTelefono_pv());
            ps.setString(4, pr.getDireccion_pv());
            ps.setInt(5, pr.getId_prov());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}



