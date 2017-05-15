package org.serenitybdd.demo.control.fooling;

import static org.assertj.core.api.BDDAssertions.then;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;

@Narrative(text = { "As a serious employer, ",
		"I want my employees to be visually reminded whenever we detect they are fooling around. ",
		"I won’t tolerate banter or harmless prank jokes either." })
@RunWith(SerenityRunner.class)
public class WhenFoolingAroundIT {

	@Managed(driver = "chrome", uniqueSession = true)
	WebDriver driver;

	@Test
	public void pipotron_is_definitely_out_of_bounds() {
		driver.get("http://www.google.com");

		driver.findElement(By.name("q")).sendKeys("pipotron", Keys.ENTER);

		new WebDriverWait(driver, 5).until(titleContains("Google Search"));

		then(driver.findElement(By.linkText("Pipotron")).isDisplayed()).isTrue();
		
		driver.findElement(By.linkText("Pipotron")).click();
		
		then(driver.getTitle()).isEqualTo("BLOCKED BY PROXY");
	}
	
	@BeforeClass
	public static void setupClass() {
		ChromeDriverManager.getInstance().setup();
	}
	
}
