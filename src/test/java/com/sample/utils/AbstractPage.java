package com.sample.utils;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage extends Base {

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}
	public int DRIVER_WAIT = 5;
	protected WebDriver driver;
	public String HOMEPAGE_LOGO="//a[contains(@class,'mmtLogo')]";
	public String HOMEPAGE_LOGIN="//li[contains(@class,'userLoggedOut')]";
	public String HOMEPAGE_LANGUAGE="//div[contains(@class,'langSlct')]";	
	public String SEARCH_BUTTON="//a[text()='Search']";
	public String FLIGHT_ICON="//a[contains(@href,'/flights/')]//span[text()='Flights']";
	public String ROUND_TRIP="//li[text()='Round Trip']";
	public String FROM_CITY="//input[@id='fromCity']";
	public String TO_CITY="//input[@id='toCity']";
	public String OPEN_FROM_CITY="//input[@placeholder='From']";
	public String OPEN_TO_CITY="//input[@placeholder='To']";
	public String SELECT_DATE="(//div[@class='DayPicker-Day'][@aria-disabled='false'])";
	public String SELECT_TRAVELLERS="//label[@for='travellers']";
	public String ADULTS2="(//ul[contains(@class,'guestCounter')])[1]//li[2]";
	public String APPLY="//button[text()='APPLY']";
	public String CROSS_ICON="//span[contains(@class,'overlayCrossIcon')]";
	public String LEFT_CITY="(//div[contains(@class,'listingCard ')]//div[@class='flexOne timeInfoLeft']//p[2])";
	public String RIGHT_CITY="(//div[contains(@class,'listingCard ')]//div[@class='flexOne timeInfoRight']//p[2])";
	public String SELECT_COUNTRY="//p[@class='selectConInput']";
	public String COUNTRY_USA="//p[text()='USA']";
	public String COUNTRY_UAE="//p[text()='UAE']";
	public String COUNTRY_INDIA="//p[text()='India']";
	public String CURRENCY_USD="//label[@for='usdCurr']";
	public String COUNTRY_APPLY="//button[text()='Apply']";
	public String COUNTRY_SPAN="(//span[contains(@class,'capText')]//span)[1]";
	public String LANG_SPAN="(//span[contains(@class,'capText')]//span)[2]";
	public String CURRENCY_SPAN="(//span[contains(@class,'capText')]//span)[3]";
	
	//offer page
	public String SUPER_OFFER="//div[@class='flexOne']//p[text()='Super Offers']";
	public String FLIGHT_RADIO="//label[@for='FLT']";
	public String HDFC_CHECKBOX="//label[@for='HDFC']";
	public String HDFC_LOGO="(//img[@alt='HDFC Bank'])";
	public String TRENDING_RADIO="//label[@for='TRENDING']";
	public String ICICI_CHECKBOX="//label[@for='ICICI']";
	public String ICICI_LOGO="(//img[@alt='ICICI Bank'])";
	public String HOTELS_RADIO="//label[@for='HTL']";
	public String AXIS_CHECKBOX="//label[@for='AXIS']";
	public String AXIS_LOGO="(//img[@alt='Axis Bank'])";
	
	}