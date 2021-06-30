package pageObjects;

import java.util.List;

import javax.swing.text.html.CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WeatherPage extends BasePage {
	@FindBy(css = ".forcastMapWrap .icon")
	private List<WebElement> listOfCities;
	@FindBy(css = "#neoLocalForcast > button > span:nth-child(2)")
	private WebElement cityTitle;
	@FindBy(css = ".forcastMapWrap h2")
	private WebElement weatherTitle;
	
	public WeatherPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getWeatherTitle() {
		return driver.getTitle();
		
	}
	
	public boolean checkCities(String text) {
		scrollMouse(cityTitle);
		for (WebElement el : listOfCities) {
			String city = getText(el);
			if (city.contains(text)) {
				return true;
			}
			
		}
		return false;
		
	}
	
	public String getCityTitle() {
		return getText(cityTitle);
		
	}
	
	public void chooseCity(String text) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".forcastMapWrap h2")));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".forcastMapWrap h2")));
		for (WebElement el : listOfCities) {
			String city = getText(el);
			if (city.contains(text)) {
				click(el);
				break;
				
			}
			
		}
	}
	
    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
}
