package com.example.Spendy.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spendy.modelos.MetodoPago;
import com.example.Spendy.servicios.MetodoPagoServicio;

@RestController
@RequestMapping("/spendy/v1/metodos-pago")
public class MetodoPagoControlador {

    // Inyectar el servicio correspondiente
    @Autowired
    private MetodoPagoServicio servicio;

    // Función controladora del servicio guardar método de pago
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody MetodoPago datos) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.guardar_metodoPago(datos));
    }

    // Función controladora del servicio listar todos los métodos de pago
    @GetMapping
    public ResponseEntity<?> controladorListarTodo() {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.listar_metodoPago());
    }

    // Función controladora del servicio buscar método de pago por id
    @GetMapping("/{id}")
    public ResponseEntity<?> controladorBuscar(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar_metodoPago(id));
    }

    // Función controladora del servicio actualizar método de pago por id
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorActualizar(@PathVariable Integer id, @RequestBody MetodoPago datos) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizar_metodoPago(id, datos));
    }

    // Función controladora del servicio eliminar método de pago por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(@PathVariable Integer id) {
        servicio.eliminar_metodoPago(id);
        return ResponseEntity.status(HttpStatus.OK).body("Método de pago eliminado correctamente");
    }
}