package by.htp.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.web.exception.SQLExceptionDAO;


	
	public interface Command {
		
		public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLExceptionDAO;

		//String AddBookCommand(HttpServletRequest request, HttpServletResponse response);

	}
