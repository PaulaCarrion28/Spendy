package com.example.Spendy.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spendy.modelos.Usuario;
import com.example.Spendy.servicios.UsuarioServicio;

@RestController
@RequestMapping("/spendyapi/v1/usuarios")//Bautiza los servicios

public class UsuarioControlador {

    //Inyectar el servicio correspondiente

    @Autowired
    private UsuarioServicio servicio;

    //Para cada servicio ofrecido se debe programar una funcion
    //esa función recibirá las peticiones del pedido y responderá 


    //La funcion controladora del servicio de guardar usuario 

@PostMapping
public ResponseEntity<?> controladorGuardar(@RequestBody Usuario datos){
return ResponseEntity.status(HttpStatus.OK).body(
    servicio.guardar_usuario(datos)
);
}


    //la función controladora del servicio de listar los usuaurios

    @GetMapping
    public ResponseEntity<?>contraladorListarTodo(){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_Usuarios()
        );
    }




}
