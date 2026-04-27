package com.example.Spendy.modelos;

import java.time.LocalDate;

import com.example.Spendy.modelos.utils.Estado;
import com.example.Spendy.modelos.utils.Prioridad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
//las anotaciones se copian encima donde quiero dar funcionalidad

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

 // anotación de Springboot para poder crear una tabla de base de datos 
 @Entity

 // asigna nombre a la tabla 
 @Table(name = "categoria")
 //Crear llaves primarias (UUAD)

public class Categoria {
    //Para especificar cuál será la primary key de la tabla
    @Id
    //Para decirle que la base de datos se va a encargar de generar el ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)  

    //Utilizar snake_case por convención para nombrar los campos de la BD (Ejemplo -> base_de_datos)
    private Integer id;
    @Column(name = "nombre", nullable = false, unique = false, length = 50)
    private String nombre; 
    @Column(name = "fecha_creacion", nullable = false, unique = false)
    private LocalDate fechaCreacion;
    @Column(name = "responsable", nullable = false, unique = false, length = 50)
    private String responsable;
    @Column(name = "edad", nullable = false, unique = false)
    private Integer edad;
    @Column(name = "justifiacion", nullable = true, unique = false)
    private String justificacion;

    // Nuevos atributos
    @Column()
    private double presupuestoAsignado;
    @Column(name = "presupuesto_asignado", nullable = false, unique = false)
    private Double montoGastado;
    @Column(name = "estado_gasto", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Column(name = "prioridad", nullable = false, unique = false)
    @Enumerated (EnumType.STRING)
    private Prioridad prioridad;
    @Column(name = "tipo", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)

    //Creando una relación con el modelo Gasto
    @ManyToOne
    @JoinColumn(name = "fk_gasto", referencedColumnName = "id")
    private Gasto gasto;

    private String tipo; //→ Define si la categoría es fija, variable, ocasional, etc
    public Categoria(Integer id, String nombre, LocalDate fechaCreacion, String responsable, Integer edad,
            String justificacion, double presupuestoAsignado, Double montoGastado, Estado estado, Prioridad prioridad,
            String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.responsable = responsable;
        this.edad = edad;
        this.justificacion = justificacion;
        
        this.presupuestoAsignado = presupuestoAsignado;
        this.estado = estado;
        this.prioridad = prioridad;
        this.tipo = tipo;
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
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getResponsable() {
        return responsable;
    }
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public String getJustificacion() {
        return justificacion;
    }
    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }
    
    public double getPresupuestoAsignado() {
        return presupuestoAsignado;
    }
    public void setPresupuestoAsignado(double presupuestoAsignado) {
        this.presupuestoAsignado = presupuestoAsignado;
    }
    public Double getMontoGastado() {
        return montoGastado;
    }
    public void setMontoGastado(Double montoGastado) {
        this.montoGastado = montoGastado;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public Prioridad getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}







