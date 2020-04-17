package com.dbBook.database.repositories.get;

import com.dbBook.database.repositories.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetAuthors implements Repository {

    public List<String> getAuthors () {                      //Have Test
        List<String> result = new ArrayList<>();
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("select first_name, last_name, patronymic from dbbook.author ;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("first_name") + " " + rs.getString("patronymic") + " " + rs.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
