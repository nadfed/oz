package by.htp.web.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.htp.web.service.BookService;
import by.htp.web.service.impl.BookServiceImpl;

public class FindBooksTest {
	private WebDriver driver;
	private String url = "https://oz.by/search/?q=java";
	private String bookLocator = "//*[@id='goods-table']/li[1]";
	// private String siblings = "//*[@id='goods-table']/following-sibling::*";
	private String bookTitle = ".//*[@id='top-page']/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/h1";
	private String bookAuthor = "b-product-title__inner-link";

	String name = "li.viewer-type-card__li";
	String selector = ".needsclick.item-type-card__link.item-type-card__link--main";

	String title;
	String author;
	BookService service;
	String locator;

	{
		service = new BookServiceImpl();
	}

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:/Selenium/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void openOz() {

		driver.get(url);
		driver.findElement(By.xpath(bookLocator)).click();
		title = driver.findElement(By.xpath(bookTitle)).getText();
		author = driver.findElement(By.className(bookAuthor)).getText();
		service.addBook(title, author);

		List<WebElement> list = new ArrayList<WebElement>();
		System.out.println(list.size() + "¬—≈√Œ  Õ»√");
		driver.get(url);
		list = driver.findElement(By.id("goods-table"))
				.findElements(By.cssSelector("li.viewer-type-card__li:not(.pg-element-preloaded)"));

		for (int i = 1; i < list.size(); i++) {

			String title = list.get(i).findElement(By.xpath(".//p[@class = 'item-type-card__title']")).getText();
			String author = list.get(i).findElement(By.xpath(".//p[@class = 'item-type-card__info']")).getText();
			service.addBook(title, author);
		}
	}

	@AfterTest
	public void tearDown() {

		driver.quit();

	}
}
