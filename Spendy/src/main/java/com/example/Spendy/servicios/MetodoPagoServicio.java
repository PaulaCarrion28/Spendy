package com.example.Spendy.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Spendy.modelos.MetodoPago;
import com.example.Spendy.repositorios.IMetodoPagoRepositorio;

@Service
public class MetodoPagoServicio {

    // Conectar dependencias con @Autowired
    @Autowired
    private IMetodoPagoRepositorio repositorio;

    // Servicio para guardar un método de pago
    public MetodoPago guardar_metodoPago(MetodoPago datosMetodoPago) {
        // Validar que el nombre no sea nulo ni vacío
        if (datosMetodoPago.getNombre() == null || datosMetodoPago.getNombre().isBlank() || datosMetodoPago.getNombre().isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del método de pago es obligatorio, revisa por favor"
            );
        }
        // Validar que la franquicia no sea nula ni vacía
        if (datosMetodoPago.getFranquicia() == null || datosMetodoPago.getFranquicia().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La franquicia del método de pago es obligatoria, revisa por favor"
            );
        }
        // Después de las validaciones intento guardar los datos que me enviaron
        return repositorio.save(datosMetodoPago);
    }

    // Servicio para listar todos los métodos de pago en la BD
    public List<MetodoPago> listar_metodoPago() {
        return repositorio.findAll();
    }

    // Servicio para buscar un método de pago por su id
    public MetodoPago buscar_metodoPago(Integer id) {
        return repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "No se encontró el método de pago con id: " + id
            ));
    }

    // Servicio para actualizar un método de pago por su id
    public MetodoPago actualizar_metodoPago(Integer id, MetodoPago nuevosDatos) {
        MetodoPago existente = repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "No se encontró el método de pago con id: " + id
            ));

        // Validar que el nombre no sea nulo ni vacío
        if (nuevosDatos.getNombre() == null || nuevosDatos.getNombre().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del método de pago es obligatorio, revisa por favor"
            );
        }

        existente.setNombre(nuevosDatos.getNombre());
        existente.setFranquicia(nuevosDatos.getFranquicia());
        existente.setEstado(nuevosDatos.isEstado());
        existente.setDescripcion(nuevosDatos.getDescripcion());

        return repositorio.save(existente);
    }

    // Servicio para eliminar un método de pago por su id
    public void eliminar_metodoPago(Integer id) {
        if (!repositorio.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "No se encontró el método de pago con id: " + id
            );
        }
        repositorio.deleteById(id);
    }
}