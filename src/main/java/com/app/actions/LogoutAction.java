package com.app.actions;

/**
 * Logout action
 *
 * @author Eugene Kurbatov
 */
public class LogoutAction extends BaseAction {

    /**
     * Logic of the action is executed
     *
     * @return a string representing the logical result of the execution
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        if (session != null) {
            session.clear();
        }
        return SUCCESS;
    }
}
