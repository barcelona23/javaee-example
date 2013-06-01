package com.arquitecturajava.webservices;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface ServicioInformacionLibros {

    public List<LibroDTO> listaInformacionLibros();

}