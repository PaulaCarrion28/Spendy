package com.example.Spendy.controladores;

import com.example.Spendy.modelos.Gasto;
import com.example.Spendy.servicios.GastoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gastos")
public class GastoControlador {

    @Autowired
    private GastoServicio servicio;

    @PostMapping
    public Gasto guardar(@RequestBody Gasto gasto){
        return servicio.guardar(gasto);
    }

    @GetMapping
    public List<Gasto> listar(){
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Gasto buscar(@PathVariable Long id){
        return servicio.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Gasto actualizar(@PathVariable Long id, @RequestBody Gasto gasto){
        return servicio.actualizar(id, gasto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        servicio.eliminar(id);
    }
}