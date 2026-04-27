package com.example.Spendy.modelos;

import java.util.List;

import com.example.Spendy.modelos.utils.Genero;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.EnumType;

import com.example.Spendy.modelos.utils.TipoDocumento;

@Entity  // Esta clase Java representa una tabla en la base de datos
@Table(name = "usuarios")  // Especifica el nombre de la tabla en la base de datos

public class Usuario {
 //id,nombres,tipodoc,documento,edad
 // Correo, telefono, salario, genero, contraseña

@Id // Indica que este campo es la clave primaria de la tabla
@GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que el valor de este campo se generará automáticamente por la base de datos


private Integer id;
@Column(name = "nombres", nullable= false, unique = false, length =50)
private String nombres;


@Column(name="tipo_documento", nullable = false, unique = false)
@Enumerated (EnumType.STRING)
private TipoDocumento tipoDocumento; 


@Column(name= "documento", nullable = false, unique = true, length =15)
private String documento;


@Column(name="edad", nullable = false, unique = false, length = 50)
private Integer edad;

@Column(name= "correo", nullable = false, unique = true, length = 100)
private String correo;

@Column(name = "telefono", nullable = false, unique = true, length = 20)
private String telefono;   

@Column(name="salario", nullable = false, unique = false)
private Double salario;

@Column(name ="genero", nullable = false, unique = false)
@Enumerated(EnumType.STRING)
private Genero genero;

@Column(name = "contraseña", nullable = false, unique = true, length = 20)
private String contraseña;

//creando una relación con el modelo Gasto

//Yo como usuario me relaciono con muchos gastos 

@OneToMany(mappedBy="usuario")
private List <Gasto> gastos;


//Yo como usuario me relaciono con muchos metodos de pago 
@OneToMany(mappedBy="usuario")
private List <MetodoPago> metodoPagos;


public Usuario() {
}


// Getters y Setters

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getNombres() {
    return nombres;
}

public void setNombres(String nombres) {
    this.nombres = nombres;
}


public String getDocumento() {
    return documento;
}


public void setDocumento(String documento) {
    this.documento = documento;
}

public Integer getEdad() {
    return edad;
}

public void setEdad(Integer edad) {
    this.edad = edad;
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

public Double getSalario() {
    return salario;
}

public void setSalario(Double salario) {
    this.salario = salario;
}

public Genero getGenero() {
    return genero;
}

public void setGenero(Genero genero) {
    this.genero = genero;
}

public String getContraseña() {
    return contraseña;
}

public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
}

public TipoDocumento getTipoDocumento() {
    return tipoDocumento;
}

public void setTipoDocumento(TipoDocumento tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
}


}
