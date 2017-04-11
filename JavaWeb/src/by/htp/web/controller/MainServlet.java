package by.htp.web.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.web.command.Command;
import by.htp.web.command.CommandChooser;
import by.htp.web.domain.Book;
import by.htp.web.domain.User;
import by.htp.web.exception.SQLExceptionDAO;

import static by.htp.web.util.Permanents.*;


public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req,resp);
        } catch (SQLExceptionDAO throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //PrintWriter printWriter = resp.getWriter();
        try {
            processRequest(req,resp);
        } catch (SQLExceptionDAO throwables) {
            throwables.printStackTrace();
        }


    }

    public void forward(HttpServletRequest req, HttpServletResponse resp, String page) throws ServletException, IOException{
        RequestDispatcher disp =req.getRequestDispatcher(page);
        disp.forward(req, resp);
    }

    public  void processRequest (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLExceptionDAO {
        String action = req.getParameter(REQUEST_PARAM_ACTION);
        Command command = CommandChooser.chooseCommand(action);
        String page = command.execute(req,resp);
        forward(req,resp, page);

    }

}
