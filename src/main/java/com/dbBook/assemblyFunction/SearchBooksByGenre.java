package com.dbBook.assemblyFunction;

import com.dbBook.database.repositories.Repository;
import com.dbBook.database.repositories.impl.BookRepository;
import com.dbBook.database.repositories.impl.GenreRepository;

import java.util.List;

public class SearchBooksByGenre implements Repository {
    private GenreRepository genre = new GenreRepository();
    private BookRepository book = new BookRepository();

    public List<String> searchBooksByGenre(String input) {
        return book.getBookName(book.getBooksIdFromGenreId(genre.getGenreId(input)));
    }

//    public static void main(String[] args) {
//        SearchBooksByGenre q = new SearchBooksByGenre();
//        System.out.println( q.searchBooksByGenre("Роман"));
//
//    }
}

