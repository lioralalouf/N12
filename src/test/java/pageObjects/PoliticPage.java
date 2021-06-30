package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PoliticPage extends BasePage{
	@FindBy(css = ".chat-on")
	private WebElement pageTitle;

	public PoliticPage(WebDriver driver) {
		super(driver);
		
	}
	public String getPageTitle() {
		return getText(pageTitle);
	}
}
