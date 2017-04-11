package by.htp.web.service.impl;

import java.util.List;

import by.htp.web.dao.BookDao;
import by.htp.web.dao.impl.BookDaoImpl;
import by.htp.web.domain.Book;
import by.htp.web.exception.SQLExceptionDAO;
import by.htp.web.service.BookService;

public class BookServiceImpl implements BookService {

	
	private BookDao dao;
	
	{
		dao = new BookDaoImpl();
	}
	
	 @Override
	    public List<Book> listBooks() throws SQLExceptionDAO {
	        List<Book> books = dao.read();
	     //  books.listIterator()
	        return books;
	    }

	    @Override
	    public void addBook(String title, String author) {
	        dao.addBook(title, author);
	    }

	    @Override
	    public Book fetchBookById(int id) throws SQLExceptionDAO {
	        Book profile_book = dao.fetchBookById(id);
	        return profile_book;
	    }
	}
