package com.arquitecturajava.dao.jpa;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.dao.LibroDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LibroDAOJPAImpl extends GenericDAOJPAImpl<Libro, String> implements LibroDAO {

    @PersistenceContext
    private EntityManager manager;

    @Transactional(readOnly=true)
    public List<Libro> buscarPorCategoria(Categoria categoria) {
        List<Libro> listaDeObjetos = null;
        TypedQuery<Libro> consulta = manager.createQuery("select l from Libro l where l.categoria=?1",Libro.class);
        consulta.setParameter(1,categoria);
        listaDeObjetos = consulta.getResultList();
        return listaDeObjetos;
    }
}