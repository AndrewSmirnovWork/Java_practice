package ru.werdna.repositories;

import ru.werdna.fake.FakeStorage;
import ru.werdna.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryInMemoryImpl implements UsersRepository {

    @Override
    public void save(User user) {
        FakeStorage.storage().users().add(user);
    }

    public List<User> findAll() {
        return FakeStorage.storage().users();
    }

    @Override
    public boolean isExist(String name, String password) {
        for (User user : FakeStorage.storage().users()) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
