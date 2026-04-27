package com.example.Spendy.repositorios;

import java.util.List;
import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Spendy.modelos.Usuario;
import com.example.Spendy.modelos.utils.TipoDocumento;

@Repository

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer>{

    //Guardar
    //Buscar por Id
    //Buscar todos los registros
    //Modificar por Id 
    //Eliminar por Id 


    //Consulta personalizada 

    //Buscar por nombre
    List<Usuario> findByNombres(String nombres);
    //Buscar por tipo de documento
    List<Usuario> findByTipoDocumento(TipoDocumento tipoDocumento);

    //Buscar por documento 
    Optional<Usuario> findByDocumento(String documento);

    //Buscar por edad 
    List<Usuario> findByEdad(Integer edad);







}
