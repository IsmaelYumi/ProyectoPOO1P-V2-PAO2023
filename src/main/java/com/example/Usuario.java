package com.example;

import java.util.ArrayList;

public abstract class  Usuario{
    String nombre;
    String apellido;
    String correoElectronico;
    String user;
    String Contrasenia;
    char rol;

    public Usuario(String user , String Contrasenia,char rol,String nombre, String apellido) {
        this.user=user;
        this.Contrasenia=Contrasenia;
        this.rol=rol;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public String getUser() {
        return user;
    }
    public String getContrasenia() {
        return Contrasenia;
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
    public void setUser(String user) {
        this.user = user;
    }
    public void setContrasenia(String contrasenia) {
        Contrasenia = contrasenia;
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