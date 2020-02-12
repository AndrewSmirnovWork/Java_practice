package ru.werdna.fake;

import ru.werdna.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Singltone

public class FakeStorage {
    private static final FakeStorage storage;
    static
    {
        storage = new FakeStorage();
    }
    private List<User> users;

    private FakeStorage() {
        this.users = new ArrayList<>();

        this.users = new ArrayList<>();
        User user = new User("Andrew", "123", LocalDate.parse("1993-01-22"));
        User user2 = new User("Andrew", "123", LocalDate.parse("1993-01-22"));
        User user3 = new User("Andrew", "123", LocalDate.parse("1993-01-22"));
        users.add(user);
        users.add(user2);
        users.add(user3);
    }

    public static FakeStorage storage() {
        return storage;
    }

    public List<User> users() {
        return users;
    }
}
