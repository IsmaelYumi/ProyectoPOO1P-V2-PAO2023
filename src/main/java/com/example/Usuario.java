package com.example;

import java.util.ArrayList;

public abstract class  Usuario{
    String nombre;
    String apellido;
    String correoElectronico;

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", correoElectronico=" + correoElectronico
                + "]";
    }
    public abstract void GenerarCorreo();
    
    
}