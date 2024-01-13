package com.sample.modules;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sample.utils.AbstractPage;
import com.sample.utils.Base;

public class OfferPage extends Base {
	AbstractPage ap = new AbstractPage(driver) {
	};

	@Test(groups = {
			"smoke" }, description = "Home Page:Verify filter functioality for HDFC bank's offers for flights on offers page.", enabled = true)

	public void verifyOfferPageFlightsHDFCFilter() throws InterruptedException {
		common.log("Step :: Open URL - https://www.makemytrip.com/");
		common.log("Step :: Click on super offer tab in header.");
		common.click(ap.SUPER_OFFER);

		common.log("Step :: Verify offer page opened.");
		common.switchToSecondWindow();
		Assert.assertTrue(driver.getCurrentUrl().contains("offers"));

		common.log("Step :: Click on flights radio button.");
		common.jsClick(ap.FLIGHT_RADIO);

		common.log("Step :: Click on hdfc checkbox.");
		common.jsClick(ap.HDFC_CHECKBOX);
		Thread.sleep(2000);

		common.log("Step :: Verify all offers have hdfc bank logo with terms and conditions.");
		int totalOffers = driver.findElements(By.xpath(ap.HDFC_LOGO)).size();
		for (int i = 1; i <= totalOffers; i++) {
			String logoXpath = ap.HDFC_LOGO + "[" + i + "]";
			Assert.assertTrue(common.isElementDisplayed(logoXpath));
		}
	}

	@Test(groups = {
			"smoke" }, description = "Home Page:Verify filter functioality for ICICI bank's offers for trendiing on offers page.", enabled = true)
	public void verifyOfferPageTrendingICICIFilter() throws InterruptedException {
		common.log("Step :: Open URL - https://www.makemytrip.com/");
		common.log("Step :: Click on super offer tab in header.");
		common.click(ap.SUPER_OFFER);

		common.log("Step :: Verify offer page opened.");
		common.switchToSecondWindow();
		Assert.assertTrue(driver.getCurrentUrl().contains("offers"));

		common.log("Step :: Click on trending radio button.");
		common.jsClick(ap.TRENDING_RADIO);

		common.log("Step :: Click on icici checkbox.");
		common.jsClick(ap.ICICI_CHECKBOX);
		Thread.sleep(2000);

		common.log("Step :: Verify all offers have icici bank logo with terms and conditions.");
		int totalOffers = driver.findElements(By.xpath(ap.ICICI_LOGO)).size();
		for (int i = 1; i <= totalOffers; i++) {
			String logoXpath = ap.ICICI_LOGO + "[" + i + "]";
			Assert.assertTrue(common.isElementDisplayed(logoXpath));
		}
	}

	@Test(groups = {
			"smoke" }, description = "Home Page:Verify filter functioality for Axis bank's offers for hotels on offers page.", enabled = true)
	public void verifyOfferPageHotelAxisFilter() throws InterruptedException {
		common.log("Step :: Open URL - https://www.makemytrip.com/");
		common.log("Step :: Click on super offer tab in header.");
		common.click(ap.SUPER_OFFER);

		common.log("Step :: Verify offer page opened.");
		common.switchToSecondWindow();
		Assert.assertTrue(driver.getCurrentUrl().contains("offers"));

		common.log("Step :: Click on hotels radio button.");
		common.jsClick(ap.HOTELS_RADIO);

		common.log("Step :: Click on axis checkbox.");
		common.jsClick(ap.AXIS_CHECKBOX);
		Thread.sleep(2000);

		common.log("Step :: Verify all offers have axis bank logo with terms and conditions.");
		int totalOffers = driver.findElements(By.xpath(ap.AXIS_LOGO)).size();
		for (int i = 1; i <= totalOffers; i++) {
			String logoXpath = ap.AXIS_LOGO + "[" + i + "]";
			Assert.assertTrue(common.isElementDisplayed(logoXpath));
		}
	}

}
