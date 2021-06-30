package pageObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.text.html.CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.graphbuilder.curve.Point;

public class HomePage extends BasePage {
	@FindBy(css = ".menu.responsive a")
	private List<WebElement> catagoryList;
	@FindBy(css = ".date")
	private WebElement date;
	@FindBy(css = "#tns1-item5 > a > span")
	private WebElement weatherBtn;
	@FindBy(css = ".menu")
	private WebElement topBar;
	@FindBy(css = ".ordering.podcasts")
	private WebElement scrollElement;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	//methode for choosing specific category
	public void chooseCategory(String text) {
		for (WebElement el : catagoryList) {
			String option = getText(el);
			if (option.contains(text)) {
				sleep(1500);
				click(el);
				break;
			}
		}
	}
	
	//returning the current date
	public String getCurrentDay() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yy");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
	//returning the actual date
	public String actualDate() {
		String str = getText(date);
		return str.substring(str.length() - 8);
	}
	
	//move to weather page
	public void moveToWeatherPage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tns1-item5 > a > span")));
		click(weatherBtn);
	}
	
	//scrolling down the mouse
	public void scrollDown() {
		scrollMouse(scrollElement);
	}
	
	//get corrdinates for an element
	public String getCoordinates() {
		// Locate element for which you wants to retrieve x y coordinates.
		WebElement image = driver.findElement(By.cssSelector(".menu"));
		int x = image.getLocation().getX();
		int y = image.getLocation().getY();
		int[] arr = {x, y};
		String arrStr = Arrays.toString(arr);
		System.out.println(arrStr);
		//System.out.println("x=" + x + ", y=" + y);
		return arrStr;
	}
}
