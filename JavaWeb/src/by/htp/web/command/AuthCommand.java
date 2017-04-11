package by.htp.web.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.web.domain.Book;
import by.htp.web.domain.User;
import by.htp.web.exception.SQLExceptionDAO;
import by.htp.web.service.BookService;
import by.htp.web.service.UserService;
import by.htp.web.service.impl.BookServiceImpl;
import by.htp.web.service.impl.UserServiceImpl;

import static by.htp.web.util.Permanents.*;

public  class AuthCommand implements Command {

	private UserService service;
	private BookService serviceBook;

	{
		service = new UserServiceImpl();
		serviceBook = new BookServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLExceptionDAO {

		String page = null;

		String login = request.getParameter(REQUEST_PARAM_USER_LOGIN);
		String password = request.getParameter(REQUEST_PARAM_USER_PASS);

		User user = service.authorize(login, password);
		if (user != null) {

			HttpSession session = request.getSession();
			session.setAttribute(SESSION_PARAM_USER, user);

			List<Book> books = serviceBook.listBooks();
			request.setAttribute("books", books);
			
			page = PAGE_WELCOME_USER;
			
			if (user.isRole()) {
				page = PAGE_WELCOME_ADMIN;
			}

		} else {
			request.setAttribute("ERROR", "wrong user login or password");
			page = PAGE_ERROR;
		}
		return page;
	}

	

}
