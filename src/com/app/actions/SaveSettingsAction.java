package com.app.actions;


import com.app.model.User;
import com.app.services.UserService;
import com.app.services.UserServiceImpl;
import com.app.util.AppConstants;

/**
 * Action class for changing user password
 *
 * @author Eugene Kurbatov
 */
public class SaveSettingsAction extends BaseAction {

    /**
     *  Current user password
     */
    private String password;

    /**
     * New user password
     */
    private String newPassword;

    /**
     * New user password retyped
     */
    private String retypePassword;

    private UserService userService = new UserServiceImpl();

    /**
     * Performs validation
     */
    @Override
    public void validate() {
        if (password == null || password.length() < AppConstants.PASSWORD_MIN_LENGTH) {
            addFieldError("password", String.format("Password: required (min length %s)",  AppConstants.PASSWORD_MIN_LENGTH));
        }

        if (newPassword == null || newPassword.length() <  AppConstants.PASSWORD_MIN_LENGTH) {
            addFieldError("newPassword", String.format("New password: required (min length %s)",  AppConstants.PASSWORD_MIN_LENGTH));
        }

        if (!newPassword.equals(retypePassword)) {
            addActionError("Retyped password is diffrent");
        }
    }

    /**
     * Logic of the action is executed
     *
     * @return a string representing the logical result of the execution
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        User user = (User) session.get(AppConstants.USER_SESSION_KEY);

        if (user == null) {
            addActionError("Internal error. Try again later");
            return INPUT;
        }

        if (!user.getPassword().equals(password)) {
            addActionError("Current password incorrect");
            return INPUT;
        }

        user.setPassword(newPassword);
        userService.updateUser(user.getId(), user);

        session.put(AppConstants.USER_SESSION_KEY, user);

        addActionMessage("Password successfully changed");

        return SUCCESS;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
