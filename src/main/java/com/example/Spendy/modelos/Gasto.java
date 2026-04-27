package com.example.Spendy.modelos;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "gastos")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private LocalDate fecha;
    private Double valor;
    private String icono;
    private Boolean esNecesario;
    private String ubicacion;

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    //Yo como gasto me relaciono con muchos gastos
    @ManyToOne
    @JoinColumn(name = "fk_comercio")
    private Comercio comercio;

    @ManyToOne
    @JoinColumn(name = "fk_metodo_pago")
    private MetodoPago metodoPago;

    @OneToMany(mappedBy = "gasto")
    private List<Categoria> categorias;

    public Gasto() {}

    public Gasto(Long id, String descripcion, LocalDate fecha, Double valor,
                 String icono, Boolean esNecesario, String ubicacion,
                 Usuario usuario, Comercio comercio, MetodoPago metodoPago) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.valor = valor;
        this.icono = icono;
        this.esNecesario = esNecesario;
        this.ubicacion = ubicacion;
        this.usuario = usuario;
        this.comercio = comercio;
        this.metodoPago = metodoPago;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
    public String getIcono() { return icono; }
    public void setIcono(String icono) { this.icono = icono; }
    public Boolean getEsNecesario() { return esNecesario; }
    public void setEsNecesario(Boolean esNecesario) { this.esNecesario = esNecesario; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Comercio getComercio() { return comercio; }
    public void setComercio(Comercio comercio) { this.comercio = comercio; }
    public MetodoPago getMetodoPago() { return metodoPago; }
    public void setMetodoPago(MetodoPago metodoPago) { this.metodoPago = metodoPago; }
    public List<Categoria> getCategorias() { return categorias; }
    public void setCategorias(List<Categoria> categorias) { this.categorias = categorias; }
}