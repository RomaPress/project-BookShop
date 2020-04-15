package com.dbBook.servlet;

import com.dbBook.assemblyFunction.SearchAuthorsByBook;
import com.dbBook.assemblyFunction.SearchBooksByAuthor;
import com.dbBook.assemblyFunction.SearchBooksByGenre;
import com.dbBook.assemblyFunction.SearchGenresByBook;
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

    private static final String index = "/WEB-INF/view/index.jsp";

//    private List<List<String>> answerList;
private List<String> answerList;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.setCharacterEncoding("UTF8");



        final String result1 = req.getParameter("line1");
        System.out.println(result1);
        final String result2 = req.getParameter("second_line");

        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        answerList = new CopyOnWriteArrayList<>();


        final String result1 = req.getParameter("line1");
        final String result2 = req.getParameter("second_line");
        answerList.add(result1);
        answerList.add(result2);
        req.setAttribute("answerList", answerList);
        getServletContext().getRequestDispatcher(index).forward(req, resp);


//        answerList = new CopyOnWriteArrayList<List<String>>();
//
//        switch (result1) {
//            case "Select books by author":
//                SearchBooksByAuthor book_author = new SearchBooksByAuthor();
//                answerList.add(book_author.searchBooksByAuthor(result2));
//                req.setAttribute("answerList", answerList);
//                getServletContext().getRequestDispatcher(index).forward(req, resp);
//                break;
//
//            case "Select books by genre":
//                SearchBooksByGenre book_genre = new SearchBooksByGenre();
//                answerList.add(book_genre.searchBooksByGenre(result2));
//                req.setAttribute("answerList", answerList);
//                getServletContext().getRequestDispatcher(index).forward(req, resp);
//                break;
//
//            case "Select genres by book":
//                SearchGenresByBook genre_book = new SearchGenresByBook();
//                answerList.add(genre_book.searchGenresByBook(result2));
//                req.setAttribute("answerList", answerList);
//                getServletContext().getRequestDispatcher(index).forward(req, resp);
//                break;
//
//            case "Select authors by book":
//                SearchAuthorsByBook author_book = new SearchAuthorsByBook();
//                answerList.add(author_book.searchAuthorsByBook(result2));
//                req.setAttribute("answerList", answerList);
//                getServletContext().getRequestDispatcher(index).forward(req, resp);
//                break;
//        }
    }
}
