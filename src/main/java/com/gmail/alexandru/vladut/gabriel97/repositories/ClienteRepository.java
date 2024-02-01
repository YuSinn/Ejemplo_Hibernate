package com.gmail.alexandru.vladut.gabriel97.repositories;


import com.gmail.alexandru.vladut.gabriel97.entities.Cliente;
import org.hibernate.Session;

import java.util.List;

public class ClienteRepository implements Repository<Cliente>{
    private final Session session;

    public ClienteRepository(Session session){
        this.session=session;
    }
    @Override
    public void save(Cliente cliente) {
        session.beginTransaction();
        session.persist(cliente);
        session.getTransaction().commit();
    }

    @Override
    public List<Cliente> findAll() {
        return session.createQuery("FROM cliente",Cliente.class).getResultList();
    }

    @Override
    public Cliente findOneById(int id) {
        return null;
    }

    public Cliente findOneById(String id) {
        return null;
    }
    @Override
    public void update(Cliente cliente) {

    }

    @Override
    public void delete(Cliente cliente) {

    }
}
