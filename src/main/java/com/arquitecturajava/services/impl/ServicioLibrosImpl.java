package com.arquitecturajava.services.impl;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.services.ServicioLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value="servicioLibros")
public class ServicioLibrosImpl implements ServicioLibros {

    private LibroDAO libroDAO=null;
    private CategoriaDAO categoriaDAO=null;


    public ServicioLibrosImpl() {
    }

    @Override
    public LibroDAO getLibroDAO() {
        return libroDAO;
    }

    @Autowired
    public void setLibroDAO(LibroDAO libroDAO) {
        this.libroDAO = libroDAO;
    }

    @Override
    public CategoriaDAO getCategoriaDAO() {
        return categoriaDAO;
    }

    @Autowired
    public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @Transactional
    public void insertarLibro(Libro libro) {
        libroDAO.salvar(libro);
    }

    @Transactional
    public void borrarLibro(Libro libro) {
        libroDAO.borrar(libro);
    }

    @Transactional
    public List<Libro> buscarTodosLosLibros() {
        return libroDAO.buscarTodos();
    }

    @Transactional
    public List<Categoria> buscarTodasLasCategorias() {
        return categoriaDAO.buscarTodos();
    }

    @Transactional
    public Libro buscarLibroPorISBN(String isbn) {
        return libroDAO.buscarPorClave(isbn);
    }

    @Transactional
    public Categoria buscarCategoriaPorClave(int id) {
        return categoriaDAO.buscarPorClave(id);
    }

    @Transactional
    public List<Libro> buscarLibrosPorCategoria(int id) {
        Categoria categoria= categoriaDAO.buscarPorClave(id);
        return libroDAO.buscarPorCategoria(categoria);
    }

}