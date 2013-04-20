package com.app.actions;

import com.app.model.User;
import com.app.services.UserService;
import com.app.services.UserServiceImpl;
import com.app.util.AppConstants;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import org.apache.struts2.interceptor.SessionAware;

/**
 * Action class performs user authentication
 *
 * @author Eugene Kurbatov
 */
public class LoginAction extends BaseAction implements SessionAware {

    /**
     * Name of user, login
     */
    private String username;

    /**
     * Password of user
     */
    private String password;

    private UserService userService = new UserServiceImpl();

    /**
     * Logic of the action is executed
     *
     * @return a string representing the logical result of the execution
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        User user = userService.findByLoginAndPassword(username, password);

        if (user == null) {
            addActionError("Incorrect login or password");
            return INPUT;
        }

        session.put(AppConstants.USER_SESSION_KEY, user);

        return SUCCESS;
    }

    @RequiredStringValidator(message = "Login required")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @RequiredStringValidator(message = "Password required")
    public void setPassword(String password) {
        this.password = password;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
