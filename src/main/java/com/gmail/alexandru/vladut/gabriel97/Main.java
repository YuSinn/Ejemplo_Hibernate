package com.gmail.alexandru.vladut.gabriel97;

import com.gmail.alexandru.vladut.gabriel97.entities.Cliente;
import com.gmail.alexandru.vladut.gabriel97.entities.DatosCliente;
import com.gmail.alexandru.vladut.gabriel97.entities.Factura;
import com.gmail.alexandru.vladut.gabriel97.entities.LineasFactura;
import org.hibernate.Session;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Probando conexion...");
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            System.out.println("Conexion establecida!!!");

            DatosCliente datosCliente = new DatosCliente("Madrid",250.0, (short) 10);
            DatosCliente datosCliente2 = new DatosCliente("Madrid",350.0, (short) 10);
            Cliente cliente1 = new Cliente("278638628g","Alexandru","Vlad",datosCliente,null);
            Cliente cliente2 = new Cliente("278aa8628g","Giulia","Armano",datosCliente2,null);

            Factura factura1 = new Factura(200);
            Factura factura2 = new Factura(100);
            Factura factura3 = new Factura(50);

            LineasFactura lf1 = new LineasFactura("Patatas", 78.0);
            LineasFactura lf2 = new LineasFactura("Peras", 728.20);
            LineasFactura lf3 = new LineasFactura("Platanos", 1888.345);

            factura1.addLineaFactura(lf1);
            factura1.addLineaFactura(lf2);
            factura2.addLineaFactura(lf3);

            cliente1.addFactura(factura1);
            cliente1.addFactura(factura2);
            cliente2.addFactura(factura3);

            session.beginTransaction();
            session.persist(cliente1);
            session.persist(cliente2);

            cliente1.getFacturas().remove(factura1);
            session.remove(factura1);
            session.getTransaction().commit();



        }catch (Exception e){
            System.err.println("No se ha podido conectar a la BBDD");
            e.printStackTrace();
        }
    }
    static void insertaCliente(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            //probar la relacion 1 a 1 entre cliente y datos cliente
            //creamos 2 clientes y hibernate se encargara de hacerlos persistentes en la BBDD

            //Cliente cliente1 = new Cliente("278638628g","Alexandru","Vlad",2345);
        };
    }
}