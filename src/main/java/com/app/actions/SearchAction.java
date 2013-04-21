package com.app.actions;


import com.app.services.BookService;
import com.app.services.BookServiceImpl;
import com.app.util.AppConstants;
import com.app.util.SearchCriteria;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * Action class, search book
 *
 * @author Eugene Kurbatov
 */
public class SearchAction extends BaseAction implements ModelDriven<SearchCriteria> {

    /**
     * Object that represents criteria of search
     */
    private SearchCriteria searchCriteria = new SearchCriteria();

    /**
     *  List of result books
     */
    private List books;

    /**
     * Current page number
     */
    private int pageNumber = 1;

    /**
     * Total count of result books
     */
    private long totalBooks = 0;

    /**
     *  Total count of pages
     */
    private long totalPages = 0;

    private BookService bookService = new BookServiceImpl();

    /**
     * Logic of the action is executed
     *
     * @return a string representing the logical result of the execution
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        books = bookService.findBy(
            searchCriteria,
            (pageNumber - 1) * AppConstants.BOOKS_PER_PAGE,
            AppConstants.BOOKS_PER_PAGE
        );

        totalBooks = bookService.getCountBy(searchCriteria);
        totalPages = (int) Math.ceil(totalBooks / (double)AppConstants.BOOKS_PER_PAGE);

        return SUCCESS;
    }

    public List getBooks() {
        return books;
    }

    public void setBooks(List books) {
        this.books = books;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public SearchCriteria getModel() {
        return searchCriteria;
    }

    public long getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(long totalBooks) {
        this.totalBooks = totalBooks;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

}
