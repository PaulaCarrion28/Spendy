package com.example.Spendy.repositorios;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.example.Spendy.modelos.MetodoPago;
 
@Repository
public interface IMetodoPagoRepositorio extends JpaRepository<MetodoPago, Integer> {
    // GUARDAR
    // BUSCAR POR ID
    // BUSCAR TODOS LOS REGISTROS
    // MODIFICAR POR ID
    // ELIMINAR POR ID
}