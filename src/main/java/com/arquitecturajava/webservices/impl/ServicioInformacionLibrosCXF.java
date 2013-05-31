package com.arquitecturajava.webservices.impl;

import com.arquitecturajava.bo.Libro;
import com.arquitecturajava.services.ServicioLibros;
import com.arquitecturajava.webservices.LibroDTO;
import com.arquitecturajava.webservices.ServicioInformacionLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@Service
@WebService(endpointInterface="com.arquitecturajava.webservices.ServicioInformacionLibros")
public class ServicioInformacionLibrosCXF implements ServicioInformacionLibros {

    @Autowired
    private ServicioLibros servicioLibros;

    @WebMethod
    public List<LibroDTO> listaInformacionLibros() {
        List<Libro> listaLibros=servicioLibros.buscarTodosLosLibros();
        List<LibroDTO> listaDestino= new ArrayList<LibroDTO>();
        for(Libro libro: listaLibros) {
            LibroDTO libroExterno= new LibroDTO(libro.getIsbn(),libro.getTitulo(),libro.getCategoria().getDescripcion());
            listaDestino.add(libroExterno);
        }
        return listaDestino;
    }

}