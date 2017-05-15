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
		"To slow down clever employees, block access to useful sites ",
		"and use some generic excuse."})
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
	public void access_to_random_useful_sites_must_be_blocked() {
    	givenThat(james).wasAbleTo(openGoogle);
    	andThat(james).wasAbleTo(PerformSearch.of("wsimport - with a proxy | Jeannot's Weblog", "site:jeannotsweblog.blogspot.co.uk"));

        when(james).attemptsTo(Open.theLink("wsimport - with a proxy | Jeannot's Weblog"));

        then(james).should(seeThat(theDisplayedPage, containsText("Access Denied")));
        and(james).should(seeThat(theDisplayedPage, containsText("categorization: \"Personal Sites\"")));
	}

	@BeforeClass
	public static void setupClass() {
		ChromeDriverManager.getInstance().setup();
	}

}
