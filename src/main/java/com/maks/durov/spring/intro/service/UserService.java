package com.maks.durov.spring.intro.service;

import com.maks.durov.spring.intro.model.User;
import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
