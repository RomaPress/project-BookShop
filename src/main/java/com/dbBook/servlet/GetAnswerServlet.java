package com.dbBook.servlet;

import com.dbBook.assemblyFunction.SearchAuthorsByBook;
import com.dbBook.assemblyFunction.SearchBooksByAuthor;
import com.dbBook.assemblyFunction.SearchBooksByGenre;
import com.dbBook.assemblyFunction.SearchGenresByBook;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/answer")
public class GetAnswerServlet extends HttpServlet {

    private static final String index = "/WEB-INF/index.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.setCharacterEncoding("UTF8");

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        answerList = new CopyOnWriteArrayList<>();

        final String result1 = req.getParameter("line1");
        final String result2 = req.getParameter("line2");


        JsonObject jo = new JsonObject();
        JsonArray cellarray = new JsonArray();
        JsonObject cellobj = null;



        switch (result1) {
            case "Select books by author":
                SearchBooksByAuthor bookAuthor = new SearchBooksByAuthor();

                for (String a :bookAuthor.searchBooksByAuthor(result2)) {
                    cellobj = new JsonObject();
                    cellobj.addProperty("name", a);
                    cellarray.add(cellobj);
                }
                jo.add("result",cellarray);
                System.out.println(jo);
                break;


            case "Select books by genre":
                SearchBooksByGenre bookGenre = new SearchBooksByGenre();

                for (String a :bookGenre.searchBooksByGenre(result2)) {
                    cellobj = new JsonObject();
                    cellobj.addProperty("name", a);
                    cellarray.add(cellobj);
                }
                jo.add("result",cellarray);
                break;

            case "Select genres by book":
                SearchGenresByBook genreBook = new SearchGenresByBook();

                for (String a :genreBook.searchGenresByBook(result2)) {
                    cellobj = new JsonObject();
                    cellobj.addProperty("name", a);
                    cellarray.add(cellobj);
                }
                jo.add("result",cellarray);
                break;

            case "Select authors by book":
                SearchAuthorsByBook authorBook = new SearchAuthorsByBook();

                for (String a :authorBook.searchAuthorsByBook(result2)) {
                    cellobj = new JsonObject();
                    cellobj.addProperty("name", a);
                    cellarray.add(cellobj);
                }
                jo.add("result",cellarray);
                break;
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jo.toString());
    }
}
