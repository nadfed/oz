package by.htp.web.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.web.dao.BookDao;
import by.htp.web.domain.Book;
import by.htp.web.domain.User;
import by.htp.web.exception.SQLExceptionDAO;

public class BookDaoImpl implements BookDao{

	@Override
    public List<Book> read() throws SQLExceptionDAO {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List <Book> books = new ArrayList<>();
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection("jdbc:mysql://localhost/webdb", "root", "root");
            statement= connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM book");


            while (resultSet.next()) {
                Book book = new Book();

                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                
               //BookDaoImp book.setYear(resultSet.getInt("year"));
               // book.setPrice(resultSet.getDouble("price"));
              //  book.setImageURL(resultSet.getString("imageURL"));
              //  book.setIdOZby(resultSet.getInt("idOZby"));

                books.add(book);}

        } catch (SQLExceptionDAO e){
                throw new SQLExceptionDAO("SQLExceptionDAO = connection error" + e);
        } catch (SQLException e) {
            System.out.println("SQLExceptionDAO = connection error " + e);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                    if (connection != null){
                        connection.close();}
                }catch (SQLException e) {
                    System.out.println("error sql connection");
                }
            }
        }
        return books;
    }


 @Override
    public void addBook(String title, String author) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
       
       
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection("jdbc:mysql://localhost/webdb", "root", "root");

            String query = "INSERT INTO webdb.book (title, author) VALUES (?,?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.executeUpdate();
        } catch (SQLExceptionDAO e){
            try {
                throw new SQLExceptionDAO("SQLExceptionDAO = connection error" + e);
            } catch (SQLExceptionDAO throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                    if (connection != null){
                        connection.close();}
                }catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("error sql connection!");
                }
            }
        }
    }

    @Override
    public Book fetchBookById(int id) throws SQLExceptionDAO {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Book book = null;

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            connection = DriverManager.getConnection("jdbc:mysql://localhost/webdb", "root", "root");
            statement= connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM book where id ='" + id + "' ;");

            while (resultSet.next()) {
                book = new Book();

                book.setAuthor(resultSet.getString("author"));
                book.setTitle(resultSet.getString("title"));
                book.setYear(resultSet.getInt("year"));
                book.setPrice(resultSet.getDouble("price"));
                book.setImageURL(resultSet.getString("imageURL"));
                book.setIdOZby(resultSet.getInt("idOZby"));
                book.setDescription(resultSet.getString("description"));

            }


        } catch (SQLExceptionDAO e){
                throw new SQLExceptionDAO("SQLExceptionDAO = connection error" + e);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                    if (connection != null){
                        connection.close();}
                }catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("error sql connection");
                }
            }
        }
        return book;
    }
 
}
