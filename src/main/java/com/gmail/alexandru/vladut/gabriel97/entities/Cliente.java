package com.gmail.alexandru.vladut.gabriel97.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "cliente")
public class Cliente implements Serializable {
    @Id
    @Column(name = "dniCliente")
    private String dni;
    @Column(length = 40)
    private String apellidos;
    @Column(length = 40)
    private String nombre;

    public Cliente(String dni, String apellidos, String nombre, DatosCliente datosCliente, List<Factura> facturas) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.datosCliente = datosCliente;
        this.facturas = facturas;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_datos_cliente")
    DatosCliente datosCliente;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="dni_cliente")
    List<Factura> facturas = new  ArrayList<>();
    public Cliente(){
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DatosCliente getDatosCliente() {
        return datosCliente;
    }

    public void setDatosCliente(DatosCliente datosCliente) {
        this.datosCliente = datosCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public void addFactura(Factura factura){
        if(facturas==null){
            facturas = new ArrayList<>();
        }
        this.facturas.add(factura);
    }
}
