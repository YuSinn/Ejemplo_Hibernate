package com.gmail.alexandru.vladut.gabriel97.entities;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class DatosCliente implements Serializable {
    @Id
    @Column(name = "id_datos_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDatosCliente;
    private String direccion;
    @Column(name = "fact_anual")
    private double factAnual;
    private short antig;

    public DatosCliente() {
    }

    public DatosCliente(int idDatosCliente, String direccion, double factAnual, short antig) {
        this.idDatosCliente = idDatosCliente;
        this.direccion = direccion;
        this.factAnual = factAnual;
        this.antig = antig;
    }

    public DatosCliente(String direccion, double factAnual, short antig) {
        this.direccion = direccion;
        this.factAnual = factAnual;
        this.antig = antig;
    }

    public int getIdDatosCliente() {
        return idDatosCliente;
    }

    public void setIdDatosCliente(int idDatosCliente) {
        this.idDatosCliente = idDatosCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getFactAnual() {
        return factAnual;
    }

    public void setFactAnual(double factAnual) {
        this.factAnual = factAnual;
    }

    public short getAntig() {
        return antig;
    }

    public void setAntig(short antig) {
        this.antig = antig;
    }

    @Override
    public String toString() {
        return "DatosCliente{" +
                "idDatosCliente=" + idDatosCliente +
                ", direccion='" + direccion + '\'' +
                ", factAnual=" + factAnual +
                ", antig=" + antig +
                '}';
    }
}
