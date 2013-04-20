package com.app.services;

import com.app.model.Book;
import com.app.model.User;
import com.app.util.HibernateUtil;
import com.app.util.SearchCriteria;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of book CRUD interface
 *
 * @author Eugene Kurbatov
 */
public class BookServiceImpl implements BookService {

    /**
     * Save or updates book entity
     *
     * @param book instance of Book that want to be saved/updated
     */
    @Override
    public void saveOrUpdate(Book book) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();

            session.beginTransaction();
            session.saveOrUpdate(book);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     * Find books by searchCriteria
     *
     * @param searchCriteria instance of SearchCriteria
     * @param skip items to skip
     * @param limit result limit
     *
     * @return list of Book
     */
    @Override
    public List findBy(SearchCriteria searchCriteria, int skip, int limit) {
        Session session = null;
        List books = new ArrayList();
        try {
            session = HibernateUtil.getSession();

            books = buildCriteria(searchCriteria, session)
                .setFirstResult(skip)
                .setMaxResults(limit)
                .list();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return books;
    }

    /**
     * Get count of books by searchCriteria
     *
     * @param searchCriteria instance of SearchCriteria
     *
     * @return count
     */
    @Override
    public Long getCountBy(SearchCriteria searchCriteria) {
        Session session = null;
        Long count = 0L;
        try {
            session = HibernateUtil.getSession();

            count = (Long) buildCriteria(searchCriteria, session)
                .setProjection(Projections.rowCount())
                .uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return count;

    }

    /**
     * Find book by id
     *
     * @param id book id
     *
     * @return instance of Book
     */
    @Override
    public Book findById(int id) {
        Session session = null;
        Book book = null;
        try {
            session = HibernateUtil.getSession();
            book = (Book) session.get(Book.class, id);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return book;
    }

    /**
     * Build org.hibernate.Criteria object
     *
     * @param searchCriteria instance of SearchCriteria
     * @param session hibernate session
     *
     * @return org.hibernate.Criteria object
     */
    private Criteria buildCriteria(SearchCriteria searchCriteria, Session session) {
        return session.createCriteria(Book.class)
            .add(Restrictions.like("title", "%" + searchCriteria.getTitle() + "%"))
            .add(Restrictions.like("authorName", "%" + searchCriteria.getAuthorName() + "%"))
            .add(Restrictions.like("publisher", "%" + searchCriteria.getPublisher() + "%"))
            .add(Restrictions.like("isbn", "%" + searchCriteria.getIsbn() + "%"));
    }

    /**
     * Find book by isbn
     *
     * @param isbn International Standard Book Number
     *
     * @return book
     */
    public Book findByISBN(String isbn) {
        Session session = null;
        Book book = null;
        try {
            session = HibernateUtil.getSession();
            List books = session.createCriteria(Book.class)
                .add(Restrictions.eq("isbn", isbn))
                .setMaxResults(1)
                .list();

            if (!books.isEmpty())
                book = (Book) books.get(0);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return book;

    }
}
