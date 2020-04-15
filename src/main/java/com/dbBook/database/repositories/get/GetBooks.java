package com.dbBook.database.repositories.get;

import com.dbBook.database.repositories.Repository;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetBooks implements Repository {


    public List<String> getBooks () {                      //Have Test
        List<String> result = new ArrayList<>();
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("select name_book from dbbook.book ;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("name_book"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }



}
