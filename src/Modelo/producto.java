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
public class producto {
    private int id_prod;
    private String codigo;
    private String nombre_prod;
    private String proveedor_prod;
    private int stock;
    private double precio;

    public producto() {
    }

    public producto(int id_prod, String codigo, String nombre_prod, String proveedor_prod, int stock, double precio) {
        this.id_prod = id_prod;
        this.codigo = codigo;
        this.nombre_prod = nombre_prod;
        this.proveedor_prod = proveedor_prod;
        this.stock = stock;
        this.precio = precio;
    }
    
    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public String getProveedor_prod() {
        return proveedor_prod;
    }

    public void setProveedor_prod(String proveedor_prod) {
        this.proveedor_prod = proveedor_prod;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
