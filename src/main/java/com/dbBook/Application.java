package com.dbBook;


import com.dbBook.database.MyConnectionFactory;
import java.sql.SQLException;

public class Application {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MyConnectionFactory.getConnection();
    }
}