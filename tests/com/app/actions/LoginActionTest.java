package com.app.actions;


import com.app.model.User;
import com.app.services.UserService;
import com.app.util.AppConstants;
import com.opensymphony.xwork2.Action;
import junit.framework.TestCase;
import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import java.util.HashMap;

public class LoginActionTest extends MockObjectTestCase {

    public void testExecuteAction() throws Exception {
        LoginAction loginAction = new LoginAction();

        User user = new User();

        Mock service = new Mock(UserService.class);
        service.expects(once()).method("findByLoginAndPassword")
            .with(eq("admin"), eq("password"))
            .will(returnValue(user));

        loginAction.setUsername("admin");
        loginAction.setPassword("password");
        loginAction.setSession(new HashMap<String, Object>());
        loginAction.setUserService((UserService) service.proxy());

        assertEquals(Action.SUCCESS, loginAction.execute());
        assertEquals(user, loginAction.session.get(AppConstants.USER_SESSION_KEY));
        assertFalse(loginAction.hasActionErrors());

        service = new Mock(UserService.class);
        service.expects(once()).method("findByLoginAndPassword")
            .with(eq("admin"), eq("invalid"))
            .will(returnValue(null));

        loginAction.setUsername("admin");
        loginAction.setPassword("invalid");
        loginAction.setSession(new HashMap<String, Object>());
        loginAction.setUserService((UserService) service.proxy());

        assertEquals(Action.INPUT, loginAction.execute());
        assertEquals(null, loginAction.session.get(AppConstants.USER_SESSION_KEY));
        assertTrue(loginAction.hasActionErrors());
    }
}
