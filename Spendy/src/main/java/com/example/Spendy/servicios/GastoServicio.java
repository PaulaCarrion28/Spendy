package com.example.Spendy.servicios;

import com.example.Spendy.modelos.Gasto;
import com.example.Spendy.repositorios.IGastoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GastoServicio {

    @Autowired
    private IGastoRepositorio gastoRepositorio;

    // Obtener todos los gastos
    public List<Gasto> obtenerTodos() {
        return gastoRepositorio.findAll();
    }

    // Guardar un nuevo gasto
    public Gasto guardarGasto(Gasto gasto) {
        return gastoRepositorio.save(gasto);
    }

    // Buscar por ID
    public Optional<Gasto> obtenerPorId(Long id) {
        return gastoRepositorio.findById(id);
    }

    // Eliminar un gasto
    public void eliminarGasto(Long id) {
        gastoRepositorio.deleteById(id);
    }
}