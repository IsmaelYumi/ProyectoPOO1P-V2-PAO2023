package com.example;

import java.security.SecureRandom;

public class Articulo {
    private String titulo;
    private String codigo;
    private String resumen;
    private String contenido;
    private Autor autor;
    private String [] palabras_c;
    public Articulo(String titulo, String resumen, String contenido,Autor au) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.contenido = contenido;
        this.autor=au;
        this.codigo=GenerarCodigo();
    }
    public String getTitulo() {
        return titulo;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getResumen() {
        return resumen;
    }
    public String getContenido() {
        return contenido;
    }
    public Autor getAutor() {
        return autor;
    }
    public String[] getPalabras_c() {
        return palabras_c;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public void setPalabras_c(String[] palabras_c) {
        this.palabras_c = palabras_c;
    }
    private String GenerarCodigo(){
    String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    SecureRandom RANDOM = new SecureRandom();

        StringBuilder codigo = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            int indiceAleatorio = RANDOM.nextInt(CARACTERES.length());
            codigo.append(CARACTERES.charAt(indiceAleatorio));
        }
        return codigo.toString();
    }
    

    
}
