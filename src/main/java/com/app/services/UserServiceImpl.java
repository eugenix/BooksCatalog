package com.app.services;

import com.app.model.Book;
import com.app.model.User;
import com.app.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Implementation of book CRUD interface
 *
 * @author Eugene Kurbatov
 */
public class UserServiceImpl extends Book implements UserService {

    /**
     * BookService logger
     */
    private static final Logger log = Logger.getLogger(UserServiceImpl.class);

    /**
     * Find user by login
     *
     * @param login User login
     * @return User or null
     */
    @Override
    public User findByLoginAndPassword(String login, String password) {
        Session session = null;
        User user = null;
        try {
            session = HibernateUtil.getSession();
            List users = session.createCriteria(User.class)
                .add(Restrictions.eq("login", login))
                .add(Restrictions.eq("password", password))
                .setMaxResults(1)
                .list();

            if (!users.isEmpty())
                user = (User) users.get(0);

        } catch (Exception e) {
           log.error(e);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    /**
     * Update user record
     *
     * @param userId Identity of user
     * @param user New user object
     */
    @Override
    public void updateUser(long userId, User user) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();

            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
