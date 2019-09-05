/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jnosql.artemis.jnosql.hazelcast;

import java.io.Serializable;

/**
 *
 * @author WayneHu
 */
public class Book implements Serializable {
 
    private String isbn;
    private String name;
    private String author;
    private int pages;
 
    // standard constructor
    // standard getters and setters
    public Book() {
    }

    public Book(String isbn, String name, String author, int pages) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }
}
