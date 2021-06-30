package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CityPage extends BasePage {
	@FindBy(css = "#neoLocalForcast > button > span:nth-child(2)")
	private WebElement cityTitle;

	public CityPage(WebDriver driver) {
		super(driver);
	}

	public String getCityTitle() {
		scrollMouse(cityTitle);
		return getText(cityTitle);
	}
}
