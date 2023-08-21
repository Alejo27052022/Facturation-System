/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Stalin
 */
public class Venta {
    private int id_v;
    private String producto;
    private String proveedor;
    private double total;

    public Venta() {
    }

    public Venta(int id_v, String producto, String proveedor, double total) {
        this.id_v = id_v;
        this.producto = producto;
        this.proveedor = proveedor;
        this.total = total;
    }

    public int getId_v() {
        return id_v;
    }

    public void setId_v(int id_v) {
        this.id_v = id_v;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
