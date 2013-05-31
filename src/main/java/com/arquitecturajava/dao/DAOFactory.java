package com.arquitecturajava.dao;

public interface DAOFactory {

    public CategoriaDAO getCategoriaDAO();
    public LibroDAO getLibroDAO();

}