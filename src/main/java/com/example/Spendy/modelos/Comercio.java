package com.example.Spendy.modelos;


import java.util.List;

import com.example.Spendy.modelos.utils.TipoComercio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "comercios")

public class Comercio {

    //id,nit,nombre,actividad,contacto(correo)
    //telefono, 


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id; 
    @Column(name="nit", nullable = false, unique = true, length = 15)
    private String nit;

    @Column(name = "nombre", nullable = false, unique = false, length = 50)
    private String nombre;

    @Column(name="actividad", nullable = false, unique = false, length = 50)
    private String actividad;

    @Column(name="correo", nullable = false, unique = true, length = 100)
    private String correo;

    @Column(name="telefono", nullable = false, unique = true, length = 20)
    private String telefono;

    @Column(name="tipo_comercio", nullable = false, unique = false, length = 50)
    @Enumerated(EnumType.STRING)
    private TipoComercio tipoComercio;

    @Column(name="direccion", nullable = false, unique = false, length = 100)
    private String direccion;

    @Column(name="url", nullable = true, unique = false, length = 200)
    private String url;

    @Column(name="descripcion", nullable = true, unique = false, length = 500)
    private String descripcion; // Que vende o que servicios ofrece


    //Relacion 1 comercio con muchos gastos

    @OneToMany(mappedBy="usuario")
    private List <Gasto> gastos;


    public Comercio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

   public TipoComercio getTipoComercio() {
    return tipoComercio;
}

   public void setTipoComercio(TipoComercio tipoComercio) {
    this.tipoComercio = tipoComercio;
}

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

}
