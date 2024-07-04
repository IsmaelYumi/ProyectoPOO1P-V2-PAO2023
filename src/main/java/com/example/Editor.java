package com.example;

public class Editor extends Usuario {
   private String journal;

    

    public Editor(String user, String Contrasenia,char rol, String nombre, String apellido,String journal) {
        super(user, Contrasenia,rol, nombre, apellido);
        this.journal=journal;
        GenerarCorreo();
    }

    @Override
    public void GenerarCorreo() {
        this.setCorreoElectronico(this.getUser()+"@gmail.com");
    }
    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }
    
}
