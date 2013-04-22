package com.app.services;

import com.app.model.Book;
import com.app.util.SearchCriteria;

import java.util.List;

/**
 * Book CRUD interface
 *
 * @author Eugene Kurbatov
 */
public interface BookService {

    /**
     * Save or updates book entity
     *
     * @param book instance of Book that want to be saved/updated
     */
    public void saveOrUpdate(Book book);

    /**
     * Find books by searchCriteria
     *
     * @param searchCriteria instance of SearchCriteria
     * @param skip items to skip
     * @param limit result limit
     *
     * @return list of Book
     */
    public List findBy(SearchCriteria searchCriteria, int skip, int limit);

    /**
     * Get count of books by searchCriteria
     *
     * @param searchCriteria instance of SearchCriteria
     *
     * @return count
     */
    public Long getCountBy(SearchCriteria searchCriteria);

    /**
     * Find book by id
     *
     * @param id book id
     *
     * @return instance of Book
     */
    public Book findById(int id);


    /**
     * Delete book bu id
     *
     * @param id book id
     */
    void deleteById(int id);
}
