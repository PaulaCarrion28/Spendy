package com.example.Spendy.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spendy.modelos.Categoria;
import com.example.Spendy.servicios.CategoriaServicio;

@RestController
@RequestMapping("/spendy/v1/categorias")
public class CategoriaControlador {
 //Inyectar el servicio correspondiente 
 @Autowired
 private CategoriaServicio servicio;

 //Para cada servicio ofrecido se debe programar una función.
 // Recibirá las peticiones del pedido y reponderá
 
 //Función controladora del servicio guardar categoria
 @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Categoria datos){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.guardar_categoria(datos));
    }
 //Funcion contoladora del servicio listar todas las categorías
@GetMapping
    public ResponseEntity<?> controladorListarTodo(){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.listar_categoria());
    }
}
