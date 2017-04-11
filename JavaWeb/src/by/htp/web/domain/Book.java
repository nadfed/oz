package by.htp.web.domain;

public class Book {

    private String title;
    private String author;
    private String publishing;
    private int year;
    private double price;
    private String imageURL;
    private int idOZby;
    private String description;

    public Book () {}

    public Book(String title, String author, String publishing, int year, double price, String imageURL, int idOZby) {
        this.title = title;
        this.author = author;
        this.publishing = publishing;
        this.year = year;
        this.price = price;
        this.imageURL = imageURL;
        this.idOZby = idOZby;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdOZby() {
        return idOZby;
    }

    public void setIdOZby(int idOZby) {
        this.idOZby = idOZby;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Book{" +
                "tittle='" + title + '\'' +
                ", author='" + author + '\'';
    }
/*
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }*/
}