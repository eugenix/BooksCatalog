package com.app.services;


import com.app.model.Book;
import com.app.services.BookServiceImpl;
import com.app.util.SearchCriteria;

import java.util.List;

public class BookServiceImplTest extends BaseDBUnitTest {
    private BookServiceImpl service;

    public BookServiceImplTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
        service = new BookServiceImpl();
    }

    public void testSave() throws Exception {
        Book book = new Book();
        book.setAuthorName("Foo");
        book.setImageUrl("http://example.com");
        book.setIsbn("1234567890");
        book.setPublisher("Bar");
        book.setTitle("Zoo");
        book.setDescription("foo bar");

        service.saveOrUpdate(book);

        Book newBook = service.findByISBN("1234567890");

        assertEquals("Foo", newBook.getAuthorName());
        assertEquals("http://example.com", newBook.getImageUrl());
        assertEquals("1234567890", newBook.getIsbn());
        assertEquals("Bar", newBook.getPublisher());
        assertEquals("Zoo", newBook.getTitle());
        assertEquals("foo bar", newBook.getDescription());
    }

    public void testUpdate() throws Exception {
        Book book = service.findById(1);

        assertNotNull(book);

        book.setAuthorName("_Foo");
        book.setImageUrl("http://example.com");
        book.setIsbn("1234567890");
        book.setPublisher("_Bar");
        book.setTitle("_Zoo");
        book.setDescription("_foo bar");

        service.saveOrUpdate(book);
        Book updatedBook = service.findById(book.getId());

        assertEquals("_Foo", updatedBook.getAuthorName());
        assertEquals("http://example.com", updatedBook.getImageUrl());
        assertEquals("1234567890", updatedBook.getIsbn());
        assertEquals("_Bar", updatedBook.getPublisher());
        assertEquals("_Zoo", updatedBook.getTitle());
        assertEquals("_foo bar", updatedBook.getDescription());
    }

    public void testFindBooksEmptyCriteria() throws Exception {
        List books = service.findBy(new SearchCriteria(), 0, 100);
        assertNotNull(books);
        assertEquals(5, books.size());
    }

    public void testFindBooks() throws Exception {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setAuthorName("достоевский");

        List books = service.findBy(searchCriteria, 0, 100);
        assertEquals(3, books.size());

        searchCriteria = new SearchCriteria();
        searchCriteria.setAuthorName("Гоголь");

        books = service.findBy(searchCriteria, 0, 100);
        assertEquals(0, books.size());

        searchCriteria = new SearchCriteria();
        searchCriteria.setAuthorName("достоевский");
        searchCriteria.setPublisher("Азбука-Аттикус");

        books = service.findBy(searchCriteria, 0, 100);
        assertEquals(2, books.size());

        for (Object u: books) {
            assertEquals("Федор Достоевский", ((Book)u).getAuthorName());
            assertEquals("Азбука-Аттикус", ((Book)u).getPublisher());
        }

        searchCriteria = new SearchCriteria();
        searchCriteria.setAuthorName("Федор Достоевский");
        searchCriteria.setPublisher("Азбука-Аттикус");
        searchCriteria.setIsbn("0987654321");
        searchCriteria.setTitle("Преступление и наказание");

        books = service.findBy(searchCriteria, 0, 100);
        assertEquals(1, books.size());

        assertEquals("Федор Достоевский", ((Book)books.get(0)).getAuthorName());
        assertEquals("Преступление и наказание", ((Book)books.get(0)).getTitle());
        assertEquals("0987654321", ((Book)books.get(0)).getIsbn());
        assertEquals(3, ((Book)books.get(0)).getId());
        assertEquals("Азбука-Аттикус", ((Book)books.get(0)).getPublisher());
    }

    public void testFindById() throws Exception {
        Book book = service.findById(3);

        assertNotNull(book);
        assertEquals("Федор Достоевский", book.getAuthorName());
        assertEquals("Преступление и наказание", book.getTitle());
        assertEquals("0987654321", book.getIsbn());
        assertEquals(3, book.getId());
        assertEquals("Азбука-Аттикус", book.getPublisher());
        assertEquals(530.0, book.getPrice());

        book = service.findById(1000);
        assertNull(book);
    }

    public void testFindByISBN() throws Exception {
        Book book = service.findByISBN("0987654321");

        assertNotNull(book);
        assertEquals("Федор Достоевский", book.getAuthorName());
        assertEquals("Преступление и наказание", book.getTitle());
        assertEquals("0987654321", book.getIsbn());
        assertEquals(3, book.getId());
        assertEquals("Азбука-Аттикус", book.getPublisher());
        assertEquals(530.0, book.getPrice());

        book = service.findByISBN("");
        assertNull(book);
    }

    public void testDeleteById () throws Exception {
        assertNotNull(service.findById(1));
        service.deleteById(1);
        assertNull(service.findById(1));
    }
}
