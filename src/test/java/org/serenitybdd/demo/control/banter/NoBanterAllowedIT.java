package org.serenitybdd.demo.control.banter;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

@Narrative(text = { "As a serious employer, ", 
		"I won’t tolerate harmless banter that might improve team cohesions." })
@RunWith(SerenityRunner.class)
public class NoBanterAllowedIT {

	@Managed(driver = "chrome", uniqueSession = true)
	WebDriver driver;

	@ManagedPages
	Pages pages;

	@Steps
	public EmployeeSteps employee;

	@Test
	@Screenshots(beforeAndAfterEachStep = true)
	public void rickrolling_is_demeaning() {
		employee.opens_the_search_page();
		employee.searches_for("Let's Rickroll!");
		employee.dares_to_open_page("Let's Rickroll!");
		employee.should_be_reminded_site_is_blocked("Humor");
	}

	@BeforeClass
	public static void setupClass() {
		ChromeDriverManager.getInstance().setup();
	}

}
