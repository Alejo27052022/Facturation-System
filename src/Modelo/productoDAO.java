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
import javax.swing.JComboBox;

/**
 *
 * @author Stalin
 */
public class productoDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public int IdProducto(){
        int id = 0;
        String sql = "SELECT MAX(id_prod) FROM productos";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;
    }

    public boolean RegistrarProductos(producto pro){
        String sql = "INSERT INTO productos (codigo, nombre_prod, proveedor_prod, stock, precio) VALUES (?,?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre_prod());
            ps.setString(3, pro.getProveedor_prod());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public void ConsultarProveedor(JComboBox proveedor){
        String sql = "SELECT nombre_pv FROM proveedor";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                proveedor.addItem(rs.getString("nombre_pv"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public List listarProducto(){
        List<producto> Listarpro = new ArrayList();
        String sql = "SELECT * FROM productos";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                producto pro = new producto();
                pro.setId_prod(rs.getInt("id_prod"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre_prod(rs.getString("nombre_prod"));
                pro.setProveedor_prod(rs.getString("proveedor_prod"));
                pro.setStock(rs.getInt("stock"));
                pro.setPrecio(rs.getDouble("precio"));
                Listarpro.add(pro);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return Listarpro;
    }
    
    public boolean EliminarProductos(int id_prod){
        String sql = "DELETE FROM productos WHERE id_prod = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_prod);
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
    
    public boolean ModificarProductos(producto pro){
        String sql = "UPDATE productos SET codigo=?, nombre_prod=?, proveedor_prod=?, stock=?, precio=? WHERE id_prod=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre_prod());
            ps.setString(3, pro.getProveedor_prod());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio());
            ps.setInt(6, pro.getId_prod());
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
    
    public producto BuscarPro(String codigo){
        producto producto = new producto();
        String sql = "SELECT * FROM productos where codigo = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto.setNombre_prod(rs.getString("nombre_prod"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getDouble("precio"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return producto;
    }
}
