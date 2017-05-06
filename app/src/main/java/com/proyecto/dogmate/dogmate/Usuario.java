package com.proyecto.dogmate.dogmate;

/**
 * Created by otroj on 5/5/2017.
 */
public class Usuario{

    private String apellidos;
    private long celular;
    private String correo;
    private String fechaNac;
    private String nombre;
    private String password;

    public Usuario(String apellidos, long celular, String correo, String fechaNac, String nombre, String password) {
        this.apellidos = apellidos;
        this.celular = celular;
        this.correo = correo;
        this.fechaNac = fechaNac;
        this.nombre = nombre;
        this.password = password;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
