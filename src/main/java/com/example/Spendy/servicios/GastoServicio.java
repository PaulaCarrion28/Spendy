package com.example.Spendy.servicios;

import com.example.Spendy.modelos.Gasto;
import com.example.Spendy.repositorios.IGastoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GastoServicio {

    @Autowired
    private IGastoRepositorio repositorio;

    public Gasto guardar(Gasto gasto){
        return repositorio.save(gasto);
    }

    public List<Gasto> listar(){
        return repositorio.findAll();
    }

    public Gasto buscarPorId(Long id){
        return repositorio.findById(id).orElse(null);
    }

    public void eliminar(Long id){
        repositorio.deleteById(id);
    }

    public Gasto actualizar(Long id, Gasto nuevo){
        Gasto existente = repositorio.findById(id).orElse(null);

        if(existente != null){
            existente.setDescripcion(nuevo.getDescripcion());
            existente.setFecha(nuevo.getFecha());
            existente.setValor(nuevo.getValor());
            existente.setIcono(nuevo.getIcono());
            existente.setEsNecesario(nuevo.getEsNecesario());
            existente.setUbicacion(nuevo.getUbicacion());
            existente.setMetodoPago(nuevo.getMetodoPago());
            existente.setCategorias(nuevo.getCategorias());
            existente.setComercio(nuevo.getComercio());

            return repositorio.save(existente);
        }
        return null;
    }
}