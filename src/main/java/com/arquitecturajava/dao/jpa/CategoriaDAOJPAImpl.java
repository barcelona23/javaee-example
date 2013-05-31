package com.arquitecturajava.dao.jpa;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.dao.CategoriaDAO;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaDAOJPAImpl extends GenericDAOJPAImpl<Categoria, Integer> implements CategoriaDAO {

}