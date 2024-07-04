package com.example;

public class Revisor extends Usuario{
    String especialidad;
    int numeroArticurlos;
    public Revisor(String user, String Contrasenia, char rol,String nombre, String apellido, String especialidad, int numeroArticurlos) {
        super(user, Contrasenia,rol, nombre, apellido);
       GenerarCorreo();
    }

   
   
    @Override
    public void GenerarCorreo() {
        this.setCorreoElectronico(this.getUser()+"@gmail.com");
    
    }

    
}
