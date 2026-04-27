package com.example.Spendy.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Spendy.modelos.Categoria;

@Repository
public interface ICategoriaRepositorio extends JpaRepository <Categoria, Integer>{
//GUARDAR
//BUSCAR POR ID
//BUSCAR TODOS LOS REGISSTROS 
//MODIFICAR POR ID
//ELIMINAR POR ID


}