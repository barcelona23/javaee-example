package com.arquitecturajava.beans;

import com.arquitecturajava.bo.Categoria;
import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.services.ServicioLibros;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class FormularioLibroManagedBean {

    private String isbn;
    private String titulo;
    private String categoria;
    private List<SelectItem> listaDeCategorias;
    private List<Libro> listaDeLibros;

    @ManagedProperty(value="#{servicioLibros}")
    private ServicioLibros servicioLibros;

    public List<Libro> getListaDeLibros() {
        return listaDeLibros;
    }

    @PostConstruct
    public void iniciar() {
        if(servicioLibros==null)
            servicioLibros = getServicioLibros();
        listaDeLibros = servicioLibros.buscarTodosLosLibros();
        List<Categoria> categorias = servicioLibros.buscarTodasLasCategorias();
        listaDeCategorias = new ArrayList<SelectItem>();
        for (Categoria categoria : categorias) {
            listaDeCategorias.add(new SelectItem(categoria.getId(), categoria.getDescripcion()));
        }
    }

    public void setListaDeLibros(List<Libro> listaDeLibros) {
        this.listaDeLibros = listaDeLibros;
    }

    public List<SelectItem> getListaDeCategorias() {
        return listaDeCategorias;
    }

    public void setListaDeCategorias(List<SelectItem> listaDeCategorias) {
        this.listaDeCategorias = listaDeCategorias;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setServicioLibros(ServicioLibros servicioLibros) {
        this.servicioLibros = servicioLibros;
    }

    public void insertar(ActionEvent evento) {
        servicioLibros.insertarLibro(new Libro(isbn, titulo, new Categoria(Integer.parseInt(categoria))));
        setListaDeLibros(servicioLibros.buscarTodosLosLibros());
        categoria="0";
    }

    public void borrar(String isbn) {
        servicioLibros.borrarLibro(new Libro(isbn));
        setListaDeLibros(servicioLibros.buscarTodosLosLibros());
    }

    public void filtrar(ValueChangeEvent evento) {
        int idCategoria = Integer.parseInt(evento.getComponent().getAttributes().get("value").toString());
        if(idCategoria!=0) {
            setListaDeLibros(servicioLibros.buscarLibrosPorCategoria(idCategoria));
        }else {
            setListaDeLibros(servicioLibros.buscarTodosLosLibros());
        }
    }

    public void editar(String isbn) {
        Libro libro = servicioLibros.buscarLibroPorISBN(isbn);
        this.isbn = libro.getIsbn();
        this.titulo = libro.getTitulo();
    }

    public void formularioInsertar(ActionEvent evento) {
        isbn = "";
        titulo = "";
    }

    public void salvar(ActionEvent evento) {
        servicioLibros.insertarLibro(new Libro(isbn, titulo, new Categoria(Integer.parseInt(categoria))));
        setListaDeLibros(servicioLibros.buscarTodosLosLibros());
        categoria="0";
    }

    public ServicioLibros getServicioLibros() {
        ApplicationContext contexto = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
        return (ServicioLibros) contexto.getBean("servicioLibros");
    }

}