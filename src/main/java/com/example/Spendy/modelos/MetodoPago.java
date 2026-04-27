package com.example.Spendy.modelos;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "metodos_pago") // Define el nombre de la tabla en la Bd 

public class MetodoPago {

    //id, nombre, franquicia, estado(activo/inactivo), descripcion

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id; 
    private String nombre; 
    private String franquicia; 
    private boolean estado;
    private String descripcion;
    

    @ManyToAny
    @JoinColumn(name = "fk_usuario", referencedColumnName="id")
    private Usuario usuario;
    
    public MetodoPago() {
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFranquicia() {
        return franquicia;
    }
    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

}
