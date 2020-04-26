package com.dbBook.servlet;

import com.dbBook.database.repositories.get.GetAuthors;
import com.dbBook.database.repositories.get.GetBooks;
import com.dbBook.database.repositories.get.GetGenres;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/select_table")
public class SelectTablesServlet extends HttpServlet {

    private static final String index = "/WEB-INF/index.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String result1 = req.getParameter("line1");

        JsonObject jo = new JsonObject();
        JsonArray array = new JsonArray();
        JsonObject object;

        switch (result1) {
            case "Select books by author":
                GetAuthors authors = new GetAuthors();
                for (String a :authors.getAuthors()) {
                    object = new JsonObject();
                    object.addProperty("name", a);
                    array.add(object);
                }
                jo.add("result", array);
                break;

            case "Select books by genre":
                GetGenres genres = new GetGenres();
                for (String a :genres.getGenres()) {
                    object = new JsonObject();
                    object.addProperty("name", a);
                    array.add(object);
                }
                jo.add("result", array);
                break;

            case "Select genres by book":
            case "Select authors by book":
                GetBooks books = new GetBooks();
                for (String a :books.getBooks()) {
                    object = new JsonObject();
                    object.addProperty("name", a);
                    array.add(object);
                }
                jo.add("result", array);
            break;
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jo.toString());
    }
}
