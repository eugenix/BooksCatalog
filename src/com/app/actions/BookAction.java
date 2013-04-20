package com.app.actions;


import com.app.model.Book;
import com.app.services.BookService;
import com.app.services.BookServiceImpl;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;

/**
 * Action class, page for editing book
 *
 * @author Eugene Kurbatov
 */
public class BookAction extends BaseAction implements ModelDriven<Book> {

    /**
     * Book id
     */
    private int bookId;

    /**
     * Book instance
     */
    private Book book = new Book();

    private BookService bookService = new BookServiceImpl();

    /**
     * Logic of the action is executed
     *
     * @return a string representing the logical result of the execution
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        book = bookService.findById(bookId);

        if (book == null) {
            addActionError(String.format("Book with id: %s not found", bookId));
            return INPUT;
        }

        return SUCCESS;
    }

    @IntRangeFieldValidator(message = "Not valid book id", min = "1")
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public Book getModel() {
        return book;
    }

    public int getBookId() {
        return bookId;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bs) {
        this.bookService = bs;
    }
}
