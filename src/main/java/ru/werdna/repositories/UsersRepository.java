package ru.werdna.repositories;

import ru.werdna.models.User;

import java.util.List;

public interface UsersRepository {

    void save(User user);

    List<User> findAll();

    boolean isExist(String name, String password);
}
