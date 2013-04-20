package com.app.actions;

import com.app.model.Book;
import com.app.services.BookService;
import com.opensymphony.xwork2.Action;
import org.jmock.Mock;
import org.jmock.MockObjectTestCase;


public class BookActionTest extends MockObjectTestCase {

    public void testExecuteAction() throws Exception {

        Book book = new Book();

        Mock service = new Mock(BookService.class);
        service.expects(once()).method("findById")
            .with(eq(1))
            .will(returnValue(book));

        BookAction bookAction = new BookAction();
        bookAction.setBookId(1);
        bookAction.setBookService((BookService)service.proxy());

        assertEquals(Action.SUCCESS, bookAction.execute());
        service.verify();

        service.expects(once()).method("findById")
            .with(eq(0))
            .will(returnValue(null));

        bookAction.setBookId(0);
        assertEquals(Action.INPUT, bookAction.execute());
    }
}
