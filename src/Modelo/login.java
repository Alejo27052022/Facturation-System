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
public class login {
    private int id_u;
    private String nombre_u;
    private String correo_u;
    private String pass_u;
    private String rol;

    public login() {
    }

    public login(int id_u, String nombre_u, String correo_u, String pass_u, String rol) {
        this.id_u = id_u;
        this.nombre_u = nombre_u;
        this.correo_u = correo_u;
        this.pass_u = pass_u;
        this.rol = rol;
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public String getNombre_u() {
        return nombre_u;
    }

    public void setNombre_u(String nombre_u) {
        this.nombre_u = nombre_u;
    }

    public String getCorreo_u() {
        return correo_u;
    }

    public void setCorreo_u(String correo_u) {
        this.correo_u = correo_u;
    }

    public String getPass_u() {
        return pass_u;
    }

    public void setPass_u(String pass_u) {
        this.pass_u = pass_u;
    }

    public String getRol(){
        return rol;
    }
    
    public void setRol(String rol){
        this.rol = rol;
    }
}
