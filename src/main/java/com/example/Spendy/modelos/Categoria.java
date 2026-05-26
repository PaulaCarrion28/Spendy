package com.example.Spendy.modelos;

import java.time.LocalDate;

import com.example.Spendy.modelos.utils.Estado;
import com.example.Spendy.modelos.utils.Prioridad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")

public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @Column(name = "responsable", nullable = false, length = 50)
    private String responsable;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "justificacion")
    private String justificacion;

    @Column(name = "presupuesto_asignado", nullable = false)
    private double presupuestoAsignado;

    @Column(name = "monto_gastado", nullable = false)
    private Double montoGastado;

    @Column(name = "estado_gasto", nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "prioridad", nullable = false)
    @Enumerated(EnumType.STRING)
    private Prioridad prioridad;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    // Relación Muchas categorías -> 1 gasto
    @ManyToOne
    @JoinColumn(name = "gasto_id")
    private Gasto gasto;

    // Constructor vacío requerido por JPA
    public Categoria() {
    }

    public Categoria(Integer id, String nombre, LocalDate fechaCreacion, String responsable,
                     Integer edad, String justificacion, double presupuestoAsignado,
                     Double montoGastado, Estado estado, Prioridad prioridad,
                     String tipo, Gasto gasto) {

        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.responsable = responsable;
        this.edad = edad;
        this.justificacion = justificacion;
        this.presupuestoAsignado = presupuestoAsignado;
        this.montoGastado = montoGastado;
        this.estado = estado;
        this.prioridad = prioridad;
        this.tipo = tipo;
        this.gasto = gasto;
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

    public Gasto getGasto() {
        return gasto;
    }

    public void setGasto(Gasto gasto) {
        this.gasto = gasto;
    }
}