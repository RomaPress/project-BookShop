package com.dbBook.assemblyFunction;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchAuthorsByBookTest {

    private SearchAuthorsByBook search = new SearchAuthorsByBook();

    @Test
    public void searchAuthorsByBookTest() {

        List<String> result = new ArrayList<>();
        result.add("Илья Арнольдович Ильф");
        result.add("Евгений Петрович Катаев");

        List<String> actual;
        actual = search.searchAuthorsByBook("12 Стульев");
        Assert.assertEquals(result, actual);

    }
}

