package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    User findByEmail(String email);
    User findById(long id);

    void updateUser(User user);

    void updateUsername(User profile);
    void updateEmail(User profile);
    void updatePassword(User profile);
}
