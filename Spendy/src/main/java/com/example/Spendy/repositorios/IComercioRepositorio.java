package com.example.Spendy.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Spendy.modelos.Comercio;

@Repository

public interface IComercioRepositorio extends JpaRepository<Comercio, Integer>{

    //Guardar
    //Buscar por Id
    //Buscar todos los registros
    //Modificar por Id 
    //Eliminar por Id 


}
