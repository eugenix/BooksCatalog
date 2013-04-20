package com.app.services;

import com.app.model.User;

/**
 * User CRUD interface
 *
 * @author Eugene Kurbatov
 */
public interface UserService {

    /**
     * Find user by login
     *
     * @param login User login
     * @return User or null
     */
    public User findByLoginAndPassword(String login, String password);

    /**
     * Update user record
     *
     * @param userId Identity of user
     * @param user New user object
     */
    public void updateUser(long userId, User user);

}
