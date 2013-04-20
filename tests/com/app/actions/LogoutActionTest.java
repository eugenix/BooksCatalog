package com.app.actions;

import com.opensymphony.xwork2.Action;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;


public class LogoutActionTest extends TestCase {
    public void testExecute() throws Exception {

        LogoutAction logoutAction = new LogoutAction();
        logoutAction.setSession(new HashMap<String, Object>());

        assertEquals(Action.SUCCESS, logoutAction.execute());
        assertTrue(logoutAction.session.isEmpty());
    }
}
