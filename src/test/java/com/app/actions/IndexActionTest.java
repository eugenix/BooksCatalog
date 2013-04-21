package com.app.actions;


import com.app.actions.IndexAction;
import com.app.model.User;
import com.app.util.AppConstants;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class IndexActionTest extends TestCase {
    public void testExecuteAction() throws Exception {

        Map<String, Object> session = new HashMap<>();

        IndexAction indexAction = new IndexAction();
        indexAction.setSession(session);

        assertEquals(IndexAction.SUCCESS, indexAction.execute());

        session.put(AppConstants.USER_SESSION_KEY, new User());
        indexAction.setSession(session);

        assertEquals(IndexAction.HOME, indexAction.execute());
    }
}
