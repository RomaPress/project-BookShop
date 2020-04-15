package com.dbBook.database.repositories.get;

import com.dbBook.database.repositories.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetGenres implements Repository {

    public List<String> getGenres () {                      //Have Test
        List<String> result = new ArrayList<>();
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("select name_genre from dbbook.genre ;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("name_genre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
