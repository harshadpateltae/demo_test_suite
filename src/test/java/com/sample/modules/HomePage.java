package com.sample.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sample.utils.*;

public class HomePage extends Base {

	AbstractPage ap = new AbstractPage(driver) {
	};

	@Test(groups = {
			"smoke" }, description = "Home Page:Verify logo, login and other section present in header.", enabled = true)
	public void vaerifyAllHeaderSectionsPresent() throws InterruptedException {
		common.log("Step :: Open URL - " + pr.getProperty("front_URL"));
		Thread.sleep(2000);
		common.log("Step :: Varify mmt logo present.");
		Assert.assertTrue(common.isElementDisplayed(ap.HOMEPAGE_LOGO));

		common.log("Step :: Varify mmt login section present.");
		Assert.assertTrue(common.isElementDisplayed(ap.HOMEPAGE_LOGIN));

		common.log("Step :: Varify mmt country & currency selection dropdown present.");
		Assert.assertTrue(common.isElementDisplayed(ap.HOMEPAGE_LANGUAGE));

		common.log("Step :: Varify mmt search section present.");
		Assert.assertTrue(common.isElementDisplayed(ap.HOMEPAGE_LANGUAGE));
	}

	@Test(groups = { "smoke" }, description = "Home Page:Verify country currency widget workinng fine.", enabled = true)
	public void vaerifyCountryCurrencyWidget() throws InterruptedException {
		common.log("Step :: Open URL - " + pr.getProperty("front_URL"));
		common.log("Step :: Varify mmt country & currency selection section present.");
		Assert.assertTrue(common.isElementDisplayed(ap.HOMEPAGE_LANGUAGE));

		common.log("Step :: Click on mmt country & currency selection section present.");
		common.click(ap.HOMEPAGE_LANGUAGE);

		common.log("Step :: Select country USA from dropdown.");
		common.click(ap.SELECT_COUNTRY);
		common.click(ap.COUNTRY_USA);

		common.log("Step :: Click on apply button.");
		common.click(ap.COUNTRY_APPLY);

		common.log("Step :: Verify language english annd currency USD selected.");
		common.assertTwoValuesAreEqual(common.getText(ap.COUNTRY_SPAN), "USA");
		common.assertTwoValuesAreEqual(common.getText(ap.LANG_SPAN), "ENG");
		common.assertTwoValuesAreEqual(common.getText(ap.CURRENCY_SPAN), "USD");

	}

	@Test(groups = {
			"smoke" }, description = "Home Page:Verify flight search functionality working fine.", enabled = true)
	public void verifySearchFlight() throws InterruptedException {
		common.log("Step :: Open URL - " + pr.getProperty("front_URL"));
		String fromCity = "Ahmedabad";
		String toCity = "Singapore";
		common.log("Step :: Click on flights logo.");
		common.click(ap.FLIGHT_ICON);

		common.log("Step :: Click on round trip radio button.");
		common.click(ap.ROUND_TRIP);

		common.log("Step :: Enter ahmedabad in from textbox.");
		common.click(ap.FROM_CITY);
		common.typeAndSelectFirst(ap.OPEN_FROM_CITY, fromCity);
		common.assertTwoValuesAreEqual(common.getValue(ap.FROM_CITY), fromCity);

		common.log("Step :: Enter singapre in to textbox.");
		common.click(ap.TO_CITY);
		common.typeAndSelectFirst(ap.OPEN_TO_CITY, toCity);
		common.assertTwoValuesAreEqual(common.getValue(ap.TO_CITY), toCity);

		common.log("Step :: Select  departure date from opend calander.");
		int allDepDates = driver.findElements(By.xpath(ap.SELECT_DATE)).size();
		String xpath = ap.SELECT_DATE + "[" + Common.generateRandomInteger(allDepDates) + "]";
		common.log(xpath);
		WebElement ele = driver.findElement(By.xpath(xpath));
		common.jsClickWithoutWait(ele);

		common.log("Step :: Select  return date from opend calander.");
		int allReturnDates = driver.findElements(By.xpath(ap.SELECT_DATE)).size();
		String xpathReturn = ap.SELECT_DATE + "[" + Common.generateRandomInteger(allReturnDates) + "]";
		WebElement element = driver.findElement(By.xpath(xpathReturn));
		common.jsClickWithoutWait(element);

		common.log("Step :: Click on select travellers.");
		common.click(ap.SELECT_TRAVELLERS);

		common.log("Step :: Select 2 adults");
		WebElement adult = driver.findElement(By.xpath(ap.ADULTS2));
		adult.click();

		common.log("Step :: Click on apply button.");
		common.click(ap.APPLY);

		common.log("Step :: Click on search button.");
		common.click(ap.SEARCH_BUTTON);

		Thread.sleep(20000);
		if (common.existsElement(ap.CROSS_ICON)) {
			common.click(ap.CROSS_ICON);
		}
		int totalFlights = driver.findElements(By.xpath(ap.LEFT_CITY)).size();
		if (totalFlights > 20) {
			totalFlights = 20;
		}

		common.log("Step :: Verify all flights shows from and to city as per selection while search.");
		for (int i = 1; i <= totalFlights; i++) {
			if (i % 2 == 1) {
				String xpathLeft = ap.LEFT_CITY + "[" + i + "]";
				String fromCityPage = common.getText(xpathLeft);
				common.log(fromCityPage + ":" + fromCity);
				common.assertTwoValuesAreEqual(common.getText(xpathLeft), fromCity);
				String xpathRight = ap.RIGHT_CITY + "[" + i + "]";
				String toCityPage = common.getText(xpathRight);
				common.log(toCityPage + ":" + toCity);
				common.assertTwoValuesAreEqual(common.getText(xpathRight), toCity);
			} else {
				String xpathLeft = ap.LEFT_CITY + "[" + i + "]";
				String toCityPage1 = common.getText(xpathLeft);
				common.log(toCityPage1 + ":" + toCity);
				common.assertTwoValuesAreEqual(common.getText(xpathLeft), toCity);
				String xpathRight = ap.RIGHT_CITY + "[" + i + "]";
				String fromCityPage1 = common.getText(xpathRight);
				common.log(fromCityPage1 + ":" + fromCity);
				common.assertTwoValuesAreEqual(common.getText(xpathRight), fromCity);
			}
		}
	}

}
