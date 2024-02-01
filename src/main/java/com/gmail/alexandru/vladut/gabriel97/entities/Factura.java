package com.gmail.alexandru.vladut.gabriel97.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "facturas_cliente")
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numFactura;
    private double importe;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "num_factura")
    List<LineasFactura> lineasFactura = new ArrayList<>();
    public Factura(int numFactura, double importe) {
        this.numFactura = numFactura;
        this.importe = importe;
    }

    public Factura() {
    }

    public Factura(double importe) {
        this.importe = importe;
    }
    public void addLineaFactura(LineasFactura lFactura) {
        if( lineasFactura == null)
            lineasFactura = new ArrayList<>();

        lineasFactura.add(lFactura);
    }
    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "numFactura=" + numFactura +
                ", importe=" + importe +
                '}';
    }


}
