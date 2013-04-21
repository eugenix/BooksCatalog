package com.app.util;

import com.app.actions.BaseAction;
import com.app.model.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

/**
 * Implements authentication login in application
 *
 * @author Eugene Kurbatov
 */
public class AuthenticationInterceptor extends AbstractInterceptor {

    /**
     * Allows the Interceptor to do some processing on the request before and/or after the rest
     * of the processing of the request by the ActionInvocation or to short-circuit
     * the processing and just return a String return code.
     *
     * @param actionInvocation represents the execution state of an Action
     * @return the return code, either returned from ActionInvocation.invoke(), or from the interceptor itself.
     * @throws Exception
     */
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        Map session = actionInvocation.getInvocationContext().getSession();
        User user = (User) session.get(AppConstants.USER_SESSION_KEY);
        if (user == null) {
            return BaseAction.LOGIN;
        }
        else {
            return actionInvocation.invoke();
        }
    }
}
