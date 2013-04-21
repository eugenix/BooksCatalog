package com.app.actions;

import com.app.model.Book;
import com.app.services.BookService;
import com.app.services.BookServiceImpl;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

/**
 * Action class for saving or updating book in DB
 *
 * @author Eugene Kurbatov
 */
public class SaveBookAction extends BaseAction implements ModelDriven<Book> {

    /**
     * Book instance
     */
    private Book book = new Book();

    private BookService bookService = new BookServiceImpl();

    /**
     * Provide a model object to be pushed onto the ValueStack in addition to the Action itself,
     * allowing a FormBean type approach like Struts
     *
     * @return book instance
     */
    @VisitorFieldValidator(message = "", appendPrefix = true)
    @Override
    public Book getModel() {
        return book;
    }

    public Book setBook(Book book) {
        return this.book = book;
    }

    /**
     * Input method
     *
     * @return a string representing the logical result of the execution
     * @throws Exception
     */
    @Override
    public String input() throws Exception {
        return INPUT;
    }

    /**
     * Logic of the action is executed
     *
     * @return a string representing the logical result of the execution
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        bookService.saveOrUpdate(book);
        addActionMessage(getText("book.added"));

        return SUCCESS;
    }

    /**
     * Performs validation
     */
    @Override
    public void validate() {
        if (!getModel().getIsbn().matches("^[0-9]{10}$")) {
            addFieldError("isbn", getText("isbn.invalid"));
        }
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bs) {
        this.bookService = bs;
    }
}
