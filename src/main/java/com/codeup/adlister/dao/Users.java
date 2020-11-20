package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    User findByEmail(String email);
    User findById(long id);
    public void updateUser(User user);

    long updateUsername(String username, long id);

    long updateEmail(String email, long id);

    long updatePassword(String password, long id);
}
