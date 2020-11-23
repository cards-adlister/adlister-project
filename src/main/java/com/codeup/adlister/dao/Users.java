package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
<<<<<<< HEAD
    User findByEmail(String email);
    User findById(long id);

    void updateUser(User user);

    void updateUsername(String profile, String userId);

    void updatePassword(String password, String userId);

    void updateEmail(String newEmail, String userId);
=======
>>>>>>> fc613a62857fe205549cf62f1a48c67d349cadc5
}
