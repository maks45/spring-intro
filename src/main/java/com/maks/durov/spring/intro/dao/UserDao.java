package com.maks.durov.spring.intro.dao;

import com.maks.durov.spring.intro.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getAllUsers();

    User getById(Long id);
}
