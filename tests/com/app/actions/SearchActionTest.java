package com.app.actions;

import com.app.model.Book;
import com.app.services.BookService;
import com.app.util.AppConstants;
import com.app.util.SearchCriteria;
import com.opensymphony.xwork2.Action;
import junit.framework.TestCase;
import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import java.util.ArrayList;
import java.util.List;


public class SearchActionTest extends MockObjectTestCase {
    public void testExecute() throws Exception {

        Mock service = new Mock(BookService.class);

        SearchCriteria searchCriteria = new SearchCriteria();

        ArrayList<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 22; i++) {
            books.add(new Book());
        }

        service.expects(once()).method("findBy")
            .with(eq(searchCriteria), eq(0), eq(AppConstants.BOOKS_PER_PAGE))
            .will(returnValue(books));

        service.expects(once()).method("getCountBy")
            .with(eq(searchCriteria))
            .will(returnValue(22L));

        SearchAction searchAction = new SearchAction();
        searchAction.setBookService((BookService) service.proxy());
        searchAction.setSearchCriteria(searchCriteria);
        searchAction.setPageNumber(1);

        assertEquals(Action.SUCCESS, searchAction.execute());
        assertFalse(searchAction.hasErrors());
        assertEquals(5, searchAction.getTotalPages());
        assertEquals(22, searchAction.getTotalBooks());
        assertEquals(1, searchAction.getPageNumber());

    }
}
