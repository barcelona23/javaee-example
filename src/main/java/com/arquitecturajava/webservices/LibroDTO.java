package com.arquitecturajava.webservices;

public class LibroDTO {

    private String isbn;
    private String titulo;
    private String categoria;

    public LibroDTO() {
    }

    public LibroDTO(String isbn, String titulo, String categoria) {
        super();
        this.isbn = isbn;
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}