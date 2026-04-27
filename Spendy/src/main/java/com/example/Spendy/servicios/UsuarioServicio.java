package com.example.Spendy.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Spendy.modelos.Usuario;
import com.example.Spendy.repositorios.IUsuarioRepositorio;

@Service

public class UsuarioServicio {

    @Autowired

    private IUsuarioRepositorio repositorio;

    //servicio para guardar un usuario
    public Usuario guardar_usuario(Usuario datosUsuario){

        if(datosUsuario.getNombres() == null || datosUsuario.getNombres().isBlank() || datosUsuario.getNombres().isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del usuario es obligatorio"
            );

        }
        if(datosUsuario.getDocumento().length()<5){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El documento ingresado no es váido"
            );
        }

        //Depues de las validaciones intenta guardar los documentos que me enviaron
        return repositorio.save(datosUsuario);
    }

    // Servicio para listar todos los comercios en BD

    public List <Usuario> listar_Usuarios(){
        return repositorio.findAll();
    }
    }

    
    


