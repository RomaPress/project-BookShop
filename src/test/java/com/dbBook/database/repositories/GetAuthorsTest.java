package com.dbBook.database.repositories;

import com.dbBook.database.repositories.get.GetAuthors;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GetAuthorsTest {

    private GetAuthors search = new  GetAuthors();

    @Test
    public void getAuthorsTest() {

        List<String> result = new ArrayList<>();
        result.add("Федор Михайлович Достоевский");
        result.add("Александр Сергеевич Пушкин");
        result.add("Илья Арнольдович Ильф");
        result.add("Евгений Петрович Катаев");
        result.add("Сергей Николаевич Семанов");

        List<String> actual;
        actual = search.getAuthors();
        Assert.assertEquals(result, actual);

    }
}
