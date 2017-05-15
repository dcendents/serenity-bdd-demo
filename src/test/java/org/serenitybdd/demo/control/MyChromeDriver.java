package org.serenitybdd.demo.control;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.thucydides.core.webdriver.DriverSource;

public class MyChromeDriver implements DriverSource {

	public MyChromeDriver() {
	}

	@Override
	public WebDriver newDriver() {
		return new ChromeDriver();
	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}

}
