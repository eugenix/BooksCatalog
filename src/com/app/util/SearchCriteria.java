package com.app.util;

/**
 * Class presents a user search request for books
 *
 * @author Eugene Kurbatov
 */
public class SearchCriteria {

    /**
     * Book title or name
     */
    private String title = "";

    /**
     * Author name, surname
     */
    private String authorName = "";

    /**
     * Book publisher
     */
    private String publisher = "";

    /**
     * International Standard Book Number
     */
    private String isbn = "";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.trim();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn.trim();
    }
}
