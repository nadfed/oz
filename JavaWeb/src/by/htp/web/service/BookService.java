package by.htp.web.service;

import java.util.List;

import by.htp.web.domain.Book;
import by.htp.web.exception.SQLExceptionDAO;

public interface BookService {

	public List<Book> listBooks() throws SQLExceptionDAO;
	public void addBook (String title, String author);

    public Book fetchBookById (int id) throws SQLExceptionDAO;
}
