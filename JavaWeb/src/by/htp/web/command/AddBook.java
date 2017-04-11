package by.htp.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.web.dao.impl.BookDaoImpl;
import by.htp.web.exception.SQLExceptionDAO;
import by.htp.web.service.BookService;
import by.htp.web.service.impl.BookServiceImpl;

public class AddBook implements Command {
    private BookService service;

    {service = new BookServiceImpl();}

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLExceptionDAO {
        String page;
        boolean result = false;
        String title = req.getParameter("title");
        String author = req.getParameter("author");

        service.addBook(title, author);

        page = "/index.html";
        return page;
    }

}
