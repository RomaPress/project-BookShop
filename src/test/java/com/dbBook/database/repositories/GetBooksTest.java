package com.dbBook.database.repositories;

import com.dbBook.database.repositories.get.GetBooks;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GetBooksTest {

    private GetBooks search = new GetBooks();

    @Test
    public void getBooksTest() {

        List<String> result = new ArrayList<>();
        result.add("Бесы");
        result.add("Руслан и Людмила");
        result.add("Кронштадтский мятеж");
        result.add("Пиковая дама");
        result.add("12 Стульев");

        List<String> actual;
        actual = search.getBooks();
        Assert.assertEquals(result, actual);

    }
}
