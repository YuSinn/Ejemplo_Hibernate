package com.gmail.alexandru.vladut.gabriel97.repositories;

import java.util.List;

public interface Repository <T>{
    //metodos abastractos para operaciones CRUD
    void save(T t);
    List<T> findAll();
    T findOneById(int id);
    void update(T t);
    void delete(T t);
}
