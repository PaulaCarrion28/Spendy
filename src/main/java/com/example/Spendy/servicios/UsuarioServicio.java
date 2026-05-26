package com.example.Spendy.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Spendy.modelos.Usuario;
import com.example.Spendy.repositorios.IUsuarioRepositorio;

@Service
public class UsuarioServicio {

    @Autowired
    private IUsuarioRepositorio repositorio;

    // Servicio para guardar un usuario
    public Usuario guardar_usuario(Usuario datosUsuario) {

        if (datosUsuario.getNombres() == null || datosUsuario.getNombres().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre es obligatorio");
        }

        if (datosUsuario.getDocumento() == null || datosUsuario.getDocumento().length() < 5) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El documento debe tener al menos 5 caracteres");
        }

        if (datosUsuario.getCorreo() == null || datosUsuario.getCorreo().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo es obligatorio");
        }

        if (datosUsuario.getContraseña() == null || datosUsuario.getContraseña().length() < 6) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La contraseña debe tener al menos 6 caracteres");
        }

        if (datosUsuario.getTelefono() == null || datosUsuario.getTelefono().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El teléfono es obligatorio");
        }

        if (datosUsuario.getEdad() == null || datosUsuario.getEdad() < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La edad es obligatoria");
        }

        if (datosUsuario.getSalario() == null || datosUsuario.getSalario() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El salario es obligatorio");
        }

        // Verificar si el correo ya está registrado
        boolean correoExiste = repositorio.findAll()
            .stream()
            .anyMatch(u -> u.getCorreo().equals(datosUsuario.getCorreo()));
        if (correoExiste) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe una cuenta con ese correo");
        }

        // Verificar si el documento ya está registrado
        if (repositorio.findByDocumento(datosUsuario.getDocumento()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe una cuenta con ese documento");
        }

        return repositorio.save(datosUsuario);
    }

    // Servicio para listar todos los usuarios
    public List<Usuario> listar_Usuarios() {
        return repositorio.findAll();
    }

    // Servicio para login
    public Usuario login(String correo, String contraseña) {
        return repositorio.findByCorreoAndContraseña(correo, contraseña)
            .orElse(null);
    }
}