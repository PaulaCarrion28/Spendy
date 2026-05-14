package com.example.Spendy.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Spendy.modelos.MetodoPago;
import com.example.Spendy.servicios.MetodoPagoServicio;

@RestController
@RequestMapping("/spendyapi/v1/metodosPago")
public class MetodoPagoControlador {

    @Autowired
    private MetodoPagoServicio servicio;

    // Guardar método de pago
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody MetodoPago datos){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(servicio.guardar(datos));
    }

    // Listar métodos de pago
    @GetMapping
    public ResponseEntity<?> listar(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(servicio.listar());
    }
}