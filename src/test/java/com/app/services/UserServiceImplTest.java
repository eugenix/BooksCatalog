package com.app.services;

import com.app.model.User;
import com.app.services.UserServiceImpl;

public class UserServiceImplTest extends BaseDBUnitTest {

    private UserServiceImpl service;

    public void setUp() throws Exception {
        super.setUp();
        service = new UserServiceImpl();
    }

    public UserServiceImplTest(String name) {
        super(name);
    }

    public void testFindByLoginAndPassword() throws Exception {

        User user = service.findByLoginAndPassword("admin", "password");
        assertNotNull(user);
        assertEquals("admin", user.getLogin());
        assertEquals("password", user.getPassword());

        assertNull(service.findByLoginAndPassword("admin", "invalid"));
        assertNull(service.findByLoginAndPassword("invalid", "password"));
        assertNull(service.findByLoginAndPassword(null, null));
    }

    public void testUpdateUser() throws Exception {
        User user = new User();

        user.setId(1);
        user.setLogin("new_login");
        user.setPassword("new_password");

        service.updateUser(1, user);

        User updatedUser = service.findByLoginAndPassword("new_login", "new_password");

        assertEquals("new_login", updatedUser.getLogin());
        assertEquals("new_password", updatedUser.getPassword());
        assertEquals(1, updatedUser.getId());
    }
}
