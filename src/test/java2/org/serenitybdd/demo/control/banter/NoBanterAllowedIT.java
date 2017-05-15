package org.serenitybdd.demo.control.banter;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.serenitybdd.demo.control.banter.steps.EmployeeSteps;
import org.serenitybdd.demo.control.fooling.WhenFoolingAroundIT;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;

@Story(WhenFoolingAroundIT.class)
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
	public void rickrolling_is_forbidden() {
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
