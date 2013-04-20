package com.app.actions;


import com.opensymphony.xwork2.Action;
import org.apache.struts2.StrutsTestCase;

public class AddBookActionTest extends StrutsTestCase {

    public void testExecuteAction() throws Exception {

        AddBookAction addBookAction = new AddBookAction();
        assertEquals(Action.SUCCESS, addBookAction.execute());
    }
}
