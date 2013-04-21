package com.app.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Base class for actions
 *
 * @author Eugene Kurbatov
 */
abstract public class BaseAction extends ActionSupport implements SessionAware {

    /**
     * Logical result for home page
     */
    public static final String HOME = "home";

    /**
     * Map of session attributes
     */
    public Map<String, Object> session;

    /**
     * Sets the Map of session attributes
     *
     * @param session map of session
     */
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * Get current action name
     *
     * @return action name
     */
    public String getActionName() {
        return ActionContext.getContext().getName();
    }
}
