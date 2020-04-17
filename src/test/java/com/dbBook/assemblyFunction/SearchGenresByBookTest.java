package com.dbBook.assemblyFunction;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchGenresByBookTest {

    private SearchGenresByBook search = new SearchGenresByBook();

    @Test
    public void searchGenresByBookTest() {

        List<String> result = new ArrayList<>();
        result.add("История");
        result.add("Политика");

        List<String> actual;
        actual = search.searchGenresByBook("Кронштадтский мятеж");
        Assert.assertEquals(result, actual);

    }
}
