package com.example.Spendy.servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Spendy.modelos.Categoria;
import com.example.Spendy.repositorios.ICategoriaRepositorio;

@Service
public class CategoriaServicio {
    //Conectar depencias con @autowired
    @Autowired
    private ICategoriaRepositorio repositorio;

    
    //Servicio para guardar un usuario
    public Categoria guardar_categoria(Categoria datosCategoria){
    //Validad la operación que me están pidiendo hacer
        if(datosCategoria.getNombre()==null || datosCategoria.getNombre().isBlank() || datosCategoria.getNombre().isEmpty()){

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del usuario es obligatorio, revisa por favor"
            );
        }

        //Despues de las validaciones intento guardar los datos que me enviaron 
        return repositorio.save(datosCategoria);
    }
    //Servicio para listar todos los usuarios en la BD
    public List<Categoria> listar_categoria(){
        //la capa que hace las consultas es el repositorio 
        return repositorio.findAll();
    }

    //Servicio para eliminar un usuario en bd

    //Servicio para modificar un usuario en bd

    //Servicio para buscar usuario por su id

}
