package com.dbBook.servlet;

import com.dbBook.database.repositories.get.GetAuthors;
import com.dbBook.database.repositories.get.GetBooks;
import com.dbBook.database.repositories.get.GetGenres;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@WebServlet("/select_table")
public class SelectTablesServlet extends HttpServlet {

    private static final String index = "/WEB-INF/view/index.jsp";

    private List<String> secondList;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.setCharacterEncoding("UTF8");

        final String result = req.getParameter("first_line");
        doGet(req, resp);


    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String result = req.getParameter("first_line");
        secondList = new CopyOnWriteArrayList<>();
        HttpSession session = req.getSession();

        switch (result) {
            case "Select books by author":
                GetAuthors authors = new GetAuthors();
                secondList.addAll(authors.getAuthors());
                session.setAttribute("secondList", secondList);
                getServletContext().getRequestDispatcher(index).forward(req, resp);
                break;
            case "Select books by genre":
                GetGenres genres = new GetGenres();
                secondList.addAll(genres.getGenres());
                session.setAttribute("secondList", secondList);
                getServletContext().getRequestDispatcher(index).forward(req, resp);
                break;
            case "Select genres by book":
            case "Select authors by book":
                GetBooks books = new GetBooks();
                secondList.addAll(books.getBooks());
                session.setAttribute("secondList", secondList);
                getServletContext().getRequestDispatcher(index).forward(req, resp);
                break;
        }

    }


}
