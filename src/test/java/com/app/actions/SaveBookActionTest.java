package com.app.actions;

import com.app.actions.SaveBookAction;
import com.app.model.Book;
import com.app.services.BookService;
import com.opensymphony.xwork2.Action;
import org.jmock.Mock;
import org.jmock.MockObjectTestCase;


public class SaveBookActionTest extends MockObjectTestCase {
    public void testExecute() throws Exception {

        Book book = new Book();

        Mock service = new Mock(BookService.class);
        service.expects(once()).method("saveOrUpdate").with(eq(book));

        SaveBookAction saveBookAction = new SaveBookAction() {
            @Override
            public String getText(String textName) {
                return "mocked";
            }
        };
        saveBookAction.setBook(book);

        saveBookAction.setBookService((BookService) service.proxy());

        assertEquals(Action.SUCCESS, saveBookAction.execute());
    }

    public void testValidate() throws Exception {
        Book book = new Book();
        book.setIsbn("");

        SaveBookAction saveBookAction = new SaveBookAction() {
            @Override
            public String getText(String textName) {
                return "mocked";
            }
        };
        saveBookAction.setBook(book);

        saveBookAction.validate();
        assertTrue(saveBookAction.hasErrors());

        book.setIsbn("1234567890");
        saveBookAction = new SaveBookAction();
        saveBookAction.setBook(book);

        saveBookAction.validate();
        assertFalse(saveBookAction.hasErrors());
    }
}
