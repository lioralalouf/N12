package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.HomePage;
import pageObjects.PoliticPage;
import pageObjects.WeatherPage;

public class HomeTest extends BaseTest {
	@Epic("HomePage")
	@Feature("sticky categories top bar")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As A user, I want to redirected to the right page after clicking on category")
	@Test(description = "clicking on politic category")
	@Description("after I clicked on category politic, I redirected to the right page")
	public void tc01_chooseCategory() {
		HomePage hp = new HomePage(driver);
		hp.chooseCategory("פוליטי");
		PoliticPage pp = new PoliticPage(driver);
		Assert.assertEquals(pp.getPageTitle(), "פוליטי");
		driver.navigate().back();
	}
	@Severity(SeverityLevel.NORMAL)
	@Story("As A user, If im scrolling down - Top bar should stay sticky")
	@Test(description = "check topbar is sticky")
	public void tc02_checkTopBarIsSticky() throws Exception {
		HomePage hp = new HomePage(driver);
		String before = hp.getCoordinates();
		hp.scrollDown();
		String after = hp.getCoordinates();
		Assert.assertEquals(before, after);
	}

	@Test(description = "check if date on the top menu equals to current date")
	@Severity(SeverityLevel.CRITICAL)
	@Story("date on top bar should be the same as current date")
	public void tc03_checkDateIsCorrect() {
		HomePage hp = new HomePage(driver);
		String actual = hp.actualDate();
		Assert.assertEquals(actual, hp.getCurrentDay());
	}

	@Test(description = "check clicking on weather link redirect the user to weather page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As A user, I want to redirected to the right page after clicking on weather link")
	public void tc04_moveToWeatherPage() {
		HomePage hp = new HomePage(driver);
		hp.moveToWeatherPage();
		WeatherPage wp = new WeatherPage(driver);
		System.out.println(wp.getWeatherTitle());
	}
}
