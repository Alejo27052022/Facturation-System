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
public class proveedor {
    private int id_prov;
    private int ruc;
    private String nombre_pv;
    private int telefono_pv;
    private String direccion_pv;

    public proveedor() {
    }

    public proveedor(int id_prov, int ruc, String nombre_pv, int telefono_pv, String direccion_pv) {
        this.id_prov = id_prov;
        this.ruc = ruc;
        this.nombre_pv = nombre_pv;
        this.telefono_pv = telefono_pv;
        this.direccion_pv = direccion_pv;
    }

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public String getNombre_pv() {
        return nombre_pv;
    }

    public void setNombre_pv(String nombre_pv) {
        this.nombre_pv = nombre_pv;
    }

    public int getTelefono_pv() {
        return telefono_pv;
    }

    public void setTelefono_pv(int telefono_pv) {
        this.telefono_pv = telefono_pv;
    }

    public String getDireccion_pv() {
        return direccion_pv;
    }

    public void setDireccion_pv(String direccion_pv) {
        this.direccion_pv = direccion_pv;
    }
    
    
    
}

