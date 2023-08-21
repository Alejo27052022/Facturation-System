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

public class VentaDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int IdVenta(){
        int id = 0;
        String sql = "SELECT MAX(id_v) FROM ventas";
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
    
    public int RegistrarVenta(Venta v){
        String sql = "INSERT INTO ventas (producto, proveedor, total) VALUES (?, ?, ?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getProducto());
            ps.setString(2, v.getProveedor());
            ps.setDouble(3, v.getTotal());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    public int RegistrarDetalle(Detalle Dv){
        String sql = "INSERT INTO detalle (cod_pro, cantidad, precio, id_venta) VALUES (?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, Dv.getCod_pro());
            ps.setInt(2, Dv.getCantidad());
            ps.setDouble(3, Dv.getPrecio());
            ps.setInt(4, Dv.getId_det());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    public boolean ActualizarStock(int cantidad, String cod_pro){
        String sql = "UPDATE PRODUCTOS SET stock = ? WHERE codigo = ? ";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setString(2, cod_pro);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List Listarventas(){
        List<Venta> ListarVenta = new ArrayList();
        String sql = "SELECT * FROM ventas";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Venta vent = new Venta();
                vent.setId_v(rs.getInt("id_v"));
                vent.setProducto(rs.getString("producto"));
                vent.setProveedor(rs.getString("proveedor"));
                vent.setTotal(rs.getDouble("total"));
                ListarVenta.add(vent);
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return ListarVenta;
    }}
