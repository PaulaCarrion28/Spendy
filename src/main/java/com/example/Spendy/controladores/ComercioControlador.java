package com.example.Spendy.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spendy.modelos.Comercio;
import com.example.Spendy.servicios.ComercioServicio;


@RestController
@RequestMapping("/spendyapi/v1/comercios")

public class ComercioControlador {

    //Inyectar el servicio correspondiente 

    @Autowired
    private ComercioServicio servicio;

     //La funcion controladora del servicio de guardar comercio
   @PostMapping
   public ResponseEntity<?> controladorGuardar(@RequestBody Comercio datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_comercio(datos)
        );
    }

    //la función controladora del servicio de listar los comercios
    @GetMapping

    public ResponseEntity<?>controladorListarTodo(){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_Comercio()
        );
    }
    }