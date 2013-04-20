package com.app.actions;

import com.app.model.User;
import com.app.util.AppConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Action class, login page
 *
 * @author Eugene Kurbatov
 */
public class IndexAction extends BaseAction {

    /**
     * Logic of the action is executed
     *
     * @return a string representing the logical result of the execution
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        User user = (User) session.get(AppConstants.USER_SESSION_KEY);
        if (user != null) {
            return BaseAction.HOME;
        }

        return SUCCESS;
    }


}
