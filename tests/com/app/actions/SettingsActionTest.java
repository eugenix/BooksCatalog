package com.app.actions;

import com.opensymphony.xwork2.Action;
import junit.framework.TestCase;


public class SettingsActionTest extends TestCase {
    public void testExecuteAction() throws Exception {

        SettingsAction settingsAction = new SettingsAction();
        assertEquals(Action.SUCCESS, settingsAction.execute());
    }
}
