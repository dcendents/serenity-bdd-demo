package org.serenitybdd.demo.control.productivity;

import static net.serenitybdd.screenplay.GivenWhenThen.and;
import static net.serenitybdd.screenplay.GivenWhenThen.andThat;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.serenitybdd.demo.control.productivity.questions.TheDisplayedPage;
import org.serenitybdd.demo.control.productivity.tasks.Open;
import org.serenitybdd.demo.control.productivity.tasks.OpenGoogle;
import org.serenitybdd.demo.control.productivity.tasks.PerformSearch;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;

@Narrative(text = { "As an employer, I want to maximise the return on every contract. ",
		"Employees performance should be kept at the minimum acceptable level." })
@RunWith(SerenityRunner.class)
public class BlockProductivityIT {

	private Actor james = Actor.named("James");
	
	@Managed(driver = "chrome", uniqueSession = true)
	WebDriver hisBrowser;

	@Steps
	OpenGoogle openGoogle;
	
	@Steps
	TheDisplayedPage theDisplayedPage;

	@Before
    public void jamesCanBrowseTheWeb() {
        james.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
	public void all_access_to_productivity_tools_must_be_blocked() {
    	givenThat(james).wasAbleTo(openGoogle);
    	andThat(james).wasAbleTo(PerformSearch.of("Productivity Tools News & Topics - Entrepreneur"));

        when(james).attemptsTo(Open.theLink("Productivity Tools News & Topics - Entrepreneur"));

        then(james).should(seeThat(theDisplayedPage, containsText("BLOCKED")));
        and(james).should(seeThat(theDisplayedPage, containsText("Productivity Tools")));
	}

	@BeforeClass
	public static void setupClass() {
		ChromeDriverManager.getInstance().setup();
	}

}
