package com.proyecto.dogmate.dogmate;

/**
 * Created by otroj on 5/5/2017.
 */
public class MascotaRegistrada {
    private String edad;
    private boolean esterilizado;
    private String foto;
    private String genero;
    private String nombre;
    private String raza;

    public MascotaRegistrada(String edad, boolean esterilizado, String foto, String genero, String nombre, String raza) {
        this.edad = edad;
        this.esterilizado = esterilizado;
        this.foto = foto;
        this.genero = genero;
        this.nombre = nombre;
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public boolean isEsterilizado() {
        return esterilizado;
    }

    public void setEsterilizado(boolean esterilizado) {
        this.esterilizado = esterilizado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
