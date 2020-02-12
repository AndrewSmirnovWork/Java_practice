package ru.werdna.dao;

import java.util.List;
import java.util.Optional;

//create redit update delete
public interface CrudDao<T> {

    Optional<T> find(Integer id);

    void save(T model);

    void update(T model);

    void delete(Integer id);

    List<T> findAll();


}
