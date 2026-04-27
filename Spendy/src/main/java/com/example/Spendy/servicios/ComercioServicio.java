package com.example.Spendy.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Spendy.modelos.Comercio;
import com.example.Spendy.repositorios.IComercioRepositorio;

@Service

public class ComercioServicio {

    @Autowired
    private IComercioRepositorio repositorio;
    //Servicio para guardar un comercio

    public Comercio guardar_comercio (Comercio datosComercio){

        if(datosComercio.getNombre()== null || datosComercio.getNombre().isBlank() || datosComercio.getNombre().isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del Comercio no es válido"
            );
        }

        if (datosComercio.getNit().length() <6 ){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El NIT ingresado no es válido"
            );
        }

        return repositorio.save(datosComercio);
        }
    

// Servicio para listar todos los comercios en BD

public List <Comercio> listar_Comercio(){
    return repositorio.findAll();
}
}

