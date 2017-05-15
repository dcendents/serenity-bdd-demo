package org.serenitybdd.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.thucydides.core.webdriver.DriverSource;

public class MyChromeDriver implements DriverSource {

	public MyChromeDriver() {
	}

	@Override
	public WebDriver newDriver() {
		Map<String, Object> chromeOptions = new HashMap<>();
		chromeOptions.put("args", Arrays.asList("--no-sandbox"));
		if (StringUtils.isNotBlank(System.getenv("CHROME_BIN"))) {
			chromeOptions.put("binary", System.getenv("CHROME_BIN"));
		}
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

		return new ChromeDriver(capabilities);
	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}

}
