package com.gmail.alexandru.vladut.gabriel97;

import com.gmail.alexandru.vladut.gabriel97.repositories.ClienteRepository;
import org.hibernate.Session;

public class MainRep {
    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            ClienteRepository clienteRepository = new ClienteRepository(session);

            System.out.println("Listado de todos los clientes");

            clienteRepository.findAll().forEach(System.out::println);
        }

    }
}
