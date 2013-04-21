package com.app.actions;

import com.app.actions.SaveSettingsAction;
import com.app.model.User;
import com.app.services.UserService;
import com.app.util.AppConstants;
import com.opensymphony.xwork2.Action;
import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import java.util.HashMap;
import java.util.Map;

public class SaveSettingsActionTest extends MockObjectTestCase {

    public void testExecute() throws Exception {
        SaveSettingsAction saveSettingsAction = new SaveSettingsAction() {
            @Override
            public String getText(String textName) {
                return "mocked";
            }
        };

        User user = new User();
        user.setId(1);
        user.setPassword("password");

        Map<String, Object> session = new HashMap<>();
        session.put(AppConstants.USER_SESSION_KEY, user);

        Mock service = new Mock(UserService.class);
        service.expects(once()).method("updateUser")
            .with(eq(1L), eq(user));

        saveSettingsAction.setUserService((UserService) service.proxy());
        saveSettingsAction.setSession(session);

        saveSettingsAction.setPassword("password");
        saveSettingsAction.setNewPassword("new");
        saveSettingsAction.setRetypePassword("new");

        assertEquals(Action.SUCCESS, saveSettingsAction.execute());
        assertFalse(saveSettingsAction.hasErrors());
    }

}
