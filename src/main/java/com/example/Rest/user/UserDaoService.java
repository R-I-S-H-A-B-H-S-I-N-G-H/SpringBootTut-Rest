package com.example.Rest.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(100)));
        users.add(new User(2, "Eve", LocalDate.now().minusYears(100)));
        users.add(new User(3, "Jim", LocalDate.now().minusYears(10)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        for (User itr : users)
            if (id == itr.getId())
                return itr;
        return null;
    }

    public User createUser(User user) {
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
