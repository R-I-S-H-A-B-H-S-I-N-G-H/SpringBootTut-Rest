package com.example.Rest.user.UserV2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserV2DaoServices {
    private static List<Userv2> users = new ArrayList<>();
    static {
        users.add(new Userv2(1, "Adam", "DKJK", LocalDate.now().minusYears(100)));
        users.add(new Userv2(2, "Eve", "dfgfd", LocalDate.now().minusYears(100)));
        users.add(new Userv2(3, "Jim", "erwr", LocalDate.now().minusYears(10)));
    }

    public List<Userv2> findAll() {
        return users;
    }

    public Userv2 findById(int id) {
        for (Userv2 itr : users)
            if (id == itr.getId())
                return itr;
        return null;
    }

    public Userv2 createUser(Userv2 user) {
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        users.removeIf((Userv2 user) -> user.getId().equals(id));
    }
}
