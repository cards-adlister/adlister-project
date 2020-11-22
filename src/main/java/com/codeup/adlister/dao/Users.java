package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    User findByEmail(String email);
    User findById(long id);

    void updateUser(User user);

    void updateUsername(String profile, String userId);

    void updatePassword(String password, String userId);

    void updateEmail(String newEmail, String userId);
}
