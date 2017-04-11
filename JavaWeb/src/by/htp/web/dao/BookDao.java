package by.htp.web.dao;

import java.util.List;

import by.htp.web.domain.Book;
import by.htp.web.exception.SQLExceptionDAO;


public interface BookDao {
	
	public List<Book> read() throws SQLExceptionDAO;
	public void addBook (String title, String author);

    public Book fetchBookById (int id) throws SQLExceptionDAO;
}
