package com.arquitecturajava.dao;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;

import java.util.List;

public interface LibroDAO extends GenericDAO<Libro,String> {

    public  List<Libro> buscarPorCategoria(Categoria categoria);

}