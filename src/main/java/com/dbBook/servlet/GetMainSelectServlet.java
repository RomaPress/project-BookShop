package com.dbBook.servlet;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@WebServlet("/")
public class GetMainSelectServlet extends HttpServlet {

    private List<String> firstList;
    private static final String index = "/WEB-INF/view/index.jsp";

    @Override
    public void init() throws ServletException {
        firstList = new CopyOnWriteArrayList<>();
        firstList.add("Select books by author");
        firstList.add("Select books by genre");
        firstList.add("Select genres by book");
        firstList.add("Select authors by book");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.setAttribute("firstList", firstList);

        req.getRequestDispatcher(index).forward(req, resp);
    }
}

