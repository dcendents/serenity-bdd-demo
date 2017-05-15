package org.serenitybdd.demo.control.productivity.tasks;


import static org.openqa.selenium.Keys.RETURN;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

import org.serenitybdd.demo.control.productivity.pages.GooglePage;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.thucydides.core.annotations.Step;

public class PerformSearch implements Task {

	private String toSearch;
	
	public PerformSearch(String value) {
		this.toSearch = value;
	}

	@Override
	@Step("{0} searches for #toSearch")
	public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
        		Enter.theValue(toSearch).into(GooglePage.SEARCH_INPUT),
        		Hit.the(RETURN).keyIn(GooglePage.SEARCH_INPUT)
        );
        
		BrowseTheWeb.as(theActor).waitFor(titleContains("Google Search"));
//		BrowseTheWeb.as(theActor).waitForRenderedElementsToBePresent(By.linkText(toSearch));
	}

	public static PerformSearch of(String value) {
		return Instrumented.instanceOf(PerformSearch.class).withProperties(value);
	}

}
