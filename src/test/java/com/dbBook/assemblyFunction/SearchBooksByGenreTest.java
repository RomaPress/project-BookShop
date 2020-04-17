package com.dbBook.assemblyFunction;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchBooksByGenreTest {

    private SearchBooksByGenre search = new SearchBooksByGenre();

    @Test
    public void searchAuthorsByBookTest() {

        List<String> result = new ArrayList<>();
        result.add("Бесы");
        result.add("12 Стульев");

        List<String> actual;
        actual = search.searchBooksByGenre("Роман");
        Assert.assertEquals(result, actual);
    }
}