package com.app.model;

import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.opensymphony.xwork2.validator.annotations.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Book entity class
 *
 * @author Eugene Kurbatov
 */
@Conversion()
@Entity(name = "book")
public class Book {
    /**
     * Book id
     */
    private int id;

    /**
     * Book title or name
     */
    private String title;

    /**
     * Book image url
     */
    private String imageUrl;

    /**
     * Author name, surname
     */
    private String authorName;

    /**
     * International Standard Book Number
     */
    private String isbn;

    /**
     * Book publisher
     */
    private String publisher;

    /**
     * Short description or annotation
     */
    private String description;

    /**
     * Book price in rubles
     */
    private double price;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title") @Basic()
    public String getTitle() {
        return title;
    }

    @RequiredStringValidator(message = "Title: required")
    @StringLengthFieldValidator(message = "Title: max length ${maxLength} ", minLength = "1",  maxLength = "255")
    public void setTitle(String tittle) {
        this.title = tittle;
    }

    @Column(name = "imageUrl") @Basic()
    public String getImageUrl() {
        return imageUrl;
    }

    @RequiredStringValidator(message = "Image url: required")
    @UrlValidator(message = "Image url: not valid format")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name = "authorName") @Basic()
    public String getAuthorName() {
        return authorName;
    }

    @RequiredStringValidator(message = "Author name: required")
    @StringLengthFieldValidator(message = "Author name: max length ${maxLength} ", minLength = "1",  maxLength = "255")
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Column(name = "isbn") @Basic()
    public String getIsbn() {
        return isbn;
    }

    @RequiredStringValidator(message="ISBN: required")
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(name = "publisher") @Basic()
    public String getPublisher() {
        return publisher;
    }

    @RequiredStringValidator(message="Publisher: required")
    @StringLengthFieldValidator(message = "Publisher: max length ${maxLength} ", minLength = "1",  maxLength = "255")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Column(name = "description") @Basic()
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price") @Basic()
    public double getPrice() {
        return price;
    }

    @TypeConversion(converter = "com.app.util.StringPriceConverter")
    @DoubleRangeFieldValidator(message = "Price: must be between ${minInclusive} and ${maxInclusive}", minInclusive = "1.00", maxInclusive = "1000000.00")
    public void setPrice(double price) {
        this.price = price;
    }
}
