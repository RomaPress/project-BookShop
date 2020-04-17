package com.dbBook.database.repositories;


import com.dbBook.database.repositories.get.GetGenres;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GetGenresTest {

    private GetGenres search = new GetGenres();

    @Test
    public void getGenresTest() {

        List<String> result = new ArrayList<>();
        result.add("Повесть");
        result.add("История");
        result.add("Политика");
        result.add("Роман");
        result.add("Поэма");

        List<String> actual;
        actual = search.getGenres();
        Assert.assertEquals(result, actual);

    }
}
