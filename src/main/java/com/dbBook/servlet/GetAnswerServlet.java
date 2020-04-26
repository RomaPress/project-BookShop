package com.dbBook.servlet;

import com.dbBook.assemblyFunction.SearchAuthorsByBook;
import com.dbBook.assemblyFunction.SearchBooksByAuthor;
import com.dbBook.assemblyFunction.SearchBooksByGenre;
import com.dbBook.assemblyFunction.SearchGenresByBook;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/answer")
public class GetAnswerServlet extends HttpServlet {

    private static final String index = "/WEB-INF/index.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        final String result1 = req.getParameter("line1");
        final String result2 = req.getParameter("line2");

        JsonObject jo = new JsonObject();
        JsonArray array = new JsonArray();
        JsonObject object;

        switch (result1) {
            case "Select books by author":
                SearchBooksByAuthor bookAuthor = new SearchBooksByAuthor();
                for (String a :bookAuthor.searchBooksByAuthor(result2)) {
                    object = new JsonObject();
                    object.addProperty("name", a);
                    array.add(object);
                }
                jo.add("result", array);
                break;

            case "Select books by genre":
                SearchBooksByGenre bookGenre = new SearchBooksByGenre();
                for (String a :bookGenre.searchBooksByGenre(result2)) {
                    object = new JsonObject();
                    object.addProperty("name", a);
                    array.add(object);
                }
                jo.add("result", array);
                break;

            case "Select genres by book":
                SearchGenresByBook genreBook = new SearchGenresByBook();
                for (String a :genreBook.searchGenresByBook(result2)) {
                    object = new JsonObject();
                    object.addProperty("name", a);
                    array.add(object);
                }
                jo.add("result", array);
                break;

            case "Select authors by book":
                SearchAuthorsByBook authorBook = new SearchAuthorsByBook();
                for (String a :authorBook.searchAuthorsByBook(result2)) {
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
