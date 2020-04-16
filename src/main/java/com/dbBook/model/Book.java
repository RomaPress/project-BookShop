package com.dbBook.model;

public class Book {

    private String name_book;

    public Book(String name_book) {
        this.name_book = name_book;
    }

    public Book() {
    }

    public String getBook() {
        return name_book;
    }
    public void setBook(String name_book){
        this.name_book = name_book;
    }
}
