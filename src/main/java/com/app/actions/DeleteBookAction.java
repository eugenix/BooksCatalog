package com.app.actions;

import com.app.services.BookService;
import com.app.services.BookServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;


public class DeleteBookAction extends ActionSupport {

    private int bookId;

    private BookService bookService = new BookServiceImpl();

    @Override
    public String execute() throws Exception {

        bookService.deleteById(bookId);
        addActionMessage(getText("book.deleted"));

        return SUCCESS;
    }

    public int getBookId() {
        return bookId;
    }

    @IntRangeFieldValidator(key = "bookId.invalid", min = "1")
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
