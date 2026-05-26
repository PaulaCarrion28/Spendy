package com.example.Spendy.controladores;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spendy.modelos.Usuario;
import com.example.Spendy.servicios.UsuarioServicio;

@RestController
@RequestMapping("/spendyapi/v1/usuarios")

@CrossOrigin(origins = "http://localhost:5173")

public class UsuarioControlador {

    @Autowired
    private UsuarioServicio servicio;

    // GUARDAR USUARIO
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Usuario datos) {

        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_usuario(datos)
        );
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> controladorLogin(
            @RequestBody Map<String, String> credenciales
    ) {

        String correo = credenciales.get("correo");
        String contraseña = credenciales.get("contraseña");

        Usuario usuario = servicio.login(correo, contraseña);

        if (usuario != null) {

            return ResponseEntity.status(HttpStatus.OK)
                    .body(usuario);

        } else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(
                        Map.of(
                            "mensaje",
                            "Correo o contraseña incorrectos"
                        )
                    );
        }
    }

    // LISTAR USUARIOS
    @GetMapping
    public ResponseEntity<?> contraladorListarTodo() {

        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_Usuarios()
        );
    }
}