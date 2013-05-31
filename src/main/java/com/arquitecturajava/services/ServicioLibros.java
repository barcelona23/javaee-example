package com.arquitecturajava.services;

import java.util.List;
import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;

public interface ServicioLibros {

    public LibroDAO getLibroDAO();

    public void setLibroDAO(LibroDAO libroDAO);

    public CategoriaDAO getCategoriaDAO();

    public void setCategoriaDAO(CategoriaDAO categoriaDAO);

    public void insertarLibro(Libro libro);

    public void borrarLibro(Libro libro);

    public List<Libro> buscarTodosLosLibros();

    public List<Categoria> buscarTodasLasCategorias();

    public Libro buscarLibroPorISBN(String isbn);

    public Categoria buscarCategoriaPorClave(int id);

    public List<Libro> buscarLibrosPorCategoria(int categoria);

}