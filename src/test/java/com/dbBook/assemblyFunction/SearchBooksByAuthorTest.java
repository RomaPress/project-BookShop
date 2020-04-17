package com.dbBook.assemblyFunction;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchBooksByAuthorTest {

    private SearchBooksByAuthor search = new SearchBooksByAuthor();

    @Test
    public void searchBooksByAuthorTest() {

        List<String> result = new ArrayList<>();
        result.add("Руслан и Людмила");
        result.add("Пиковая дама");

        List<String> actual;
        actual = search.searchBooksByAuthor("Александр Сергеевич Пушкин");
        Assert.assertEquals(result, actual);

    }
}
