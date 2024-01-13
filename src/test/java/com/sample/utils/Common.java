package com.sample.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Define Common Class
 * 
 * @author Harshad Patel
 */
public class Common extends AbstractPage {
	public Common(WebDriver driver) {
		super(driver);
	}

	public WebDriverWait getWait() {
		// Set time in second to wait for elements
		return new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public WebElement waitUntilElementToBeClickable(By by) {

		try {
			return getWait().ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(by));

		} catch (StaleElementReferenceException e) {
			return getWait().ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(by));
		}

	}

	public WebElement waitUntilPresenceOfElementLocated(By by) {
		return getWait().ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static void takeSnapShot(WebDriver webdriver, String screenshotName) throws Exception {

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		// Copy file at destination
		String nameWithExtention = screenshotName + ".png";
		/* Copy screenshot to specific folder */
		try {
			String reportFolder = "target" + File.separator + "failsafe-reports" + File.separator + "chrome"
					+ File.separator;
			String screenshotsFolder = "screenshots";
			File screenshotFolder = new File(reportFolder + screenshotsFolder);
			if (!screenshotFolder.getAbsoluteFile().exists()) {
				screenshotFolder.mkdir();
			}
			File DestFile = new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile();
			FileUtils.copyFile(SrcFile, DestFile);
			Reporter.log("<a href='" + DestFile.getAbsolutePath() + "'> <img src='" + DestFile.getAbsolutePath()
					+ "' height='250' width='500'/> </a>");
		} catch (IOException e) {
			Reporter.log("Failed to capture screenshot: " + e.getMessage());
		}

	}

	/**
	 * Get the value of the given attribute of the element. Will return the current
	 * value, even if this has been modified after the page has been loaded.
	 * 
	 * 
	 * @param locator The locator of element to get its attribute value
	 * @return The attribute/property's current value or null if the value is not
	 *         set.
	 */
	public String getValue(String locator) {
		// pause(1);
		WebElement element = waitUntilPresenceOfElementLocated(By.xpath(locator));
		return element.getAttribute("value");
	}

	/**
	 * Assertion to check that two values are equal.
	 * 
	 * @param value1 Value-1.
	 * @param value2 Value-2.
	 * @throws InterruptedException
	 */
	public void assertTwoValuesAreEqual(Object value1, Object value2) throws InterruptedException {
		Assert.assertEquals(value1, value2);
	}

	/**
	 * Checks given element is being displayed or not on page.
	 * 
	 * @param locator the locator of element to be checked present or not
	 * 
	 * @return True if the element displayed, false otherwise
	 */
	public boolean isElementDisplayed(String locator) {
		try {
			WebElement element = this.findElement(locator);
			highlightElement(element);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check that given element is present or not.
	 * 
	 * @param xpath the xpath of element to be checked present or not
	 * 
	 * @return True if the element present, false otherwise
	 */

	public boolean existsElement(String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	/**
	 * Causes the currently executing thread to sleep (temporarily cease execution)
	 * for the specified number of seconds, subject to the precision and accuracy of
	 * system timers and schedulers. The thread does not lose ownership of any
	 * monitors.
	 * 
	 * @param seconds the time in second to pause execution
	 * @throws InterruptedException
	 */

	public void pause(int seconds) throws InterruptedException {
		Duration sec = Duration.ofSeconds(seconds);
		driver.manage().timeouts().implicitlyWait(sec);
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException interruptedException) {
		}
	}

	// Save Screenshot for the Report

	public void makeScreenshotForReport(WebDriver driver, String screenshotName) {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		/* Take a screenshot */
		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		String nameWithExtention = screenshotName + ".png";
		/* Copy screenshot to specific folder */
		try {
			String reportFolder = "target" + File.separator + "failsafe-reports" + File.separator;
			File screenshotFolder = new File(reportFolder);
			if (!screenshotFolder.getAbsoluteFile().exists()) {
				screenshotFolder.mkdir();
			}
			FileUtils.copyFile(screenshot,
					new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
		} catch (IOException e) {
			log("Failed to capture screenshot : " + e.getMessage());
		}
	}

	/**
	 * <p>
	 * Log the passed string to the HTML reports.
	 * </p>
	 * 
	 * <p>
	 * Print the passed string and then terminates the line.
	 * </p>
	 * 
	 * @param message the message to log and to print
	 */
	public void log(String message) {
		if (message.startsWith("Step")) {
			int stepcount = Base.steps.get();
			String msg[] = message.split("::");
			Reporter.log("Step " + stepcount + " : " + msg[1].trim());
			System.out.println("Step " + stepcount + " : " + msg[1].trim());
			Base.steps.set(stepcount + 1);
		} else {
			Reporter.log(message);
			System.out.println(message);
		}
	}

	public static int generateRandomInteger(int max) {
		Random random = new Random();
		return random.nextInt(max) + 1;
	}

	/**
	 * Highlight given element
	 * 
	 * @param element the element to be highlighted
	 * 
	 */
	public void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px solid red'", element);
	}

	public By findBy(String locator) {
		if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
			locator = locator.substring(5); // remove "link=" from locator
			if (locator.contains(" "))
				return By.partialLinkText(locator);
			return By.linkText(locator);
		} else if (locator.startsWith("id=")) {
			locator = locator.substring(3); // remove "id=" from locator
			return By.id(locator);
		} else if (locator.startsWith("//")) {
			return By.xpath(locator);
		} else if (locator.startsWith("#")) {
			return By.cssSelector(locator);
		} else if (locator.startsWith("name=")) {
			locator = locator.substring(5); // remove "name=" from locator
			return By.name(locator);
		} else if (locator.startsWith("class=")) {
			locator = locator.substring(6); // remove "class=" from locator
			return By.className(locator);
		} else if (locator.equalsIgnoreCase("body")) {
			return By.cssSelector(locator);
		} else {
			return By.id(locator);
		}
	}

	/**
	 * Find the first {@link WebElement} using the given method. This method is
	 * affected by the 'implicit wait' times in force at the time of execution. The
	 * findElement(..) invocation will return a matching row, or try again
	 * repeatedly until the configured timeout is reached.
	 * 
	 * 
	 * @param locator the locator to be used by locating mechanism to find element
	 * @return The first matching element on the current page
	 * @throws NoSuchElementException If no matching elements are found
	 * 
	 */
	public WebElement findElement(String locator) {
		if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
			locator = locator.substring(5); // remove "link=" from locator
			if (locator.contains(" "))
				return driver.findElement(By.partialLinkText(locator));
			return driver.findElement(By.linkText(locator));
		} else if (locator.startsWith("id=")) {
			locator = locator.substring(3); // remove "id=" from locator
			return driver.findElement(By.id(locator));
		} else if (locator.startsWith("//") || locator.startsWith("(//")) {
			return driver.findElement(By.xpath(locator));
		} else if (locator.startsWith("#")) {
			return driver.findElement(By.cssSelector(locator));
		} else if (locator.startsWith("name=")) {
			locator = locator.substring(5); // remove "name=" from locator
			return driver.findElement(By.name(locator));
		} else if (locator.startsWith("class=")) {
			locator = locator.substring(6); // remove "class=" from locator
			return driver.findElement(By.className(locator));
		} else if (locator.equalsIgnoreCase("body")) {
			return driver.findElement(By.cssSelector(locator));
		} else {
			return driver.findElement(By.id(locator));
		}
	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element,then select first option from list.
	 * 
	 * 
	 * @param locator    The locator of element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 * @throws InterruptedException
	 * 
	 */

	public void typeAndSelectFirst(String locator, String keysToSend) throws InterruptedException {
		WebElement element = waitUntilElementToBeClickable(findBy(locator));
		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
		pause(1);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
	}
	// Switch to second window

	public void switchToSecondWindow() {
		try {
			String current_window = driver.getWindowHandle();
			Set<String> allwindows = driver.getWindowHandles();
			int i = 0;
			for (String s : allwindows) {
				i = i + 1;
				if (i == 2) {
					driver.switchTo().window(s);
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	/**
	 * Click on given element. If this causes a new page to load, you should discard
	 * all references to given element and any further operations performed on given
	 * element will throw a StaleElementReferenceException.
	 * 
	 * There are some preconditions for an element to be clicked. the element must
	 * be visible and it must have a height and width greater then 0.
	 * 
	 * @param locator the locator of element to be clicked.
	 * @throws InterruptedException
	 */
	public void click(String locator) throws InterruptedException {
		WebElement element = waitUntilElementToBeClickable(findBy(locator));
		highlightElement(element);
		try {
			element.click();
		} catch (Exception e) {
		}
	}

	/**
	 * Clicks on visible or not visible element through javascript.
	 * 
	 * @param locator the locator of element to be clicked.
	 */
	public void jsClick(String locator) {
		WebElement element = waitUntilElementToBeClickable(findBy(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px solid red'", element);
		js.executeScript("return arguments[0].click();", element);

	}

	/**
	 * Clicks on visible or not visible element through javascript.
	 * 
	 * @param element the element to be clicked.
	 */
	public void jsClickWithoutWait(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].click();", element);

	}

	/**
	 * Get the visible (i.e. not hidden by CSS) text of given element, including
	 * sub-elements.
	 * 
	 * @param locator the locator of element from where to get visible text
	 * @return The visible text of given element.
	 * @throws InterruptedException
	 */

	public String getText(String locator) throws InterruptedException {
		WebElement element = this.findElement(locator);
		highlightElement(element);
		return element.getText();
	}

}
