package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.CityPage;
import pageObjects.HomePage;
import pageObjects.WeatherPage;

public class WeatherTest extends BaseTest {
	@DataProvider
	public Object[][] getData() {
		Object[][] myData = { { "חיפה" }, { "תל אביב - יפו" }, { "צפת" }, { "טבריה" }, { "ירושלים" }, { "אשדוד" }, { "אילת" }, { "באר שבע" }};
		return myData;
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Story("As A user, If I should see all cities on weather page")
	@Test(description = "check that all cities appear in weather page", dataProvider = "getData")
	public void tc01_checkCities(String city) {
		HomePage hp = new HomePage(driver);
		hp.moveToWeatherPage();
		WeatherPage wp = new WeatherPage(driver);
		boolean expected = wp.checkCities(city);
		Assert.assertTrue(expected);
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Story("As A user, After clicking on city - It should redirected me to the right city wather details")
	@Test(dataProvider = "getData", description = "check that every city redirect the user to the right page")
	public void tc02_redirectCityToRightPage(String city) {
		WeatherPage wp = new WeatherPage(driver);
		wp.chooseCity(city);
		CityPage cp = new CityPage(driver);
		String actual = cp.getCityTitle();
		String expected = city;
		Assert.assertEquals(actual, expected);
		driver.navigate().back();
		wp.waitForLoad(driver);
	}
}
